package com.immunization.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "attribute")
public class AttributeDTO {
    private String key, value;
}
