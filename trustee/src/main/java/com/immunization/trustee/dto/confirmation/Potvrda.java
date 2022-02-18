package com.immunization.trustee.dto.confirmation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "uuid", "datum", "doza", "tip" })
@XmlRootElement(name = "potvrda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Potvrda {
    @XmlElement(name = "uuid")
    private String uuid;
    @XmlElement(name = "datum")
    private String datum;
    @XmlElement(name = "doza")
    private String doza;
    @XmlElement(name = "tip")
    private String tip;
}
