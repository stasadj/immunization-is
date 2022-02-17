package com.immunization.portal.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.repository.Exist;

public class DigitalniSertifikatDAO {

    private Exist exist;
    private static final String SERTIFIKAT_NAMESPACE = "http://www.ftn.uns.ac.rs/digitalni-sertifikat/";

    public List<DigitalniSertifikat> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//sert:digitalni_sertifikat[sert:licni_podaci[@about='" + about + "']]";

        return  exist.query(xpathExp, DigitalniSertifikat.class, SERTIFIKAT_NAMESPACE, "sert").stream()
				.map(o -> (DigitalniSertifikat) o).collect(Collectors.toList());

	}
    
}
