package com.immunization.portal.service;

import java.io.IOException;
import java.util.Optional;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.portal.constants.MetadataConstants;
import com.immunization.portal.dao.InteresovanjeDAO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {
	
    private InteresovanjeDAO interesovanjeDAO;
    private MetadataExtractorService metadataExtractorService;
    private MarshallerService marshallerService;


    public IskazivanjeInteresovanjaZaVakcinaciju create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje) throws Exception {
    	
    	String documentId = interesovanje.getPacijent().getJmbg().getValue() + ".xml";
    
        Optional<IskazivanjeInteresovanjaZaVakcinaciju> result = interesovanjeDAO.retrieveById(documentId);
        if (result.isPresent()) {
        	throw new BadRequestException("Interesovanje for this user already exists. ");
        }
        	
        if (!extractAndSaveMetadata(interesovanje)) {
            throw new FailedMetadataExtractionException();
        }

        interesovanjeDAO.save(documentId, interesovanje);
        return interesovanje;
    		
    }

    private boolean extractAndSaveMetadata(IskazivanjeInteresovanjaZaVakcinaciju form) {
        try {
            metadataExtractorService.insertFromString(marshallerService.marshal(form), MetadataConstants.RDF_GRAPH_URI);
        } catch (IOException | TransformerException | MarshalException e) {
            return false;
        }

        return true;
    }

}
