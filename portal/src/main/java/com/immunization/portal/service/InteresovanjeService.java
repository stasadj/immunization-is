package com.immunization.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;
import com.immunization.common.service.UUIDService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {

    @Autowired
    private Exist exist;

	public IskazivanjeInteresovanjaZaVakcinaciju create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws BadRequestException {
		
		//TODO check if person in document already has an Interesovanje from before in database	
		
		try {
			//TODO generate new document id and document name??
			//String newId = uuidService.getUUID();
			//String documentName = exist.save("interesovanje" + newId + ".xml", interesovanje);
			
			exist.save(interesovanje.getPacijent().getJmbg() + ".xml", interesovanje);
			return interesovanje;
			
			//TODO extract and save metadata here
			
		} catch (Exception e) {
			// Exist exception
			e.printStackTrace();
		}

		return null;
		
	}

}
