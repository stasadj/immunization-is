package com.immunization.common.dao;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.repository.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObrazacSaglasnostiZaImunizacijuDAO extends DocumentDAO<ObrazacSaglasnostiZaImunizaciju> {
    private static final String CONSENT_NAMESPACE = "http://www.ftn.uns.ac.rs/saglasnost/";

    @Autowired
    public ObrazacSaglasnostiZaImunizacijuDAO(Exist exist) {
        super(exist, ObrazacSaglasnostiZaImunizaciju.class);
    }

    @Override
    public List<ObrazacSaglasnostiZaImunizaciju> getByUsername(String username) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.concat(username);
        String xpathExp = "//sagl:obrazac_saglasnosti_za_imunizaciju[sagl:informacije_o_pacijentu[@about='" + about + "']]";
        return exist.query(xpathExp, ObrazacSaglasnostiZaImunizaciju.class, CONSENT_NAMESPACE, "sagl").stream()
                .map(o -> (ObrazacSaglasnostiZaImunizaciju) o).collect(Collectors.toList());
    }
}
