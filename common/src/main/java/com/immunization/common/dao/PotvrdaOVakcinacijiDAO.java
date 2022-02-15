package com.immunization.common.dao;

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

		String xpathExp = "//ns5:potvrda_o_vakcinaciji[ns5:datum_izdavanja_potvrde[number(translate(text(),'-',''))>="
				+ startDate + " and number(translate(text(),'-',''))<=" + endDate
				+ "] and ns5:vakcinacije/ns5:vakcinacija[last()][contains(.,'" + manufacturer + "')]]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "ns5");
	}

	public long getNumberOfGivenVaccinesByDose(String startDate, String endDate, int dose) throws Exception {

		String xpathExp = "//ns5:potvrda_o_vakcinaciji[ns5:datum_izdavanja_potvrde[number(translate(text(),'-',''))>="
				+ startDate + " and number(translate(text(),'-',''))<=" + endDate
				+ "] and count(ns5:vakcinacije/ns5:vakcinacija)=" + dose + "]";

		return exist.count(xpathExp, PotvrdaOVakcinaciji.class, CONFIRMATION_NAMESPACE, "ns5");
	}
}
