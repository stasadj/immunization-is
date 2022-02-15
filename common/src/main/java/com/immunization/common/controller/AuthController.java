package com.immunization.common.controller;

import javax.validation.Valid;

import com.immunization.common.dto.LoginDTO;
import com.immunization.common.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/auth", consumes = MediaType.APPLICATION_XML_VALUE
        + ";charset=utf-8", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class AuthController {
    private final AuthService authService;

    @PostMapping(value="/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO credentials) {
        String token = authService.login(credentials);
        
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    
}
