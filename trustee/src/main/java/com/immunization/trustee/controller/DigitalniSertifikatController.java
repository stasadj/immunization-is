package com.immunization.trustee.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.trustee.service.DigitalniSertifikatService;

@RestController
@RequestMapping(value = "/api/certificate", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class DigitalniSertifikatController extends DocumentController<DigitalniSertifikat> {

    @Autowired
    public DigitalniSertifikatController(DigitalniSertifikatService documentService) {
        super(documentService);
    }
}
