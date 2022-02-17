package com.immunization.common.util;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

@Component
public class XhtmlTransformer {
    @Autowired
    private TransformerFactory transformerFactory;

    private String XSL_FILE;

    public ByteArrayInputStream generateXHTML(String documentXml, Class<?> classOfDocument) {
        ByteArrayInputStream retVal = null;
        File file = null;
        try {
            setXSLFile(classOfDocument);

            StreamSource transformSource = new StreamSource(new ClassPathResource(XSL_FILE).getFile());
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");
            StreamSource source = new StreamSource(new ByteArrayInputStream(documentXml.getBytes()));
            String HTML_FILE = "document.html";
            file = new File(HTML_FILE);
            FileOutputStream output = new FileOutputStream(file);
            StreamResult result = new StreamResult(output);
            transformer.transform(source, result);
            retVal = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
        } catch (Exception ignored) {
        } finally {
            assert file != null;
            boolean r = file.delete();
        }
        return retVal;
    }

    private void setXSLFile(Class<?> classOfDocument) {
        if (classOfDocument.equals(IskazivanjeInteresovanjaZaVakcinaciju.class))
            XSL_FILE = "to-xhtml/interesovanje.xsl";
        else if (classOfDocument.equals(ObrazacSaglasnostiZaImunizaciju.class))
            XSL_FILE = "to-xhtml/saglasnost.xsl";
        else if (classOfDocument.equals(PotvrdaOVakcinaciji.class))
            XSL_FILE = "to-xhtml/potvrda_o_vakcinaciji.xsl";
        else if (classOfDocument.equals(ZahtevZaSertifikat.class))
            XSL_FILE = "to-xhtml/zahtev_za_sertifikat.xsl";
        else if (classOfDocument.equals(DigitalniSertifikat.class))
            XSL_FILE = "to-xhtml/digitalni_sertifikat.xsl";
    }
}
