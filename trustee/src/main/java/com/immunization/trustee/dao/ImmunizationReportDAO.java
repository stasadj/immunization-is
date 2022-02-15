package com.immunization.trustee.dao;

import org.springframework.stereotype.Component;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
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

	public long getNumberOfDocumentsOfInterest(String startDate, String endDate) throws Exception {
		Collection collection = exist.getCollection(IskazivanjeInteresovanjaZaVakcinaciju.class);

		String xpathExp = "//ns3:iskazivanje_interesovanja_za_vakcinaciju[number(translate(@datum,'-',''))>="
				+ startDate + " and number(translate(@datum,'-','')) <=" + endDate + "]";

		XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
		xpathService.setProperty("indent", "yes");
		xpathService.setNamespace("ns3", INTEREST_NAMESPACE);

		ResourceSet result = xpathService.query(xpathExp);

		return result.getSize();
	}

	public long getNumberOfCertificateRequests(String startDate, String endDate) throws Exception {
		Collection collection = exist.getCollection(ZahtevZaSertifikat.class);

		String xpathExp = "//ns7:datum_izdavanja[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-','')) <=" + endDate + "]";

		XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
		xpathService.setProperty("indent", "yes");
		xpathService.setNamespace("ns7", REQUEST_NAMESPACE);

		ResourceSet result = xpathService.query(xpathExp);

		return result.getSize();
	}

	public long getNumberOfCeritificatesIssued(String startDate, String endDate) throws Exception {
		Collection collection = exist.getCollection(DigitalniSertifikat.class);

		String xpathExp = "//ns6:digitalni_sertifikat[number(translate(@datum_izdavanja,'-',''))>=" + startDate
				+ " and number(translate(@datum_izdavanja,'-','')) <=" + endDate + "]";

		XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
		xpathService.setProperty("indent", "yes");
		xpathService.setNamespace("ns6", CERTIFICATE_NAMESPACE);

		ResourceSet result = xpathService.query(xpathExp);

		return result.getSize();
	}

	public long getNumberOfGivenVaccinesForManufacturer(String startDate, String endDate, String manufacturer) {
		return 0;
	}

	public long getNumberOfGivenVaccinesByDose(String startDate, String endDate, String dose) {
		return 0;
	}

}
