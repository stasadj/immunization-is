package com.immunization.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.immunization.backend.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.backend.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.backend.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.backend.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.backend.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.backend.model.zahtev_za_sertifikat.ZahtevZaSertifikat;

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