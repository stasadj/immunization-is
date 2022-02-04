package com.immunization.portal.controller;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.repository.Exist;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/api/test", produces = MediaType.TEXT_XML_VALUE)
public class TestController {
    private final Exist exist;
    
    @ResponseBody
    @GetMapping
    public DigitalniSertifikat get() throws Exception {
        return (DigitalniSertifikat) exist.retrieveById("ds0.xml", DigitalniSertifikat.class);
    }
}
