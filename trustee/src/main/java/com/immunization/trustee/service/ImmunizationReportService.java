package com.immunization.trustee.service;

import java.math.BigInteger;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Service;

import com.immunization.common.dao.DigitalniSertifikatDAO;
import com.immunization.common.dao.IskazivanjeInteresovanjaZaVakcinacijuDAO;
import com.immunization.common.dao.IzvestajOImunizacijiDAO;
import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodDo;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.MetaPodaci.PeriodOd;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImmunizationReportService {
	private final IskazivanjeInteresovanjaZaVakcinacijuDAO interesovanjeDAO;
	private final ZahtevZaSertifikatDAO zahtevDAO;
	private final DigitalniSertifikatDAO sertifikatDAO;
	private final PotvrdaOVakcinacijiDAO potvrdaDAO;
	private final IzvestajOImunizacijiDAO izvestajDAO;

	public IzvestajOImunizaciji getImmunizationReport(LocalDate startDate, LocalDate endDate) throws Exception {
		String startDateNum = startDate.toString().replace("-", "");
		String endDateNum = endDate.toString().replace("-", "");

		IzvestajOImunizaciji izvestajOImunizaciji = new IzvestajOImunizaciji();
		izvestajOImunizaciji
				.setAbout("http://www.ftn.uns.ac.rs/izvestaj/" + startDate.toString() + "-" + endDate.toString());
		izvestajOImunizaciji.setMetaPodaci(this.createMetaData(startDate, endDate));
		izvestajOImunizaciji.setBrojDokumenataOInteresovanju(
				interesovanjeDAO.getNumberOfDocumentsOfInterest(startDateNum, endDateNum));
		izvestajOImunizaciji.setBrojZahtevaZaDigitalniSertifikat(
				zahtevDAO.getNumberOfCertificateRequests(startDateNum, endDateNum));
		izvestajOImunizaciji.setBrojIzdatihDigitalnihSertifikata(
				sertifikatDAO.getNumberOfCeritificatesIssued(startDateNum, endDateNum));
		izvestajOImunizaciji.setRaspodelaDatihVakcinaPoRednomBrojuDoze(
				this.getDistributionOfGivenVaccinesByDose(startDateNum, endDateNum));
		izvestajOImunizaciji.setRaspodelaDatihVakcinaPoProizvodjacima(
				this.getDistributionOfGivenVaccinesByManufacturer(startDateNum, endDateNum));
		izvestajDAO.save(startDateNum + endDateNum, izvestajOImunizaciji);
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

	private RaspodelaDatihVakcinaPoRednomBrojuDoze getDistributionOfGivenVaccinesByDose(String startDate,
			String endDate) throws Exception {
		RaspodelaDatihVakcinaPoRednomBrojuDoze raspodela = new RaspodelaDatihVakcinaPoRednomBrojuDoze();
		Doza doza1 = new Doza();
		doza1.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesByDose(startDate, endDate, 1));
		doza1.setRedniBroj(BigInteger.valueOf(1));

		Doza doza2 = new Doza();
		doza2.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesByDose(startDate, endDate, 2));
		doza2.setRedniBroj(BigInteger.valueOf(2));

		Doza doza3 = new Doza();
		doza3.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesByDose(startDate, endDate, 3));
		doza3.setRedniBroj(BigInteger.valueOf(3));

		raspodela.getDoza().add(doza1);
		raspodela.getDoza().add(doza2);
		raspodela.getDoza().add(doza3);
		raspodela.setUkupnoDato(doza1.getBrojDatihDoza() + doza2.getBrojDatihDoza() + doza3.getBrojDatihDoza());
		return raspodela;
	}

	private RaspodelaDatihVakcinaPoProizvodjacima getDistributionOfGivenVaccinesByManufacturer(String startDate,
			String endDate) throws Exception {
		RaspodelaDatihVakcinaPoProizvodjacima raspodela = new RaspodelaDatihVakcinaPoProizvodjacima();

		Proizvodjac pfizer = new Proizvodjac();
		pfizer.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesForManufacturer(startDate, endDate, "Pfizer"));
		pfizer.setNaziv("Pfizer, BioNTech");

		Proizvodjac sinopharm = new Proizvodjac();
		sinopharm.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesForManufacturer(startDate, endDate, "Sinopharm"));
		sinopharm.setNaziv("Sinopharm");

		Proizvodjac sputnik = new Proizvodjac();
		sputnik.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesForManufacturer(startDate, endDate, "Sputnik"));
		sputnik.setNaziv("Sputnik V");

		Proizvodjac astra = new Proizvodjac();
		astra.setBrojDatihDoza(potvrdaDAO.getNumberOfGivenVaccinesForManufacturer(startDate, endDate, "Astra"));
		astra.setNaziv("Astra Zeneca, Oxford");

		raspodela.getProizvodjac().add(pfizer);
		raspodela.getProizvodjac().add(sinopharm);
		raspodela.getProizvodjac().add(sputnik);
		raspodela.getProizvodjac().add(astra);
		return raspodela;
	}
}
