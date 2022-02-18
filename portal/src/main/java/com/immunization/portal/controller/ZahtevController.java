package com.immunization.portal.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.User;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.DocumentService;
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
@RequestMapping(value = "api/zahtev-za-sertifikat")
public class ZahtevController extends DocumentController<ZahtevZaSertifikat> {

    @Autowired
    public ZahtevController(DocumentService<ZahtevZaSertifikat> documentService) {
        super(documentService);
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    ResponseEntity<Void> create(@RequestBody ZahtevZaSertifikat zahtev, @AuthenticationPrincipal User user) throws Exception {
        documentService.create(zahtev, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
