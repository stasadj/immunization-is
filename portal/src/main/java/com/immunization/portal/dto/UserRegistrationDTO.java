package com.immunization.portal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
    "firstName",
    "lastName",
    "password",
})
@XmlRootElement(name = "user_registration")
public class UserRegistrationDTO {
    @NotNull(message = "Email is missing")
    @Email(message = "Email needs to be valid")
    private String email;

    @NotNull(message = "Password is missing")
    private String password;
    
    @XmlElement(name = "first_name")
    @NotNull(message = "First name is missing")
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull(message = "Last name is missing")
    private String lastName;
}
