package com.immunization.portal.service;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.User;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat.MetaPodaci.StatusZahteva;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.service.XMLCalendarService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevService {

    private ZahtevZaSertifikatDAO zahtevDAO;
    private MetadataExtractorService metadataExtractorService;
    private MarshallerService marshallerService;
    private UUIDService uuidService;
    private XMLCalendarService calendarUtil;

    public ZahtevZaSertifikat create(ZahtevZaSertifikat zahtev, User user) throws Exception {

        String uuid = uuidService.getUUID();

        // setting uuid in about
        zahtev.setAbout("http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/" + uuid);

        // setting podnosilac jmbg in podnosilac about
        zahtev.getPodnosilacZahteva().setAbout("http://www.ftn.uns.ac.rs/licni-podaci/" + user.getUsername());

        // setting new zahtev status
        StatusZahteva status = new StatusZahteva();
        status.setValue(StatusZahtevaValue.NA_CEKANJU);
        zahtev.getMetaPodaci().setStatusZahteva(status);

        // setting date
        XMLGregorianCalendar xmlCalendar = calendarUtil.getCurrentDate();
        zahtev.getMetaPodaci().getDatumIzdavanja().setValue(xmlCalendar.toString());

        // extracting metadata
        if (!extractAndSaveMetadata(zahtev)) {
            throw new FailedMetadataExtractionException();
        }

        // saving
        String documentId = uuid + ".xml";
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
