package com.immunization.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.MarshalException;
import java.io.StringWriter;

@Service
public class MarshallerService {

	@Autowired
	private Marshaller marshaller;

	public String marshal(Object object) throws MarshalException {
		try {
			StringWriter writer = new StringWriter();
			marshaller.marshal(object, writer);
			return writer.toString();
		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
			throw new MarshalException("Parsing from object to xml failed");
		}
	}
}
