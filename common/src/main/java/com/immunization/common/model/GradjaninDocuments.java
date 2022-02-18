package com.immunization.common.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_documents", propOrder = {
        "interesovanje",
        "saglasnost",
        "zahtev",
        "sertifikat",
        "potvrda"
})
@XmlRootElement(name = "user_documents")
public class GradjaninDocuments {
    private List<String> interesovanje;
    private List<String> saglasnost;
    private List<String> zahtev;
    private List<String> sertifikat;
    private List<String> potvrda;

    public boolean hasDocument(String id) {
        return interesovanje.contains(id) || saglasnost.contains(id)
                || zahtev.contains(id) || sertifikat.contains(id) || potvrda.contains(id);
    }

    public GradjaninDocuments() {
        interesovanje = new ArrayList<>();
        saglasnost = new ArrayList<>();
        zahtev = new ArrayList<>();
        sertifikat = new ArrayList<>();
        potvrda = new ArrayList<>();
    }
}