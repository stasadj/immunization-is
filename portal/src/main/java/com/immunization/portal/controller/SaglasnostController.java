package com.immunization.portal.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.User;
import com.immunization.common.model.saglasnost.EvidencijaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.portal.service.SaglasnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/consent", consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class SaglasnostController extends DocumentController<ObrazacSaglasnostiZaImunizaciju> {

    @Autowired
    public SaglasnostController(SaglasnostService documentService) {
        super(documentService);
    }

    @PutMapping(value = "/")
    @PreAuthorize("hasRole('GRADANIN')")
    public ResponseEntity<Void> create(@AuthenticationPrincipal User user, @RequestBody ObrazacSaglasnostiZaImunizaciju form) throws Exception {
        documentService.create(form, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/vaccination-record/:documentId")
    @PreAuthorize("hasRole('ZDRAVSTVENI_RADNIK')")
    public ResponseEntity<Void> addVaccinationRecord(@RequestBody EvidencijaOVakcinaciji evidencija, @PathVariable String documentId) throws Exception {
        ((SaglasnostService)documentService).addVaccinationRecord(evidencija, documentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
