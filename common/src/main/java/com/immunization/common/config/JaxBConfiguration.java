package com.immunization.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.immunization.common.model.User;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.util.NSPrefixMapper;

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
				ZahtevZaSertifikat.class,
				User.class
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
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}

	@Bean
	public MarshallingHttpMessageConverter marshallingHttpMessageConverter() {
		MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

		marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
		marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

		return marshallingHttpMessageConverter;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(
				DigitalniSertifikat.class,
				IskazivanjeInteresovanjaZaVakcinaciju.class,
				IzvestajOImunizaciji.class,
				PotvrdaOVakcinaciji.class,
				ObrazacSaglasnostiZaImunizaciju.class,
				ZahtevZaSertifikat.class);
		jaxb2Marshaller.setSchemas(
				new ClassPathResource("documents/digitalni_sertifikat.xsd"),
				new ClassPathResource("documents/interesovanje.xsd"),
				new ClassPathResource("documents/izvestaj_o_imunizaciji.xsd"),
				new ClassPathResource("documents/potvrda_o_vakcinaciji.xsd"),
				new ClassPathResource("documents/saglasnost.xsd"),
				new ClassPathResource("documents/util.xsd"),
				new ClassPathResource("documents/zahtev_za_sertifikat.xsd"));
		return jaxb2Marshaller;
	}
}