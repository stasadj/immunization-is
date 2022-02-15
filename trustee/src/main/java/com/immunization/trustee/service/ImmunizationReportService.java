package com.immunization.trustee.service;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodDo;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodOd;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac;
import com.immunization.trustee.dao.ImmunizationReportDAO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImmunizationReportService {
	private final ImmunizationReportDAO immunizationReportDAO;

	public IzvestajOImunizaciji getImmunizationReport(LocalDate startDate, LocalDate endDate) throws Exception {

		IzvestajOImunizaciji izvestajOImunizaciji = new IzvestajOImunizaciji();
		izvestajOImunizaciji
				.setAbout("http://www.ftn.uns.ac.rs/izvestaj/" + startDate.toString() + "-" + endDate.toString());
		izvestajOImunizaciji.setMetaPodaci(this.createMetaData(startDate, endDate));
		izvestajOImunizaciji.setBrojDokumenataOInteresovanju(immunizationReportDAO.getNumberOfDocumentsOfInterest(
				startDate.toString().replace("-", ""), endDate.toString().replace("-", "")));
		izvestajOImunizaciji
				.setBrojZahtevaZaDigitalniSertifikat(immunizationReportDAO.getNumberOfCertificateRequests());
		izvestajOImunizaciji
				.setBrojIzdatihDigitalnihSertifikata(immunizationReportDAO.getNumberOfCeritificatesIssued());
		izvestajOImunizaciji.setRaspodelaDatihVakcinaPoRednomBrojuDoze(this.getDistributionOfGivenVaccinesByDose());
		izvestajOImunizaciji
				.setRaspodelaDatihVakcinaPoProizvodjacima(this.getDistributionOfGivenVaccinesByManufacturer());
		return izvestajOImunizaciji;
	}

	private MetaPodaci createMetaData(LocalDate startDate, LocalDate endDate) throws DatatypeConfigurationException {
		DatumIzdavanja datumIzdavanja = new DatumIzdavanja();
		datumIzdavanja.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
		datumIzdavanja.setProperty("pred:izdato");
		datumIzdavanja.setDatatype("xs:string");

		PeriodOd periodOd = new PeriodOd();
		periodOd.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate.toString()));
		periodOd.setProperty("pred:obuhvata_period_od");
		periodOd.setDatatype("xs:string");

		PeriodDo periodDo = new PeriodDo();
		periodDo.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(endDate.toString()));
		periodDo.setProperty("pred:obuhvata_period_do");
		periodDo.setDatatype("xs:string");

		MetaPodaci metaPodaci = new MetaPodaci();
		metaPodaci.setDatumIzdavanja(datumIzdavanja);
		metaPodaci.setPeriodOd(periodOd);
		metaPodaci.setPeriodDo(periodDo);

		return metaPodaci;

	}

	private RaspodelaDatihVakcinaPoRednomBrojuDoze getDistributionOfGivenVaccinesByDose() {
		RaspodelaDatihVakcinaPoRednomBrojuDoze raspodela = new RaspodelaDatihVakcinaPoRednomBrojuDoze();
		Doza doza1 = new Doza();
		doza1.setBrojDatihDoza(0);
		doza1.setRedniBroj(BigInteger.valueOf(1));

		Doza doza2 = new Doza();
		doza2.setBrojDatihDoza(0);
		doza2.setRedniBroj(BigInteger.valueOf(2));

		Doza doza3 = new Doza();
		doza3.setBrojDatihDoza(1);
		doza3.setRedniBroj(BigInteger.valueOf(3));

		raspodela.getDoza().add(doza1);
		raspodela.getDoza().add(doza2);
		raspodela.getDoza().add(doza3);
		return raspodela;
	}

	private RaspodelaDatihVakcinaPoProizvodjacima getDistributionOfGivenVaccinesByManufacturer() {
		RaspodelaDatihVakcinaPoProizvodjacima raspodela = new RaspodelaDatihVakcinaPoProizvodjacima();
		Proizvodjac proizvodjac = new Proizvodjac();
		proizvodjac.setBrojDatihDoza(0);
		proizvodjac.setNaziv("Pfizer");

		raspodela.getProizvodjac().add(proizvodjac);
		raspodela.getProizvodjac().add(proizvodjac);
		raspodela.getProizvodjac().add(proizvodjac);
		raspodela.getProizvodjac().add(proizvodjac);
		raspodela.getProizvodjac().add(proizvodjac);
		return raspodela;
	}

}
