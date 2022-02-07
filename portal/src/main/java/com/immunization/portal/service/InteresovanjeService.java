package com.immunization.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {

    @Autowired
    private Exist exist;

	public IskazivanjeInteresovanjaZaVakcinaciju create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws BadRequestException {
		
		//TODO check if person in document already has an Interesovanje from before in database	
		
		try {
			//TODO generate new document UUID and document name
			String id = exist.save("PROBA.xml", interesovanje);
			return interesovanje;
			
			//TODO extract and save metadata
			
		} catch (Exception e) {
			// Exist exception
			e.printStackTrace();
		}

		return null;
		
	}

}
