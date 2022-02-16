package com.immunization.trustee.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.trustee.dto.response.Odgovor;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/certificate-request", produces = MediaType.APPLICATION_XML_VALUE
		+ ";charset=utf-8", consumes = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
@AllArgsConstructor
public class ZahtevZaSertifikatController {
	@PostMapping(value = "/accept")
	public ResponseEntity<Void> accept(@Valid @RequestBody Odgovor odgovor) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/reject")
	public ResponseEntity<Void> reject(@Valid @RequestBody Odgovor odgovor) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
