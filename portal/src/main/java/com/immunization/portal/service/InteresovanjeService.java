package com.immunization.portal.service;

import java.util.Optional;

import com.immunization.common.dao.IskazivanjeInteresovanjaZaVakcinacijuDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.User;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.XMLCalendarService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import com.immunization.portal.service.email.PortalEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresovanjeService extends DocumentService<IskazivanjeInteresovanjaZaVakcinaciju> {
    private final PortalEmailService emailService;
    private final XMLCalendarService calendarUtil;

    @Autowired
    public InteresovanjeService(IskazivanjeInteresovanjaZaVakcinacijuDAO documentDAO,
                                MetadataExtractorService metadataExtractorService,
                                MarshallerService marshallerService,
                                PdfTransformer pdfTransformer,
                                XhtmlTransformer xhtmlTransformer,
                                PortalEmailService emailService,
                                XMLCalendarService calendarUtil) {
        super(IskazivanjeInteresovanjaZaVakcinaciju.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.emailService = emailService;
        this.calendarUtil = calendarUtil;
    }

    @Override
    public void create(IskazivanjeInteresovanjaZaVakcinaciju interesovanje, User user) throws Exception {
        String documentId = user.getUsername();

        Optional<IskazivanjeInteresovanjaZaVakcinaciju> result = ((IskazivanjeInteresovanjaZaVakcinacijuDAO)documentDAO).retrieveById(documentId);
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

        documentDAO.save(documentId, interesovanje);

        // send email to patient
        emailService.sendInteresovanjeConfirmation(interesovanje,
                interesovanje.getPacijent().getKontaktInformacije().getEmailAdresa());
    }
}
