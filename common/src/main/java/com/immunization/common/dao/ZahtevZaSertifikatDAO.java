package com.immunization.common.dao;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.repository.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ZahtevZaSertifikatDAO extends DocumentDAO<ZahtevZaSertifikat> {
	private static final String REQUEST_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/";

	@Autowired
	public ZahtevZaSertifikatDAO(Exist exist) {
		super(exist, ZahtevZaSertifikat.class);
	}

	public long getNumberOfCertificateRequests(String startDate, String endDate) throws Exception {
		String xpathExp = "//zaht:datum_izdavanja[number(translate(text(),'-',''))>=" + startDate
				+ " and number(translate(text(),'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, ZahtevZaSertifikat.class, REQUEST_NAMESPACE, "zaht");
	}

	public Optional<ZahtevZaSertifikat> retrieveById(String documentId) throws Exception {
		ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) exist.retrieveById(documentId, ZahtevZaSertifikat.class);
		return zahtev == null ? Optional.empty() : Optional.of(zahtev);
	}

	@Override
    public List<ZahtevZaSertifikat> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//zaht:zahtev_za_sertifikat[zaht:podnosilac_zahteva[@about='" + about + "']]";

        return exist.query(xpathExp, ZahtevZaSertifikat.class, REQUEST_NAMESPACE, "zaht").stream()
				.map(o -> (ZahtevZaSertifikat) o).collect(Collectors.toList());
	}
}
