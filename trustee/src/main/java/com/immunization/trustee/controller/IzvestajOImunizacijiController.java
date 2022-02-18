package com.immunization.trustee.controller;

import com.immunization.common.controller.DocumentController;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.trustee.service.IzvestajOImunizacijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/immunization-report", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class IzvestajOImunizacijiController extends DocumentController<IzvestajOImunizaciji> {

	@Autowired
	public IzvestajOImunizacijiController(IzvestajOImunizacijiService documentService) {
		super(documentService);
	}

	@GetMapping
	public ResponseEntity<IzvestajOImunizaciji> getImmunizationReport(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
		return new ResponseEntity<>(((IzvestajOImunizacijiService) documentService).getImmunizationReport(startDate, endDate),
				HttpStatus.OK);
	}
}
