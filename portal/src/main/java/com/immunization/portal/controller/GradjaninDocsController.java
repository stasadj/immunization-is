package com.immunization.portal.controller;


import com.immunization.common.model.User;
import com.immunization.portal.dto.GradjaninDocumentsDTO;
import com.immunization.portal.service.GradjaninDocsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
@RequestMapping(value = "/api/dokumenti-gradjanina", produces = MediaType.APPLICATION_XML_VALUE + ";charset=utf-8") 
public class GradjaninDocsController {
    private GradjaninDocsService docsService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<GradjaninDocumentsDTO> getGradjaninDocuments(@AuthenticationPrincipal User user) throws Exception{
        return new ResponseEntity<GradjaninDocumentsDTO>(this.docsService.getAllGradjaninDocuments(user.getUsername()), HttpStatus.OK);
    }


}
