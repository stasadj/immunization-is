package com.immunization.portal.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.portal.service.PotvrdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/potvrda")
public class PotvrdaController extends DocumentController<PotvrdaOVakcinaciji> {

    @Autowired
    protected PotvrdaController(PotvrdaService documentService) {
        super(documentService);
    }

}
