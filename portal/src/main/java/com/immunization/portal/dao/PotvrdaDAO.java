package com.immunization.portal.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.repository.Exist;

public class PotvrdaDAO {

    private Exist exist;
    private static final String POTVRDA_NAMESPACE = "http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/";

    public List<PotvrdaOVakcinaciji> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//potv:potvrda_o_vakcinaciji[potv:licni_podaci[@about='" + about + "']]";

        return  exist.query(xpathExp, PotvrdaOVakcinaciji.class, POTVRDA_NAMESPACE, "potv").stream()
				.map(o -> (PotvrdaOVakcinaciji) o).collect(Collectors.toList());

	}
    
}
