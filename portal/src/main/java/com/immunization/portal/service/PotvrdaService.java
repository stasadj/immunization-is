package com.immunization.portal.service;

import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.model.User;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotvrdaService extends DocumentService<PotvrdaOVakcinaciji> {
    private final UUIDService uuidService;
    private final UserDAO userDAO;

    @Autowired
    public PotvrdaService(PotvrdaOVakcinacijiDAO documentDAO,
                          MetadataExtractorService metadataExtractorService,
                          MarshallerService marshallerService,
                          PdfTransformer pdfTransformer,
                          XhtmlTransformer xhtmlTransformer,
                          UUIDService uuidService,
                          UserDAO userDAO) {
        super(PotvrdaOVakcinaciji.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.uuidService = uuidService;
        this.userDAO = userDAO;
    }

    public PotvrdaOVakcinaciji createPotvrda(ObrazacSaglasnostiZaImunizaciju saglasnost, User user) throws Exception {

        PotvrdaOVakcinaciji potvrdaOVakcinaciji = new PotvrdaOVakcinaciji();

        // TODO

        String id = documentDAO.save(uuidService.getUUID(), potvrdaOVakcinaciji);

        user.getDocuments().getSaglasnost().add(id);
        userDAO.save(user);

        return potvrdaOVakcinaciji;
    }
}
