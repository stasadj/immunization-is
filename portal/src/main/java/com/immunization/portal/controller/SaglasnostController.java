package com.immunization.portal.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.User;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.portal.service.SaglasnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/consent", consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class SaglasnostController extends DocumentController<ObrazacSaglasnostiZaImunizaciju> {

    @Autowired
    public SaglasnostController(SaglasnostService documentService) {
        super(documentService);
    }

    @PutMapping(value = "/")
    @PreAuthorize("hasRole('GRADANIN')")
    public ResponseEntity<Void> immunizationConsent(@AuthenticationPrincipal User user, @RequestBody ObrazacSaglasnostiZaImunizaciju form) throws Exception {
        documentService.create(form, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
