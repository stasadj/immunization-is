package com.immunization.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.portal.dao.InteresovanjeDAO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {
	
	
    @Autowired
    private InteresovanjeDAO interesovanjeDAO;


    public IskazivanjeInteresovanjaZaVakcinaciju create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
    	
    	String documentId = interesovanje.getPacijent().getJmbg().getValue() + ".xml";
    
        Optional<IskazivanjeInteresovanjaZaVakcinaciju> result = interesovanjeDAO.retrieveById(documentId);
        if (result.isPresent()) {
        	throw new BadRequestException("Interesovanje for this user already exists. ");
        }
        	
        interesovanjeDAO.save(documentId, interesovanje);
        return interesovanje;
        
        //TODO extract and save metadata here
    		
    }

}
