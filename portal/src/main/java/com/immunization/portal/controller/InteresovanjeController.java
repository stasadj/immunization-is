package com.immunization.portal.controller;

import com.immunization.common.model.User;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.portal.service.InteresovanjeService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@AllArgsConstructor 
@RequestMapping(value = "api/interesovanje") 
public class InteresovanjeController { 
	
    private final InteresovanjeService interesovanjeService; 

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Void> create(@RequestBody IskazivanjeInteresovanjaZaVakcinaciju interesovanje, @AuthenticationPrincipal User user) throws Exception {
        this.interesovanjeService.create(interesovanje, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/{documentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable String documentId) throws Exception {
        ByteArrayInputStream stream = interesovanjeService.generatePdf(documentId);
        if (stream == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=details.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(stream));
    }

    @GetMapping(value = "/xhtml/{documentId}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> getXhtml(@PathVariable String documentId) throws Exception {
        ByteArrayInputStream stream = interesovanjeService.generateXhtml(documentId);
        if (stream == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=details.xhtml");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.TEXT_HTML)
                .body(new InputStreamResource(stream));
    }

}
