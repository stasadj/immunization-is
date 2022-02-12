
package com.immunization.portal.service;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.portal.constants.MetadataConstants;
import com.immunization.portal.dao.ZahtevDAO;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevService {
	
    private ZahtevDAO zahtevDAO; 
    private MetadataExtractorService metadataExtractorService;
    private MarshallerService marshallerService;
    private UUIDService uuidService;


    public ZahtevZaSertifikat create(ZahtevZaSertifikat zahtev) throws Exception {

    	String documentId = uuidService.getUUID() + ".xml";

        if (!extractAndSaveMetadata(zahtev)) {
            throw new FailedMetadataExtractionException();
        }

        zahtevDAO.save(documentId, zahtev);
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

