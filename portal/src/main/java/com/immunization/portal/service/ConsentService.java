package com.immunization.portal.service;

import com.immunization.portal.constants.MetadataConstants;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.User;
import com.immunization.common.model.saglasnost.EvidencijaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.repository.Exist;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConsentService {
    private Exist exist;
    private MarshallerService marshallerService;
    private MetadataExtractorService metadataExtractorService;
    private UUIDService uuidService;
    private 

    public boolean fileConsent(ObrazacSaglasnostiZaImunizaciju form, User currentUser) {
        // Remove any vaccination records as these cannot be filed in by a patient
        clearVaccinationRecord(form);

        // Generate uuid
        String uuid = uuidService.getUUID();

        // Set abouts before extracting metadata
        setFormAbouts(form, uuid, currentUser);

        // Check if the user already consented
        if (patientAlreadyConsented(currentUser)) {
            throw new BadRequestException("Patient already consented");
        }

        if (!extractAndSaveMetadata(form)) {
            throw new FailedMetadataExtractionException();
        }

        try {
            saveForm(form, uuid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void saveForm(ObrazacSaglasnostiZaImunizaciju form, String filename) throws Exception {
        exist.save(filename, form);
    }

    private void clearVaccinationRecord(ObrazacSaglasnostiZaImunizaciju form) {
        form.setEvidencijaOVakcinaciji(new EvidencijaOVakcinaciji());
    }

    private void setFormAbouts(ObrazacSaglasnostiZaImunizaciju form, String uuid, User user) {
        String formURI = createFormAboutString(uuid);
        String residenceURI = createResidenceAboutString(user.getUsername());
        String patientURI = createPatientAboutString(user.getUsername());

        form.getInformacijeOPacijentu().setAbout(patientURI);
        form.getInformacijeOPacijentu().getPrebivaliste().setAbout(residenceURI);
        form.setAbout(formURI);
    }

    private String createFormAboutString(String uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append(MetadataConstants.ABOUT_CONSENT_PREFIX).append(uuid);
        return sb.toString();
    }

    private String createResidenceAboutString(String username) {
        StringBuilder sb = new StringBuilder();
        sb.append(MetadataConstants.ABOUT_RESIDENCE_PREFIX).append(username);
        return sb.toString();
    }

    private String createPatientAboutString(String username) {
        StringBuilder sb = new StringBuilder();
        sb.append(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX).append(username);
        return sb.toString();
    }

    private boolean extractAndSaveMetadata(ObrazacSaglasnostiZaImunizaciju form) {
        try {
            metadataExtractorService.insertFromString(marshallerService.marshal(form), MetadataConstants.RDF_GRAPH_URI);
        } catch (IOException | TransformerException | MarshalException e) {
            return false;
        }

        return true;
    }

    private boolean patientAlreadyConsented(User username) {
        // TODO: Look for patient through exist?
        return false;
    }

}
