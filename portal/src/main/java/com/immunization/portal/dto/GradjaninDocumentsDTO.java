package com.immunization.portal.dto;

import java.util.List;

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
@XmlType(name = "gradjanin_documents", propOrder = {
        "interesovanje",
        "saglasnost",
        "zahtev",
        "sertifikat",
        "potvrda"
})
@XmlRootElement(name = "gradjanin_documents")
public class GradjaninDocumentsDTO {
    public List<String> interesovanje;
    public List<String> saglasnost;
    public List<String> zahtev;
    public List<String> sertifikat;
    public List<String> potvrda;
}