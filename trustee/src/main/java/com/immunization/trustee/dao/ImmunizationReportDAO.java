package com.immunization.trustee.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ImmunizationReportDAO {
	private final Exist exist;
	private static final String INTEREST_NAMESPACE = "http://www.ftn.uns.ac.rs/interesovanje/";
	private static final String REQUEST_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/";
	private static final String CERTIFICATE_NAMESPACE = "http://www.ftn.uns.ac.rs/digitalni-sertifikat/";
	private static final String CONFIRMATION_NAMESPACE = "http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/";

	public long getNumberOfDocumentsOfInterest(String startDate, String endDate) throws Exception {

		String xpathExp = "//ns3:iskazivanje_interesovanja_za_vakcinaciju[number(translate(@datum,'-',''))>="
				+ startDate + " and number(translate(@datum,'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, IskazivanjeInteresovanjaZaVakcinaciju.class, INTEREST_NAMESPACE, "ns3");
	}

	public long getNumberOfCertificateRequests(String startDate, String endDate) throws Exception {

		String xpathExp = "//ns7:datum_izdavanja[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, ZahtevZaSertifikat.class, REQUEST_NAMESPACE, "ns7");
	}

	public long getNumberOfCeritificatesIssued(String startDate, String endDate) throws Exception {

		String xpathExp = "//ns6:digitalni_sertifikat[number(translate(@datum_izdavanja,'-',''))>=" + startDate
				+ " and number(translate(@datum_izdavanja,'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, DigitalniSertifikat.class, CERTIFICATE_NAMESPACE, "ns6");
	}

	public long getNumberOfGivenVaccinesForManufacturer(String startDate, String endDate, String manufacturer)
			throws Exception {

		String xpathExp = "//ns5:datum_izdavanja_potvrde[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "ns5");
	}

	public long getNumberOfGivenVaccinesByDose(String startDate, String endDate, int dose) throws Exception {

		String xpathExp = "//ns5:potvrda_o_vakcinaciji[ns5:datum_izdavanja_potvrde[number(translate(text(),'-',''))>="
				+ startDate + " and number(translate(text(),'-',''))<=" + endDate
				+ "] and count(ns5:vakcinacije/ns5:vakcinacija)=" + dose + "]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "ns5");
	}

}
