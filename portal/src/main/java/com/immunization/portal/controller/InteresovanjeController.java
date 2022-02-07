package com.immunization.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/interesovanje")
public class InteresovanjeController {
	
    @Autowired
    private final InteresovanjeService interesovanjeService;
	
	@PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<IskazivanjeInteresovanjaZaVakcinaciju> create(@RequestBody IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
        return new ResponseEntity<IskazivanjeInteresovanjaZaVakcinaciju>(this.interesovanjeService.create(interesovanje), HttpStatus.OK);
    }

}
