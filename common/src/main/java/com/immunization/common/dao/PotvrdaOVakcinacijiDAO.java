package com.immunization.common.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PotvrdaOVakcinacijiDAO {
	private final Exist exist;
	private static final String CONFIRMATION_NAMESPACE = "http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/";

	public long getNumberOfGivenVaccinesForManufacturer(String startDate, String endDate, String manufacturer)
			throws Exception {

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
}
