package com.immunization.trustee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.trustee.dto.confirmation.PotvrdeOVakcinaciji;
import com.immunization.trustee.service.PotvrdaOVakcinacijiService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/confirmation", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
@AllArgsConstructor
public class PotvrdaOVakcinacijiController {
	private final PotvrdaOVakcinacijiService potvrdaOVakcinacijiService;

	@GetMapping
	public ResponseEntity<PotvrdeOVakcinaciji> getAllConfirmationsForUser(@RequestParam String jmbg)
			throws Exception {
		return new ResponseEntity<>(potvrdaOVakcinacijiService.getAllConfirmationsForUser(jmbg), HttpStatus.OK);
	}
}
