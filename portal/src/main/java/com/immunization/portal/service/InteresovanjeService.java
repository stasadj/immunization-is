package com.immunization.portal.service;

import java.rmi.UnmarshalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;
import com.immunization.common.service.UnmarshallerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {
	
    @Autowired
    private final UnmarshallerService unmarshallerService;
    
    @Autowired
    private Exist exist;

	public IskazivanjeInteresovanjaZaVakcinaciju create(String xmlString) throws BadRequestException {
		try {
			IskazivanjeInteresovanjaZaVakcinaciju interesovanje = 
					(IskazivanjeInteresovanjaZaVakcinaciju) unmarshallerService.unmarshal(xmlString);
						
			//TODO generate new document ID and document name!
			String id = exist.save("PROBA.xml", interesovanje);
			System.out.println(id);
			
			
		} catch (UnmarshalException e) {
			throw new BadRequestException("Bad document format!");
			
		} catch (Exception e) {
			// Some exist exception
			e.printStackTrace();
		}
		
		return null;
	}

}
