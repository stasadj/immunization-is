package com.immunization.common.util;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Component
public class PdfTransformer {
    @Autowired
    private FopFactory fopFactory;

    @Autowired
    private TransformerFactory transformerFactory;

    private String XSL_FILE;

    public ByteArrayInputStream generatePDF(String documentXml, Class<?> classOfDocument) {
        try {
            setXSLFile(classOfDocument);

            StreamSource transformSource = new StreamSource(new ClassPathResource(XSL_FILE).getFile());
            StreamSource source = new StreamSource(new ByteArrayInputStream(documentXml.getBytes()));
            FOUserAgent userAgent = fopFactory.newFOUserAgent();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);
            Result res = new SAXResult(fop.getDefaultHandler());
            xslFoTransformer.transform(source, res);
            return new ByteArrayInputStream(outStream.toByteArray());
        } catch (Exception ignored) {
        }
        return null;
    }

    private void setXSLFile(Class<?> classOfDocument) {
        if (classOfDocument.equals(IskazivanjeInteresovanjaZaVakcinaciju.class))
            XSL_FILE = "to-pdf/interesovanje.xsl";
        else if (classOfDocument.equals(ObrazacSaglasnostiZaImunizaciju.class))
            XSL_FILE = "to-pdf/saglasnost.xsl";
        else if (classOfDocument.equals(PotvrdaOVakcinaciji.class))
            XSL_FILE = "to-pdf/potvrda_o_vakcinaciji.xsl";
        else if (classOfDocument.equals(ZahtevZaSertifikat.class))
            XSL_FILE = "to-pdf/zahtev_za_sertifikat.xsl";
        else if (classOfDocument.equals(DigitalniSertifikat.class))
            XSL_FILE = "to-pdf/digitalni_sertifikat.xsl";
    }
}