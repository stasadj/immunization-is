package com.immunization.portal.dao;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor 
public class ZahtevDAO {
	
    private Exist exist;
	
    public Optional<ZahtevZaSertifikat> retrieveById(String documentId) throws Exception {
        ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) exist.retrieveById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
        return zahtev == null ? Optional.empty() : Optional.of(zahtev);
	}

    public void save(String documentId, ZahtevZaSertifikat zahtev) throws Exception {
        exist.save(documentId, zahtev);
		
	}

}