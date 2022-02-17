package com.immunization.portal.controller;

import javax.validation.Valid;

import com.immunization.portal.dto.UserRegistrationDTO;
import com.immunization.portal.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
public class UserController {
    private UserService userService;

    @ResponseBody
    @PostMapping(value="/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
        String token = userService.registerUser(dto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
