package com.immunization.portal.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MyDocuments", propOrder = {
        "interesovanje",
        "saglasnost",
        "zahtev",
        "sertifikat",
        "potvrda"
})
public class GradjaninDocuments {
    public List<String> interesovanje;
    public List<String> saglasnost;
    public List<String> zahtev;
    public List<String> sertifikat;
    public List<String> potvrda;
}