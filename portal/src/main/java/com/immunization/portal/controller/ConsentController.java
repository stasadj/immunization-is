package com.immunization.portal.controller;

import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.portal.service.ConsentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/consent", consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class ConsentController {
    private ConsentService consentService;

    // TODO: Add authorization here for patients
    @PutMapping(value = "/")
    public ResponseEntity<Void> immunizationConsent(@RequestBody ObrazacSaglasnostiZaImunizaciju form)
            throws Exception {
        if (consentService.fileConsent(form)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
