package com.immunization.common.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ZahtevZaSertifikatDAO {
	private final Exist exist;
	private static final String REQUEST_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/";

	public long getNumberOfCertificateRequests(String startDate, String endDate) throws Exception {

		String xpathExp = "//zaht:datum_izdavanja[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, ZahtevZaSertifikat.class, REQUEST_NAMESPACE, "zaht");
	}

	public Optional<ZahtevZaSertifikat> retrieveById(String documentId) throws Exception {
		ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) exist.retrieveById(documentId, ZahtevZaSertifikat.class);
		return zahtev == null ? Optional.empty() : Optional.of(zahtev);
	}

	public void save(String documentId, ZahtevZaSertifikat zahtev) throws Exception {
		exist.save(documentId, zahtev);
	}
}
