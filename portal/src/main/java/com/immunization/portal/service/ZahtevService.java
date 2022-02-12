
package com.immunization.portal.service;

import java.io.IOException;
import java.util.Optional;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.portal.constants.MetadataConstants;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevService {
	
    // private ZahtevDAO zahtevDAO; //TODO
    private MetadataExtractorService metadataExtractorService;
    private MarshallerService marshallerService;


    public ZahtevZaSertifikat create(ZahtevZaSertifikat zahtev) throws Exception {
    	
    	String documentId = zahtev.getPodnosilacZahteva().getJmbg().getValue() + ".xml";
    
        //TODO check if zahtev already exists

        // Optional<ZahtevZaSertifikat> result = zahtevDAO.retrieveById(documentId);
        // if (result.isPresent()) {
        // 	throw new BadRequestException("Zahtev for this user already exists. ");
        // }
        	
        if (!extractAndSaveMetadata(zahtev)) {
            throw new FailedMetadataExtractionException();
        }

        //TODO save to database
        // zahtevDAO.save(documentId, zahtev);
        return zahtev;
    		
    }

    private boolean extractAndSaveMetadata(ZahtevZaSertifikat form) {
        try {
            metadataExtractorService.insertFromString(marshallerService.marshal(form), MetadataConstants.RDF_GRAPH_URI);
        } catch (IOException | TransformerException | MarshalException e) {
            return false;
        }

        return true;
    }

}

