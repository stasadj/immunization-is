
package com.immunization.portal.service;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;

import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat.MetaPodaci.StatusZahteva;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.service.XMLCalendarService;
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
    private XMLCalendarService calendarUtil;


    public ZahtevZaSertifikat create(ZahtevZaSertifikat zahtev) throws Exception {

        String uuid = uuidService.getUUID();

        //setting uuid in about
        zahtev.setAbout("http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/" + uuid);

        //setting podnosilac jmbg in podnosilac about
        zahtev.getPodnosilacZahteva().setAbout("http://www.ftn.uns.ac.rs/licni-podaci/" + zahtev.getPodnosilacZahteva().getJmbg().getValue());

        //setting new zahtev status
        StatusZahteva status = new StatusZahteva();
        status.setValue(StatusZahtevaValue.NA_CEKANJU);
        zahtev.getMetaPodaci().setStatusZahteva(status);

        //setting date
        XMLGregorianCalendar xmlCalendar = calendarUtil.getCurrentDate();
        zahtev.getMetaPodaci().getDatumIzdavanja().setValue(xmlCalendar.toString());

        //extracting metadata
        if (!extractAndSaveMetadata(zahtev)) {
            throw new FailedMetadataExtractionException();
        }

        //saving
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

