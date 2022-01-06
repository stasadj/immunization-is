package com.immunization.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.MarshalException;

@Service
public class MarshallerService {

	@Autowired
	private Marshaller marshaller;

	public void marshal(Object object) throws MarshalException {
		try {
			marshaller.marshal(object, System.out); // prints marshalled content to System.out
		} catch (JAXBException e) {
			System.out.println(e.getLocalizedMessage());
			throw new MarshalException("Parsing from object to xml failed");
		}
	}

}
