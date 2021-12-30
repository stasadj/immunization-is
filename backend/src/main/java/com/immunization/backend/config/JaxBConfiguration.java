package com.immunization.backend.config;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxBConfiguration {
	
	private String instancePathBase = "rs.ac.uns.ftn";
	private String digitalniSertifikatPath = instancePathBase + ".digitalni_sertifikat";
	private String interesovanjePath = instancePathBase + ".interesovanje";
	private String izvestajOImunizacijiPath = instancePathBase + ".izvestaj_o_imunizaciji";
	private String potvrdaOVakcinacijiPath = instancePathBase + ".potvrda_o_vakcinaciji";
	private String saglasnostPath = instancePathBase + ".saglasnost";
	private String zahtevZaSertifikatPath = instancePathBase + ".zahtev_za_sertifikat";


    @Bean
    public Unmarshaller createDigitalniSertifikatUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(digitalniSertifikatPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createDigitalniSertifikatMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(digitalniSertifikatPath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
    
    @Bean
    public Unmarshaller createInteresovanjeUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(interesovanjePath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createInteresovanjeMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(interesovanjePath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
    
    @Bean
    public Unmarshaller createIzvestajOImunizacijiUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(izvestajOImunizacijiPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createIzvestajOImunizacijiMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(izvestajOImunizacijiPath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
    
    @Bean
    public Unmarshaller createPotvrdaOVakcinacijiUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(potvrdaOVakcinacijiPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createPotvrdaOVakcinacijiMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(potvrdaOVakcinacijiPath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
    
    @Bean
    public Unmarshaller createSaglasnostUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(saglasnostPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createSaglasnostMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(saglasnostPath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
    @Bean
    public Unmarshaller createZahtevZaSertifikatUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(zahtevZaSertifikatPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller; 
    }

    @Bean
    public Marshaller createZahtevZaSertifikatMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(zahtevZaSertifikatPath);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NSPrefixMapper()); //ovo jos ne znam sta je
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }
    
    
}