package com.immunization.portal.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InteresovanjeDAO {

	private Exist exist;
    private static final String INTERESOVANJE_NAMESPACE = "http://www.ftn.uns.ac.rs/interesovanje/";


	public Optional<IskazivanjeInteresovanjaZaVakcinaciju> retrieveById(String documentId) throws Exception {
		IskazivanjeInteresovanjaZaVakcinaciju interesovanje = (IskazivanjeInteresovanjaZaVakcinaciju) exist
				.retrieveById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
		return interesovanje == null ? Optional.empty() : Optional.of(interesovanje);
	}

    public List<IskazivanjeInteresovanjaZaVakcinaciju> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//inte:interesovanje[inte:pacijent[@about='" + about + "']]";

        return  exist.query(xpathExp, IskazivanjeInteresovanjaZaVakcinaciju.class, INTERESOVANJE_NAMESPACE, "inte").stream()
				.map(o -> (IskazivanjeInteresovanjaZaVakcinaciju) o).collect(Collectors.toList());

	}

	public void save(String documentId, IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
		exist.save(documentId, interesovanje);

	}

}
