package com.immunization.portal.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_registration", propOrder = {
    "email",
    "username",
    "password",
})
@XmlRootElement(name = "user_registration")
public class UserRegistrationDTO {
    private String email;
    private String username, password;
}
