package com.immunization.portal.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor 
public class InteresovanjeDAO {
	
    @Autowired
    private Exist exist;
	
	
    public Optional<IskazivanjeInteresovanjaZaVakcinaciju> retrieveById(String documentId) throws Exception {
        IskazivanjeInteresovanjaZaVakcinaciju interesovanje = (IskazivanjeInteresovanjaZaVakcinaciju) exist.retrieveById(documentId, IskazivanjeInteresovanjaZaVakcinaciju.class);
        return interesovanje == null ? Optional.empty() : Optional.of(interesovanje);
	}

    public void save(String documentId, IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
        exist.save(documentId, interesovanje);
		
	}

}
