package com.immunization.backend.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.MarshalException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.immunization.backend.config.JaxBConfiguration;

@Service
public class MarshallerService {

	public Marshaller createMarshaller(Class c) throws JAXBException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(JaxBConfiguration.class);
		ctx.refresh();
		Map<Class, String> instancePathsMap = (HashMap<Class, String>) ctx.getBean("getInstancePathsMap");

		JAXBContext context = JAXBContext.newInstance(instancePathsMap.get(c));
		Marshaller marshaller = context.createMarshaller();
		// NSPrefixMapper()); //ovo jos ne znam sta je
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}

	public void marshal(Object object) throws MarshalException {
		try {
			createMarshaller(object.getClass()).marshal(object, System.out);

		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
			throw new MarshalException("Parsing from object to xml failed");
		}
	}

}
