package com.immunization.trustee.service;

import com.immunization.common.constants.MetadataConstants;

import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import com.immunization.trustee.dto.confirmation.Potvrda;
import com.immunization.trustee.dto.confirmation.Potvrde;
import com.immunization.trustee.dto.confirmation.PotvrdeOVakcinaciji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotvrdaOVakcinacijiService extends DocumentService<PotvrdaOVakcinaciji> {

    @Autowired
    public PotvrdaOVakcinacijiService(PotvrdaOVakcinacijiDAO documentDAO,
            MetadataExtractorService metadataExtractorService, MarshallerService marshallerService,
            PdfTransformer pdfTransformer, XhtmlTransformer xhtmlTransformer) {
        super(PotvrdaOVakcinaciji.class, documentDAO, metadataExtractorService, marshallerService, pdfTransformer,
                xhtmlTransformer);
    }

    public PotvrdeOVakcinaciji getAllConfirmationsForUser(String jmbg) throws Exception {
        PotvrdeOVakcinaciji potvrde = new PotvrdeOVakcinaciji();
        potvrde.setPotvrde(((PotvrdaOVakcinacijiDAO) documentDAO).getAllConfirmationsByJmbg(jmbg));
        return potvrde;
    }

    public Potvrde getAllDTOConfirmationsForUser(String jmbg) throws Exception {
        Potvrde potvrdeOut = new Potvrde();
        potvrdeOut.setPotvrda(new ArrayList<Potvrda>());
        List<PotvrdaOVakcinaciji> potvrdeIn = ((PotvrdaOVakcinacijiDAO) documentDAO).getAllConfirmationsByJmbg(jmbg);
        for (PotvrdaOVakcinaciji p : potvrdeIn) {
            int len = p.getVakcinacije().getVakcinacija().size();
            potvrdeOut.getPotvrda()
                    .add(new Potvrda(this.extractUUIDFromAboutConfirmation(p.getAbout()),
                            p.getDatumIzdavanjaPotvrde().toString(), Integer.toString(len),
                            p.getVakcinacije().getVakcinacija().get(len - 1).getNazivVakcine()));
        }
        Collections.sort(potvrdeOut.getPotvrda(), new Comparator<Potvrda>() {

            @Override
            public int compare(Potvrda o1, Potvrda o2) {
                return o1.getDoza().compareTo(o2.getDoza());
            }
        });
        return potvrdeOut;
    }

    private String extractUUIDFromAboutConfirmation(String about) {
        return about.substring(MetadataConstants.CONFIRMATION_ABOUT_PREFIX.length());
    }
}
