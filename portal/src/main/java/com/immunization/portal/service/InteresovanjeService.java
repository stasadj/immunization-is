package com.immunization.portal.service;

import java.io.IOException;
import java.util.Optional;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.User;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.XMLCalendarService;
import com.immunization.common.dao.IskazivanjeInteresovanjaZaVakcinacijuDAO;
import com.immunization.portal.service.email.PortalEmailService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteresovanjeService {

    private IskazivanjeInteresovanjaZaVakcinacijuDAO interesovanjeDAO;
    private MetadataExtractorService metadataExtractorService;
    private MarshallerService marshallerService;
    private PortalEmailService emailService;
    private XMLCalendarService calendarUtil;

    public IskazivanjeInteresovanjaZaVakcinaciju create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje, User user)
            throws Exception {

        String documentId = user.getUsername() + ".xml";

        Optional<IskazivanjeInteresovanjaZaVakcinaciju> result = interesovanjeDAO.retrieveById(documentId);
        if (result.isPresent()) {
            throw new BadRequestException("Interesovanje for this user already exists. ");
        }

        // setting unique about
        interesovanje.setAbout("http://www.ftn.uns.ac.rs/interesovanje/" + documentId);

        // setting patient about
        interesovanje.getPacijent().setAbout("http://www.ftn.uns.ac.rs/licni-podaci/" + user.getUsername());

        // setting date
        interesovanje.setDatum(calendarUtil.getCurrentDate().toString());

        if (!extractAndSaveMetadata(interesovanje)) {
            throw new FailedMetadataExtractionException();
        }

        interesovanjeDAO.save(documentId, interesovanje);

        // send email to patient
        emailService.sendInteresovanjeConfirmation(interesovanje,
                interesovanje.getPacijent().getKontaktInformacije().getEmailAdresa());

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
