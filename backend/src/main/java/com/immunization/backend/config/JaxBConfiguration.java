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
}