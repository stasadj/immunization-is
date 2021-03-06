package com.immunization.portal.config;

import com.immunization.common.model.VaccineAmount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.immunization.common.config.JaxBConfiguration;
import com.immunization.common.model.User;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.util.NSPrefixMapper;
import com.immunization.portal.dto.GradjaninDocumentsDTO;
import com.immunization.portal.dto.UserRegistrationDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Configuration
@Import({JaxBConfiguration.class})
public class JaxBPortalConfiguration {

	@Bean
	@Primary
	public JAXBContext createPortalJAXBContext() throws JAXBException {
		return JAXBContext.newInstance(
				DigitalniSertifikat.class,
				IskazivanjeInteresovanjaZaVakcinaciju.class,
				IzvestajOImunizaciji.class,
				PotvrdaOVakcinaciji.class,
				ObrazacSaglasnostiZaImunizaciju.class,
				ZahtevZaSertifikat.class,
                UserRegistrationDTO.class,
				User.class,
                GradjaninDocumentsDTO.class,
				VaccineAmount.class
		);
	}

	@Bean
	@Primary
	public Unmarshaller createPortalUnMarshaller() throws JAXBException {
		return createPortalJAXBContext().createUnmarshaller();
	}

	@Bean
	@Primary
	public Marshaller createPortalMarshaller() throws JAXBException {
		JAXBContext context = createPortalJAXBContext();
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}

}