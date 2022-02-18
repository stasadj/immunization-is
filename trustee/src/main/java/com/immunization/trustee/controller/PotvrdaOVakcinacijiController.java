package com.immunization.trustee.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.trustee.dto.confirmation.Potvrde;
import com.immunization.trustee.service.PotvrdaOVakcinacijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/confirmation", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class PotvrdaOVakcinacijiController extends DocumentController<PotvrdaOVakcinaciji> {

    @Autowired
    public PotvrdaOVakcinacijiController(PotvrdaOVakcinacijiService documentService) {
        super(documentService);
    }

    @GetMapping
    public ResponseEntity<Potvrde> getAllConfirmationsForUser(@RequestParam String jmbg) throws Exception {
        return new ResponseEntity<>(((PotvrdaOVakcinacijiService) documentService).getAllDTOConfirmationsForUser(jmbg),
                HttpStatus.OK);
    }
}
