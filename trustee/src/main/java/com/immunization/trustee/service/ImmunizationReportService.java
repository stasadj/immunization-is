package com.immunization.trustee.service;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Service;

import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodDo;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodOd;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImmunizationReportService {
	private Exist exist;

	public IzvestajOImunizaciji getImmunizationReport(LocalDate startDate, LocalDate endDate)
			throws DatatypeConfigurationException {
		DatumIzdavanja datumIzdavanja = new DatumIzdavanja();
		datumIzdavanja.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));

		PeriodOd periodOd = new PeriodOd();
		periodOd.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate.toString()));

		PeriodDo periodDo = new PeriodDo();
		periodDo.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(endDate.toString()));

		MetaPodaci metaPodaci = new MetaPodaci();
		metaPodaci.setDatumIzdavanja(datumIzdavanja);
		metaPodaci.setPeriodOd(periodOd);
		metaPodaci.setPeriodDo(periodDo);

		IzvestajOImunizaciji izvestajOImunizaciji = new IzvestajOImunizaciji();
		izvestajOImunizaciji.setMetaPodaci(metaPodaci);

		return izvestajOImunizaciji;
	}

}
