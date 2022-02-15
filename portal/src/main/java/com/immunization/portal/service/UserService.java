package com.immunization.portal.service;

import com.immunization.portal.exception.UserAlreadyExistsException;
import com.immunization.portal.util.NumberStringGenerator;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.model.User;
import com.immunization.common.model.User.ERole;
import com.immunization.common.util.TokenUtils;
import com.immunization.portal.dto.UserRegistrationDTO;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtils tokenUtils;

    private String generateUsername(UserRegistrationDTO dto) {
        StringBuilder sb = new StringBuilder();
        sb.append(dto.getFirstName().replace(" ", "")).append('.').append(dto.getLastName().replace(" ", ""));
        sb.append(NumberStringGenerator.generateNumberSequence(4));

        return sb.toString();
    }

    public String registerUser(UserRegistrationDTO dto) throws UserAlreadyExistsException {
        if (emailTaken(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already taken");
        }

        // Generate unique password
        String generatedUsername;
        do {
            generatedUsername = generateUsername(dto);
        } while (usernameTaken(generatedUsername));

        // Create user bean
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(ERole.GRADANIN);
        user.setUsername(generatedUsername);

        // Save to DB
        userDAO.save(user);

        return tokenUtils.generateToken(user.getUsername());
    }

    private boolean emailTaken(String email) {
        return userDAO.getByEmail(email).isEmpty() == false;
    }

    private boolean usernameTaken(String username) {
        return userDAO.getByUsername(username).isEmpty() == false;
    }

}
