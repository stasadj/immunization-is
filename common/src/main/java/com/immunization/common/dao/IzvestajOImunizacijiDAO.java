package com.immunization.common.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IzvestajOImunizacijiDAO {
	private final Exist exist;

	public void save(String documentId, IzvestajOImunizaciji izvestajOImunizaciji) throws Exception {
		exist.save(documentId + ".xml", izvestajOImunizaciji);
	}

	public String getXML(String documentId) throws Exception {
		return exist.retrieveRawXmlById(documentId, IzvestajOImunizaciji.class);
	}
}
