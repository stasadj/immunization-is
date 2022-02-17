package com.immunization.common.service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.DocumentDAO;
import com.immunization.common.model.User;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public abstract class DocumentService<T> {
    private final Class<T> typeParameterClass;
    protected final DocumentDAO<T> documentDAO;
    private final MetadataExtractorService metadataExtractorService;
    private final MarshallerService marshallerService;
    private final PdfTransformer pdfTransformer;
    private final XhtmlTransformer xhtmlTransformer;


    protected DocumentService(Class<T> typeParameterClass, DocumentDAO<T> documentDAO, MetadataExtractorService metadataExtractorService, MarshallerService marshallerService, PdfTransformer pdfTransformer, XhtmlTransformer xhtmlTransformer) {
        this.typeParameterClass = typeParameterClass;
        this.documentDAO = documentDAO;
        this.metadataExtractorService = metadataExtractorService;
        this.marshallerService = marshallerService;
        this.pdfTransformer = pdfTransformer;
        this.xhtmlTransformer = xhtmlTransformer;
    }

    public void create(T document, User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public ByteArrayInputStream generatePdf(String documentId) throws Exception {
        String xml = documentDAO.getXML(documentId);
        System.out.println(xml);
        return pdfTransformer.generatePDF(xml, typeParameterClass);
    }

    public ByteArrayInputStream generateXhtml(String documentId) throws Exception {
        String xml = documentDAO.getXML(documentId);
        System.out.println(xml);
        return xhtmlTransformer.generateXHTML(xml, typeParameterClass);
    }

    protected boolean extractAndSaveMetadata(T document) {
        try {
            metadataExtractorService.insertFromString(marshallerService.marshal(document), MetadataConstants.RDF_GRAPH_URI);
        } catch (IOException | TransformerException | MarshalException e) {
            return false;
        }
        return true;
    }
}
