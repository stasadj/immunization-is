package com.immunization.portal.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.User;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.portal.service.InteresovanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/interesovanje")
public class InteresovanjeController extends DocumentController<IskazivanjeInteresovanjaZaVakcinaciju> {

    @Autowired
    public InteresovanjeController(InteresovanjeService documentService) {
        super(documentService);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
    ResponseEntity<Void> create(@RequestBody IskazivanjeInteresovanjaZaVakcinaciju interesovanje, @AuthenticationPrincipal User user) throws Exception {
        documentService.create(interesovanje, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
