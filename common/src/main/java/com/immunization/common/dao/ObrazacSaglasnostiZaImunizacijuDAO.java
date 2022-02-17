package com.immunization.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.repository.Exist;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObrazacSaglasnostiZaImunizacijuDAO {
    private final Exist exist;
	private static final String CONSENT_NAMESPACE = "http://www.ftn.uns.ac.rs/saglasnost/";

    public void save(ObrazacSaglasnostiZaImunizaciju form) {
        try {
            exist.save(extractUUIDFromAbout(form), form);
        } catch (Exception e) {
        }
    }

    public List<ObrazacSaglasnostiZaImunizaciju> getByUsername(String username) {
        String aboutUri = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.concat(username);
        List<ObrazacSaglasnostiZaImunizaciju> list = new ArrayList<>();
        try {
            exist.query(String.format(
                    "//sagl:obrazac_saglasnosti_za_imunizaciju[sagl:informacije_o_pacijentu[@about=\"%s\"]]",
                    aboutUri), ObrazacSaglasnostiZaImunizaciju.class,
                    CONSENT_NAMESPACE,
                    "sagl")
                    .forEach(item -> list.add((ObrazacSaglasnostiZaImunizaciju) item));
        } catch (Exception e) {
        }
        return list;
    }

    private String extractUUIDFromAbout(ObrazacSaglasnostiZaImunizaciju form) {
        return form.getAbout().substring(MetadataConstants.ABOUT_CONSENT_PREFIX.length());
    }
}
