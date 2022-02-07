package com.immunization.portal.controller;

import com.immunization.portal.dto.UserRegistrationDTO;
import com.immunization.portal.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
public class UserController {
    private UserService userService;

    @ResponseBody
    @PutMapping(value="/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserRegistrationDTO dto) {
        if (userService.registerUser(dto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
