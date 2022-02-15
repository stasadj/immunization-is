package com.immunization.common.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_login", propOrder = {
        "username",
        "password"
})
public class LoginDTO {
    @NotNull(message = "Username is missing")
    private String username;

    @NotNull(message = "Password is missing")
    private String password;
}
