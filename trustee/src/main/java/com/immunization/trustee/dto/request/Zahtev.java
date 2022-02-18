package com.immunization.trustee.dto.request;

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
@XmlType(name = "", propOrder = { "uuid", "datum", "jmbg" })
@XmlRootElement(name = "zahtev")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Zahtev {
    @XmlElement(name = "uuid")
    private String uuid;
    @XmlElement(name = "datum")
    private String datum;
    @XmlElement(name = "jmbg")
    private String jmbg;
}
