package com.immunization.portal.service;

import com.immunization.portal.exception.UserAlreadyExistsException;
import com.immunization.portal.service.email.PortalEmailService;
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
    private final PortalEmailService emailService;

    private String generateUsername(UserRegistrationDTO dto) {
        return dto.getFirstName().replace(" ", "") + '.' + dto.getLastName().replace(" ", "") +
                NumberStringGenerator.generateNumberSequence(4);
    }

    public String registerUser(UserRegistrationDTO dto) throws Exception {
        if (emailTaken(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already taken");
        }

        // Generate unique username
        String generatedUsername;
        do {
            generatedUsername = generateUsername(dto);
        } while (usernameTaken(generatedUsername));

        // Create user bean
        ERole userRole = ERole.GRADANIN;

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(userRole);
        user.setUsername(generatedUsername);

        // Save to DB
        userDAO.save(user);

        sendEmail(user);

        return tokenUtils.generateToken(user.getUsername(), userRole);
    }

    private void sendEmail(User user) {
        emailService.sendRegistrationSuccess(user);
    }

    private boolean emailTaken(String email) throws Exception {
        return !userDAO.getByEmail(email).isEmpty();
    }

    private boolean usernameTaken(String username) throws Exception {
        return !userDAO.getByUsername(username).isEmpty();
    }

}
