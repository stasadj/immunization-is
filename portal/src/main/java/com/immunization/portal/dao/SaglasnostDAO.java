package com.immunization.portal.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.repository.Exist;

public class SaglasnostDAO {

    private Exist exist;
    private static final String SAGLASNOST_NAMESPACE = "http://www.ftn.uns.ac.rs/saglasnost/";

    public List<ObrazacSaglasnostiZaImunizaciju> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//sagl:obrazac_saglasnosti_za_imunizaciju[sagl:informacije_o_pacijentu[@about='" + about + "']]";

        return  exist.query(xpathExp, ObrazacSaglasnostiZaImunizaciju.class, SAGLASNOST_NAMESPACE, "sagl").stream()
				.map(o -> (ObrazacSaglasnostiZaImunizaciju) o).collect(Collectors.toList());

	}
    
}