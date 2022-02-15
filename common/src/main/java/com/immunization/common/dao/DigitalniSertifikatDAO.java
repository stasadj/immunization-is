package com.immunization.common.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DigitalniSertifikatDAO {
	private final Exist exist;
	private static final String CERTIFICATE_NAMESPACE = "http://www.ftn.uns.ac.rs/digitalni-sertifikat/";

	public long getNumberOfCeritificatesIssued(String startDate, String endDate) throws Exception {

		String xpathExp = "//ns6:digitalni_sertifikat[number(translate(@datum_izdavanja,'-',''))>=" + startDate
				+ " and number(translate(@datum_izdavanja,'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, DigitalniSertifikat.class, CERTIFICATE_NAMESPACE, "ns6");
	}
}
