
package com.immunization.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.portal.service.ZahtevService;

import lombok.AllArgsConstructor; 

@RestController
@AllArgsConstructor 
@RequestMapping(value = "api/zahtev-za-sertifikat") 
public class ZahtevController { 
	
    private final ZahtevService zahtevService; 

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<ZahtevZaSertifikat> create(@RequestBody ZahtevZaSertifikat zahtev) throws Exception {
        return new ResponseEntity<>(this.zahtevService.create(zahtev), HttpStatus.OK);
    }
 
}

