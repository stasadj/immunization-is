package com.immunization.backend.service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.UnmarshalException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.immunization.backend.config.JaxBConfiguration;

@Service
public class UnmarshallerService {

	private Unmarshaller createUnmarshaller(Class xmlCLass) throws JAXBException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(JaxBConfiguration.class);
		ctx.refresh();
		Map<Class, String> instancePathsMap = (HashMap<Class, String>) ctx.getBean("getInstancePathsMap");
		JAXBContext context = JAXBContext.newInstance(instancePathsMap.get(xmlCLass));
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return unmarshaller;
	}

	public Object unmarshal(String xmlString, Class xmlClass) throws UnmarshalException {
		try {
			return createUnmarshaller(xmlClass)
					.unmarshal(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));

		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
			throw new UnmarshalException("Parsing from xml string to object failed");
		}
	}

}
