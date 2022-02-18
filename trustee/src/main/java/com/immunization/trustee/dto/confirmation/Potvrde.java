package com.immunization.trustee.dto.confirmation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "potvrda" })
@XmlRootElement(name = "potvrde")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Potvrde {
    private List<Potvrda> potvrda;
}
