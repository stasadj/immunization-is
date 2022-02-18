package com.immunization.trustee.controller;

import com.immunization.common.model.VaccineAmount;
import com.immunization.trustee.dto.vaccine.VaccineReport;
import com.immunization.trustee.service.VaccineAmountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/vaccine", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8")
public class VaccineAmountController {
    private VaccineAmountService vaccineAmountService;

    @PostMapping
    public ResponseEntity<Void> updateAmount(@RequestBody VaccineAmount vaccineAmount) throws Exception {
        vaccineAmountService.updateAmount(vaccineAmount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<VaccineReport> getAll() throws Exception {
        VaccineReport vaccineReport = new VaccineReport();
        vaccineReport.vaccine = vaccineAmountService.getAll();
        return new ResponseEntity<>(vaccineReport, HttpStatus.OK);
    }
}
