package com.immunization.trustee.service;

import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import com.immunization.trustee.dto.confirmation.PotvrdeOVakcinaciji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotvrdaOVakcinacijiService extends DocumentService<PotvrdaOVakcinaciji> {

	@Autowired
	public PotvrdaOVakcinacijiService(PotvrdaOVakcinacijiDAO documentDAO,
									 MetadataExtractorService metadataExtractorService,
									 MarshallerService marshallerService,
									 PdfTransformer pdfTransformer,
									 XhtmlTransformer xhtmlTransformer) {
		super(PotvrdaOVakcinaciji.class,
				documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
	}

	public PotvrdeOVakcinaciji getAllConfirmationsForUser(String jmbg) throws Exception {
		PotvrdeOVakcinaciji potvrde = new PotvrdeOVakcinaciji();
		potvrde.setPotvrde(((PotvrdaOVakcinacijiDAO)documentDAO).getAllConfirmationsByJmbg(jmbg));
		return potvrde;
	}
}
