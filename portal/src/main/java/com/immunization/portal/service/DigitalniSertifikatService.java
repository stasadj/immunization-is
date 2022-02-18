package com.immunization.portal.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.immunization.common.dao.DigitalniSertifikatDAO;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;

@Service
public class DigitalniSertifikatService extends DocumentService<DigitalniSertifikat> {

    @Autowired
    public DigitalniSertifikatService(DigitalniSertifikatDAO documentDAO,
            MetadataExtractorService metadataExtractorService, MarshallerService marshallerService,
            PdfTransformer pdfTransformer, XhtmlTransformer xhtmlTransformer) {
        super(DigitalniSertifikat.class, documentDAO, metadataExtractorService, marshallerService, pdfTransformer,
                xhtmlTransformer);
    }

}
