package com.immunization.portal.service;

import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.User;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.*;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class ZahtevService extends DocumentService<ZahtevZaSertifikat> {
    private final UUIDService uuidService;
    private final XMLCalendarService calendarUtil;

    @Autowired
    public ZahtevService(ZahtevZaSertifikatDAO documentDAO,
                         MetadataExtractorService metadataExtractorService,
                         MarshallerService marshallerService,
                         PdfTransformer pdfTransformer,
                         XhtmlTransformer xhtmlTransformer,
                         UUIDService uuidService,
                         XMLCalendarService calendarUtil) {
        super(ZahtevZaSertifikat.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.uuidService = uuidService;
        this.calendarUtil = calendarUtil;
    }

    @Override
    public void create(ZahtevZaSertifikat zahtev, User user) throws Exception {
        String uuid = uuidService.getUUID();

        // setting uuid in about
        zahtev.setAbout("http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/" + uuid);

        // setting podnosilac jmbg in podnosilac about
        zahtev.getPodnosilacZahteva().setAbout("http://www.ftn.uns.ac.rs/licni-podaci/" + user.getUsername());

        // setting new zahtev status
        zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.NA_CEKANJU);

        // setting date
        XMLGregorianCalendar xmlCalendar = calendarUtil.getCurrentDate();
        zahtev.getMetaPodaci().getDatumIzdavanja().setValue(xmlCalendar.toString());

        // extracting metadata
        if (!extractAndSaveMetadata(zahtev)) {
            throw new FailedMetadataExtractionException();
        }

        documentDAO.save(uuid, zahtev);
    }
}
