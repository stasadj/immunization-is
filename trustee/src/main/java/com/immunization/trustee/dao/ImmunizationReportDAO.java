package com.immunization.trustee.dao;

import org.springframework.stereotype.Component;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ImmunizationReportDAO {
	private final Exist exist;
	private static final String INTERES_NAMESPACE = "http://www.ftn.uns.ac.rs/interesovanje/";

	public long getNumberOfDocumentsOfInterest(String startDate, String endDate) throws Exception {
		Collection collection = exist.getCollection(IskazivanjeInteresovanjaZaVakcinaciju.class);

		String xpathExp = "//ns3:iskazivanje_interesovanja_za_vakcinaciju[number(translate(@datum,'-',''))>="
				+ startDate + " and number(translate(@datum,'-','')) <=" + endDate + "]";
		// String xpathExp =
		// "//ns3:iskazivanje_interesovanja_za_vakcinaciju[@datum=\"2022-02-15\"]";

		XPathQueryService xpathService = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
		xpathService.setProperty("indent", "yes");
		xpathService.setNamespace("ns3", INTERES_NAMESPACE);

		ResourceSet result = xpathService.query(xpathExp);

		return result.getSize();
	}

	public long getNumberOfCertificateRequests() {
		return 0;
	}

	public long getNumberOfCeritificatesIssued() {
		return 0;
	}

	public long getDistributionOfGivenVaccinesByManufacturer() {
		return 0;
	}

	public long getDistributionOfGivenVaccinesByDose() {
		return 0;
	}

}
