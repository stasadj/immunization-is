package com.immunization.trustee.controller;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.trustee.service.ImmunizationReportService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/immunization-report", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
@AllArgsConstructor
public class ImmunizationReportController {
	private final ImmunizationReportService immunizationReportService;

	@GetMapping
	public ResponseEntity<IzvestajOImunizaciji> getImmunizationReport(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
			throws DatatypeConfigurationException {
		return new ResponseEntity<>(immunizationReportService.getImmunizationReport(startDate, endDate), HttpStatus.OK);
	}

}
