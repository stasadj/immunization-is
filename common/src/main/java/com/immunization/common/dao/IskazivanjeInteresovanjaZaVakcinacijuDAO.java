package com.immunization.common.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

import java.util.Optional;

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
		IskazivanjeInteresovanjaZaVakcinaciju interesovanje = (IskazivanjeInteresovanjaZaVakcinaciju) exist.retrieveById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
		return interesovanje == null ? Optional.empty() : Optional.of(interesovanje);
	}

	public void save(String documentId, IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
		exist.save(documentId, interesovanje);
	}

	public String getXML(String documentId) throws Exception {
		return exist.retrieveRawXmlById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
	}

}
