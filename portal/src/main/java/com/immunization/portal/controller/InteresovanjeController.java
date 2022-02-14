package com.immunization.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.portal.service.InteresovanjeService;

import lombok.AllArgsConstructor; 

@RestController
@AllArgsConstructor 
@RequestMapping(value = "api/interesovanje") 
public class InteresovanjeController { 
	
    private final InteresovanjeService interesovanjeService; 

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Void> create(@RequestBody IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
        this.interesovanjeService.create(interesovanje);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
 
}
