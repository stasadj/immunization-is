package com.immunization.trustee.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import com.immunization.common.dao.*;
import com.immunization.common.exception.base.NotFoundException;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.User;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.trustee.dto.request.Zahtev;
import com.immunization.trustee.dto.request.Zahtevi;
import com.immunization.trustee.dto.response.Odgovor;
import com.immunization.trustee.service.email.TrusteeEmailService;

@Service
public class ZahtevZaSertifikatService extends DocumentService<ZahtevZaSertifikat> {
    private final UserDAO userDAO;
    private final TrusteeEmailService emailService;

    private final DigitalniSertifikatService sertifikatService;

    @Autowired
    public ZahtevZaSertifikatService(ZahtevZaSertifikatDAO documentDAO,
            MetadataExtractorService metadataExtractorService, MarshallerService marshallerService,
            PdfTransformer pdfTransformer, XhtmlTransformer xhtmlTransformer, UserDAO userDAO,
            TrusteeEmailService emailService, DigitalniSertifikatService sertifikatService) {
        super(ZahtevZaSertifikat.class, documentDAO, metadataExtractorService, marshallerService, pdfTransformer,
                xhtmlTransformer);
        this.userDAO = userDAO;
        this.emailService = emailService;
        this.sertifikatService = sertifikatService;
    }

    public Zahtevi getAllPendingRequests() throws Exception {
        Zahtevi zahteviOut = new Zahtevi();
        zahteviOut.setZahtev(new ArrayList<Zahtev>());
        List<ZahtevZaSertifikat> zahteviIn = ((ZahtevZaSertifikatDAO) documentDAO).getAllPendingRequests();
        for (ZahtevZaSertifikat z : zahteviIn) {
            String uuid = this.extractUUIDFromAboutRequest(z.getAbout());
            zahteviOut.getZahtev().add(new Zahtev(uuid, z.getMetaPodaci().getDatumIzdavanja().getValue(),
                    z.getPodnosilacZahteva().getJmbg().getValue()));
        }
        return zahteviOut;
    }

    public DigitalniSertifikat accept(Odgovor odgovor) throws Exception {
        String zahtevUUID = this.extractUUIDFromAboutRequest(odgovor.getZahtevURI());

        Optional<ZahtevZaSertifikat> maybeZahtev = ((ZahtevZaSertifikatDAO) documentDAO).retrieveById(zahtevUUID);
        ZahtevZaSertifikat zahtev = maybeZahtev.orElseThrow(() -> new NotFoundException(""));
        zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.PRIHVACEN);
        documentDAO.save(zahtevUUID + ".xml", zahtev);

        String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
        User user = userDAO.getByUsername(username).get(0);

        DigitalniSertifikat sertifikat = sertifikatService.createCertificate(zahtev, user);

        emailService.sendCertificateRequestAccepted(user, this.extractUUIDFromAboutCertificate(sertifikat.getAbout()));

        return sertifikat;
    }

    public void reject(Odgovor odgovor) throws Exception {
        String zahtevUUID = this.extractUUIDFromAboutRequest(odgovor.getZahtevURI());
        Optional<ZahtevZaSertifikat> maybeZahtev = ((ZahtevZaSertifikatDAO) documentDAO).retrieveById(zahtevUUID);
        ZahtevZaSertifikat zahtev = maybeZahtev.orElseThrow(() -> new NotFoundException(""));
        zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.ODBIJEN);
        documentDAO.save(zahtevUUID + ".xml", zahtev);

        String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
        User user = userDAO.getByUsername(username).get(0);
        emailService.sendCertificateRequestRejected(odgovor.getRazlogOdbijanja(), user);
    }

    private String extractUsernameFromAbout(String about) {
        return about.substring(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.length());
    }

    private String extractUUIDFromAboutRequest(String about) {
        return about.substring(MetadataConstants.REQUEST_ABOUT_PREFIX.length());
    }

    private String extractUUIDFromAboutCertificate(String about) {
        return about.substring(MetadataConstants.CERTIFICATE_ABOUT_PREFIX.length());
    }
}
