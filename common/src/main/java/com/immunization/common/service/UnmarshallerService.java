package com.immunization.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.UnmarshalException;

@Service
public class UnmarshallerService {

	@Autowired
	private Unmarshaller unmarshaller;

	public Object unmarshal(String xmlString) throws UnmarshalException {
		try {
			return unmarshaller.unmarshal(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8)));
		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
			throw new UnmarshalException("Parsing from xml string to object failed");
		}
	}
}
