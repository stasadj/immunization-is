package com.immunization.portal.service;

import com.immunization.portal.exception.UserAlreadyExistsException;
import com.immunization.portal.dto.UserRegistrationDTO;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean registerUser(UserRegistrationDTO dto) throws UserAlreadyExistsException {
        // Check if user exists
        if (usernameTaken(dto.getUsername())) {
            throw new UserAlreadyExistsException("Username already taken");
        }
        if (emailTaken(dto.getEmail())) {
            throw new UserAlreadyExistsException("Email already taken");
        }

        // TODO: Create user bean
        // TODO: Save to DB
        
        return true;
    }

    private boolean emailTaken(String email) {
        // TODO: Check email exists
        return false;
    }

    private boolean usernameTaken(String username) {
        // TODO: Check username exists
        return false;
    }
    
}
