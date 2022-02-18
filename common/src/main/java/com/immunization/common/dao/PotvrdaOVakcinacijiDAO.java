package com.immunization.common.dao;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.repository.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PotvrdaOVakcinacijiDAO extends DocumentDAO<PotvrdaOVakcinaciji> {
	private static final String CONFIRMATION_NAMESPACE = "http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/";

	@Autowired
	public PotvrdaOVakcinacijiDAO(Exist exist) {
		super(exist, PotvrdaOVakcinaciji.class);
	}

	public long getNumberOfGivenVaccinesForManufacturer(String startDate, String endDate, String manufacturer) throws Exception {
		String xpathExp = "//potv:potvrda_o_vakcinaciji[potv:datum_izdavanja_potvrde[number(translate(text(),'-',''))>="
				+ startDate + " and number(translate(text(),'-',''))<=" + endDate
				+ "] and potv:vakcinacije/potv:vakcinacija[last()][contains(.,'" + manufacturer + "')]]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "potv");
	}

	public long getNumberOfGivenVaccinesByDose(String startDate, String endDate, int dose) throws Exception {
		String xpathExp = "//potv:potvrda_o_vakcinaciji[potv:datum_izdavanja_potvrde[number(translate(text(),'-',''))>="
				+ startDate + " and number(translate(text(),'-',''))<=" + endDate
				+ "] and count(potv:vakcinacije/potv:vakcinacija)=" + dose + "]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "potv");
	}

	public List<PotvrdaOVakcinaciji> getAllConfirmationsByJmbg(String jmbg) throws Exception {
		String xpathExp = "//potv:potvrda_o_vakcinaciji[potv:licni_podaci/potv:jmbg[text()='" + jmbg + "']]";

		return exist.query(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "potv").stream()
				.map(o -> (PotvrdaOVakcinaciji) o).collect(Collectors.toList());
	}

	@Override
    public List<PotvrdaOVakcinaciji> getByUsername(String gradjaninUsername) throws Exception {
        String about = MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + gradjaninUsername;
        String xpathExp = "//potv:potvrda_o_vakcinaciji[potv:licni_podaci[@about='" + about + "']]";

        return  exist.query(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "potv").stream()
				.map(o -> (PotvrdaOVakcinaciji) o).collect(Collectors.toList());
	}
}
