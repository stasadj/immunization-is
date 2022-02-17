package com.immunization.portal.service;

import java.util.List;

import com.immunization.common.dao.DigitalniSertifikatDAO;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.portal.dao.ZahtevDAO;
import com.immunization.portal.dao.InteresovanjeDAO;
import com.immunization.portal.dao.PotvrdaDAO;
import com.immunization.portal.dao.SaglasnostDAO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradjaninDocsService {
    private ZahtevDAO zahtevDAO;
    private InteresovanjeDAO interesovanjeDAO;
    private DigitalniSertifikatDAO sertifikatDAO;
    private PotvrdaDAO potvrdaDAO;
    private SaglasnostDAO saglasnostDAO;


    public void getAllGradjaninDocuments(String gradjaninUsername){
        //TODO get all patient docs 

    }

    
}
