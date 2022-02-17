package com.immunization.portal.service;

import java.util.ArrayList;
import java.util.List;

import com.immunization.common.dao.DigitalniSertifikatDAO;
import com.immunization.common.dao.IskazivanjeInteresovanjaZaVakcinacijuDAO;
import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.dao.ObrazacSaglasnostiZaImunizacijuDAO;
import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.portal.dto.GradjaninDocumentsDTO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradjaninDocsService {
    private ZahtevZaSertifikatDAO zahtevDAO;
    private IskazivanjeInteresovanjaZaVakcinacijuDAO interesovanjeDAO;
    private DigitalniSertifikatDAO sertifikatDAO;
    private PotvrdaOVakcinacijiDAO potvrdaDAO;
    private ObrazacSaglasnostiZaImunizacijuDAO saglasnostDAO;


    public GradjaninDocumentsDTO getAllGradjaninDocuments(String gradjaninUsername) throws Exception{

        GradjaninDocumentsDTO docs = new GradjaninDocumentsDTO();

        //zahtevi
        docs.zahtev = new ArrayList<String>();
        zahtevDAO.getByUsername(gradjaninUsername).forEach(doc -> {
            getIdFromAboutAndAddToList(doc.getAbout(), docs.zahtev);
        });

        //interesovanja
        docs.interesovanje = new ArrayList<String>();
        interesovanjeDAO.getByUsername(gradjaninUsername).forEach(doc -> {
            getIdFromAboutAndAddToList(doc.getAbout(), docs.interesovanje);
        });

        //saglasnosti
        docs.saglasnost = new ArrayList<String>();
        saglasnostDAO.getByUsername(gradjaninUsername).forEach(doc -> {
            getIdFromAboutAndAddToList(doc.getAbout(), docs.saglasnost);
        });

        //potvrde
        docs.potvrda = new ArrayList<String>();
        potvrdaDAO.getByUsername(gradjaninUsername).forEach(doc -> {
            getIdFromAboutAndAddToList(doc.getAbout(), docs.potvrda);
        });

        //digitalni sertifikati
        docs.sertifikat = new ArrayList<String>();
        sertifikatDAO.getByUsername(gradjaninUsername).forEach(doc -> {
            getIdFromAboutAndAddToList(doc.getAbout(), docs.sertifikat);
        });

        return docs;
    }


    private void getIdFromAboutAndAddToList(String about, List<String> list){
        String id = about.replaceAll("http://www.ftn.uns.ac.rs/", "");
        System.out.println(id); //for testing
        list.add(id); 

    }

    
}
