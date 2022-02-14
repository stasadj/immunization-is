package com.immunization.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.immunization.common.dto.AttributeDTO;
import com.immunization.common.dto.ErrorDTO;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlErrorController extends AbstractErrorController {

    public XmlErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @ResponseBody
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_XML_VALUE)
    public ErrorDTO handleError(HttpServletRequest request) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, ErrorAttributeOptions.defaults());

        List<AttributeDTO> attributes = new ArrayList<>();
        errorAttributes.forEach((key, value) -> {
            AttributeDTO attribute = new AttributeDTO();
            attribute.setKey(key);
            attribute.setValue(value == null ? "" : value.toString());
            attributes.add(attribute);
        });
        ErrorDTO error = new ErrorDTO();
        error.setAttributes(attributes);
        return error;
    }
}
