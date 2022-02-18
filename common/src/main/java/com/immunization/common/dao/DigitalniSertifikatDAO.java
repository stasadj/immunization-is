package com.immunization.common.dao;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.repository.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DigitalniSertifikatDAO extends DocumentDAO<DigitalniSertifikat> {
	private static final String CERTIFICATE_NAMESPACE = "http://www.ftn.uns.ac.rs/digitalni-sertifikat/";

	@Autowired
	public DigitalniSertifikatDAO(Exist exist) {
		super(exist, DigitalniSertifikat.class);
	}

	public long getNumberOfCeritificatesIssued(String startDate, String endDate) throws Exception {
		String xpathExp = "//sert:digitalni_sertifikat[number(translate(@datum_izdavanja,'-',''))>=" + startDate
				+ " and number(translate(@datum_izdavanja,'-',''))<=" + endDate + "]";

		return exist.count(xpathExp, DigitalniSertifikat.class, CERTIFICATE_NAMESPACE, "sert");
	}

	public long getNumberOfCeritificatesIssued() throws Exception {
		String xpathExp = "//sert:digitalni_sertifikat";

		return exist.count(xpathExp, DigitalniSertifikat.class, CERTIFICATE_NAMESPACE, "sert");
	}

	@Override
    public List<DigitalniSertifikat> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//sert:digitalni_sertifikat[sert:licni_podaci[@about='" + about + "']]";

        return  exist.query(xpathExp, DigitalniSertifikat.class, CERTIFICATE_NAMESPACE, "sert").stream()
				.map(o -> (DigitalniSertifikat) o).collect(Collectors.toList());
	}
}
