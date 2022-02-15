package com.immunization.common.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ZahtevZaSertifikatDAO {
	private final Exist exist;
	private static final String REQUEST_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/";

	public long getNumberOfCertificateRequests(String startDate, String endDate) throws Exception {

		String xpathExp = "//ns7:datum_izdavanja[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, ZahtevZaSertifikat.class, REQUEST_NAMESPACE, "ns7");
	}
}
