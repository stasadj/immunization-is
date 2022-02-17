package com.immunization.portal.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor 
public class ZahtevDAO {
	
    private Exist exist;

    private static final String ZAHTEV_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/";
	
    public Optional<ZahtevZaSertifikat> retrieveById(String documentId) throws Exception {
        ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) exist.retrieveById(documentId, ZahtevZaSertifikat.class);
        return zahtev == null ? Optional.empty() : Optional.of(zahtev);
	}

    public List<ZahtevZaSertifikat> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//zaht:zahtev_za_sertifikat[zaht:podnosilac_zahteva[@about='" + about + "']]";

        return  exist.query(xpathExp, ZahtevZaSertifikat.class, ZAHTEV_NAMESPACE, "zaht").stream()
				.map(o -> (ZahtevZaSertifikat) o).collect(Collectors.toList());

	}

    public void save(String documentId, ZahtevZaSertifikat zahtev) throws Exception {
        exist.save(documentId, zahtev);
		
	}

}