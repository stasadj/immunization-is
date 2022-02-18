package com.immunization.trustee.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.trustee.dto.request.Zahtevi;
import com.immunization.trustee.dto.response.Odgovor;
import com.immunization.trustee.service.ZahtevZaSertifikatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/certificate-request", produces = MediaType.APPLICATION_XML_VALUE
        + ";charset=utf-8")
public class ZahtevZaSertifikatController extends DocumentController<ZahtevZaSertifikat> {

    @Autowired
    public ZahtevZaSertifikatController(ZahtevZaSertifikatService documentService) {
        super(documentService);
    }

    @GetMapping(value = "/pending")
    public ResponseEntity<Zahtevi> getAllPendingRequests() throws Exception {
        return new ResponseEntity<>(((ZahtevZaSertifikatService) documentService).getAllPendingRequests(),
                HttpStatus.OK);
    }

    @PostMapping(value = "/accept")
    public ResponseEntity<DigitalniSertifikat> accept(@Valid @RequestBody Odgovor odgovor) throws Exception {
        return new ResponseEntity<>(((ZahtevZaSertifikatService) documentService).accept(odgovor), HttpStatus.OK);
    }

    @PostMapping(value = "/reject")
    public ResponseEntity<Void> reject(@Valid @RequestBody Odgovor odgovor) throws Exception {
        ((ZahtevZaSertifikatService) documentService).reject(odgovor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
