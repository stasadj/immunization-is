package com.immunization.common.controller;

import com.immunization.common.service.DocumentService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;

public abstract class DocumentController<T> {
    protected final DocumentService<T> documentService;

    protected DocumentController(DocumentService<T> documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = "/pdf/{documentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable String documentId) throws Exception {
        ByteArrayInputStream stream = documentService.generatePdf(documentId);
        if (stream == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=details.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(stream));
    }

    @GetMapping(value = "/xhtml/{documentId}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> getXhtml(@PathVariable String documentId) throws Exception {
        ByteArrayInputStream stream = documentService.generateXhtml(documentId);
        if (stream == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=details.xhtml");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.TEXT_HTML)
                .body(new InputStreamResource(stream));
    }

}
