package com.immunization.portal.service;

import com.immunization.portal.constants.MetadataConstants;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.BadRequestException;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.exception.NotFoundException;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.repository.Exist;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConsentService {
    private Exist exist;
    private MarshallerService marshallerService;
    private MetadataExtractorService metadataExtractorService;

    public boolean fileConsent(ObrazacSaglasnostiZaImunizaciju form) {
        System.out.println("POOOOL");
        System.out.println(form.getInformacijeOPacijentu().getPol().getValue());

        // Check if patient exists
        if (!patientExists(form.getInformacijeOPacijentu().getAbout())) {
            throw new NotFoundException("Patient does not exist");
        }

        // Check if he already consented
        if (patientAlreadyConsented(form.getInformacijeOPacijentu().getAbout())) {
            throw new BadRequestException("Patient already consented");
        }

        if (!extractAndSaveMetadata(form)) {
            throw new FailedMetadataExtractionException();
        }

        try {
            saveForm(form);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void saveForm(ObrazacSaglasnostiZaImunizaciju form) throws Exception {
        // TODO: Get uuid here
        String uuid = "123";
        String formID = MetadataConstants.CONSENT_ABOUT_PREFIX.concat(uuid);
        String filename = uuid.concat(".xml");
        form.setAbout(formID);
        exist.save(filename, form);
    }

    private boolean extractAndSaveMetadata(ObrazacSaglasnostiZaImunizaciju form) {
        try {
            metadataExtractorService.insertFromString(marshallerService.marshal(form), MetadataConstants.RDF_GRAPH_URI);
        } catch (IOException | TransformerException | MarshalException e) {
            return false;
        }

        return true;
    }

    private boolean patientAlreadyConsented(String patientID) {
        // TODO: Look for patient through exist?
        return false;
    }

    private boolean patientExists(String patientID) {
        return metadataExtractorService.getPatientExists(patientID, MetadataConstants.RDF_GRAPH_URI);
    }

}
