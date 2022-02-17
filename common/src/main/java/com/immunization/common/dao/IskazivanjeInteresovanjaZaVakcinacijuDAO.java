package com.immunization.common.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IskazivanjeInteresovanjaZaVakcinacijuDAO {
	private final Exist exist;
	private static final String INTEREST_NAMESPACE = "http://www.ftn.uns.ac.rs/interesovanje/";

	public long getNumberOfDocumentsOfInterest(String startDate, String endDate) throws Exception {

		String xpathExp = "//inte:iskazivanje_interesovanja_za_vakcinaciju[number(translate(@datum,'-',''))>="
				+ startDate + " and number(translate(@datum,'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, IskazivanjeInteresovanjaZaVakcinaciju.class, INTEREST_NAMESPACE, "inte");
	}

    public Optional<IskazivanjeInteresovanjaZaVakcinaciju> retrieveById(String documentId) throws Exception {
		IskazivanjeInteresovanjaZaVakcinaciju interesovanje = (IskazivanjeInteresovanjaZaVakcinaciju) exist
				.retrieveById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
		return interesovanje == null ? Optional.empty() : Optional.of(interesovanje);
	}

    public List<IskazivanjeInteresovanjaZaVakcinaciju> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//inte:iskazivanje_interesovanja_za_vakcinaciju[inte:pacijent[@about='" + about + "']]";

        return  exist.query(xpathExp, IskazivanjeInteresovanjaZaVakcinaciju.class, INTEREST_NAMESPACE, "inte").stream()
				.map(o -> (IskazivanjeInteresovanjaZaVakcinaciju) o).collect(Collectors.toList());

	}

	public void save(String documentId, IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
		exist.save(documentId, interesovanje);

	}
}