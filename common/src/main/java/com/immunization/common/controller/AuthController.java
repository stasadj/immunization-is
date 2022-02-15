package com.immunization.common.controller;

import javax.validation.Valid;

import com.immunization.common.dto.LoginDTO;
import com.immunization.common.exception.base.ForbiddenException;
import com.immunization.common.model.User;
import com.immunization.common.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO credentials) {
        String token = authService.login(credentials);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping(value = "/whoami")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> whoami(@AuthenticationPrincipal User user) {
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new ForbiddenException("Fobidden");
        }
    }

}
