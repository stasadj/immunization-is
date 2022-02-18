package com.immunization.common.dao;

import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.repository.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IzvestajOImunizacijiDAO extends DocumentDAO<IzvestajOImunizaciji> {

	@Autowired
	public IzvestajOImunizacijiDAO(Exist exist) {
		super(exist, IzvestajOImunizaciji.class);
	}
}
