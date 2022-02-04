package com.immunization.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Configuration
public class JaxBConfiguration {

	@Bean
	public JAXBContext createJAXBContext() throws JAXBException {
		return JAXBContext.newInstance(
				DigitalniSertifikat.class,
				IskazivanjeInteresovanjaZaVakcinaciju.class,
				IzvestajOImunizaciji.class,
				PotvrdaOVakcinaciji.class,
				ObrazacSaglasnostiZaImunizaciju.class,
				ZahtevZaSertifikat.class
		);
	}

	@Bean
	public Unmarshaller createUnMarshaller() throws JAXBException {
		return createJAXBContext().createUnmarshaller();
	}

	@Bean
	public Marshaller createMarshaller() throws JAXBException {
		JAXBContext context = createJAXBContext();
		Marshaller marshaller = context.createMarshaller();
		//marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}

}