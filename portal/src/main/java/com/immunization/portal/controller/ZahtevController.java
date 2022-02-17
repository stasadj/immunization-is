
package com.immunization.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.common.model.User;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.portal.service.ZahtevService;

import lombok.AllArgsConstructor; 

@RestController
@AllArgsConstructor 
@RequestMapping(value = "api/zahtev-za-sertifikat") 
public class ZahtevController { 
	
    private final ZahtevService zahtevService; 

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Void> create(@RequestBody ZahtevZaSertifikat zahtev, @AuthenticationPrincipal User user) throws Exception {
        this.zahtevService.create(zahtev, user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
 
}

