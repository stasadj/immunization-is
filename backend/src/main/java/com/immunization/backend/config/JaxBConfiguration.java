package com.immunization.backend.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.ac.uns.ftn.digitalni_sertifikat.DigitalniSertifikat;
import rs.ac.uns.ftn.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import rs.ac.uns.ftn.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import rs.ac.uns.ftn.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import rs.ac.uns.ftn.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import rs.ac.uns.ftn.zahtev_za_sertifikat.ZahtevZaSertifikat;

@Configuration
public class JaxBConfiguration {

	private String instancePathBase = "rs.ac.uns.ftn";
	private String digitalniSertifikatPath = instancePathBase + ".digitalni_sertifikat";
	private String interesovanjePath = instancePathBase + ".interesovanje";
	private String izvestajOImunizacijiPath = instancePathBase + ".izvestaj_o_imunizaciji";
	private String potvrdaOVakcinacijiPath = instancePathBase + ".potvrda_o_vakcinaciji";
	private String saglasnostPath = instancePathBase + ".saglasnost";
	private String zahtevZaSertifikatPath = instancePathBase + ".zahtev_za_sertifikat";

	private Map<Class, String> instancePathsMap = new HashMap<Class, String>() {
		{
			put(DigitalniSertifikat.class, digitalniSertifikatPath);
			put(IskazivanjeInteresovanjaZaVakcinaciju.class, interesovanjePath);
			put(IzvestajOImunizaciji.class, izvestajOImunizacijiPath);
			put(PotvrdaOVakcinaciji.class, potvrdaOVakcinacijiPath);
			put(ObrazacSaglasnostiZaImunizaciju.class, saglasnostPath);
			put(ZahtevZaSertifikat.class, zahtevZaSertifikatPath);
		}
	};

	@Bean
	public Map<Class, String> getInstancePathsMap() {
		return instancePathsMap;
	}

}