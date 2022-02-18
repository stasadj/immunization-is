package com.immunization.portal.service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.ObrazacSaglasnostiZaImunizacijuDAO;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.User;
import com.immunization.common.model.saglasnost.EvidencijaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.dao.IskazivanjeInteresovanjaZaVakcinacijuDAO;

import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaglasnostService extends DocumentService<ObrazacSaglasnostiZaImunizaciju> {
    private final UUIDService uuidService;
    private final IskazivanjeInteresovanjaZaVakcinacijuDAO interesovanjeDAO;
    private final UserDAO userDAO;

    @Autowired
    public SaglasnostService(ObrazacSaglasnostiZaImunizacijuDAO documentDAO,
                             MetadataExtractorService metadataExtractorService,
                             MarshallerService marshallerService,
                             PdfTransformer pdfTransformer,
                             XhtmlTransformer xhtmlTransformer,
                             UUIDService uuidService,
                             IskazivanjeInteresovanjaZaVakcinacijuDAO interesovanjeDAO,
                             UserDAO userDAO) {
        super(ObrazacSaglasnostiZaImunizaciju.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.uuidService = uuidService;
        this.interesovanjeDAO = interesovanjeDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void create(ObrazacSaglasnostiZaImunizaciju form, User user) throws Exception {
        // Remove any vaccination records as these cannot be filed in by a patient
        clearVaccinationRecord(form);

        // Set abouts before extracting metadata
        setFormAbouts(form, user);

        // Check if the patient already has already filed in an prerequisite interest form
        if (!patientGivenInterestForm(user)) {
            throw new BadRequestException("Nije popunjen dokument o interesovanju.");
        }

        if (!extractAndSaveMetadata(form)) {
            throw new FailedMetadataExtractionException();
        }

        String id = form.getAbout().substring(MetadataConstants.ABOUT_CONSENT_PREFIX.length());

        documentDAO.save(id, form);

        user.getDocuments().getSaglasnost().add(id);
        userDAO.save(user);
    }

    private void clearVaccinationRecord(ObrazacSaglasnostiZaImunizaciju form) {
        EvidencijaOVakcinaciji evidencija = form.getEvidencijaOVakcinaciji();
        evidencija.getIzvrsenaImunizacija().getVakcina().clear();
        evidencija.getZdravstvenaUstanova().getInformacijeOLekaru().setFaksimil("");
        evidencija.getZdravstvenaUstanova().getInformacijeOLekaru().setIme("");
        evidencija.getZdravstvenaUstanova().getInformacijeOLekaru().setPrezime("");
        evidencija.getZdravstvenaUstanova().getInformacijeOLekaru().setBrojTelefona("");
        evidencija.getZdravstvenaUstanova().getNaziv().setValue("");
        evidencija.getZdravstvenaUstanova().setVakcinacijskiPunkt("");
        evidencija.getKontraindikacija().getPrivremeneKontraindikacije().setDatumUtvrdjivanja("");
        evidencija.getKontraindikacija().getPrivremeneKontraindikacije().setDijagnoza("");
        evidencija.getKontraindikacija().getTrajneKontraindikacije().setOdlukaKomisije("");
    }

    private void setFormAbouts(ObrazacSaglasnostiZaImunizaciju form, User user) {
        String formURI = createFormAboutString(uuidService.getUUID());
        String residenceURI = createResidenceAboutString(user.getUsername());
        String patientURI = createPatientAboutString(user.getUsername());

        form.getInformacijeOPacijentu().setAbout(patientURI);
        form.getInformacijeOPacijentu().getPrebivaliste().setAbout(residenceURI);
        form.setAbout(formURI);
    }

    private String createFormAboutString(String uuid) {
        return MetadataConstants.ABOUT_CONSENT_PREFIX + uuid;
    }

    private String createResidenceAboutString(String username) {
        return MetadataConstants.ABOUT_RESIDENCE_PREFIX + username;
    }

    private String createPatientAboutString(String username) {
        return MetadataConstants.ABOUT_LICNI_PODACI_PREFIX + username;
    }

    private boolean patientGivenInterestForm(User user) {
        try {
            return interesovanjeDAO.retrieveById(user.getUsername()).isPresent();
        } catch (Exception e) {
            return false;
        }
    }
}
