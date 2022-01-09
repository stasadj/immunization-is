package com.immunization.backend;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.immunization.backend.service.MetadataExtractorService;
import com.immunization.backend.util.AuthenticationUtilitiesFuseki;

@SpringBootTest
public class MetadataExtractorTest {
	@Autowired
	private MetadataExtractorService metadataExtractorService;

	private static final String XML_FILE = "./src/main/resources/documents/zahtev_za_sertifikat.xml";
	private static final String RDF_FILE = "./src/main/resources/rdf/zahtev_za_sertifikat.rdf";

	@Test
	public void testInitRDFStore() throws FileNotFoundException, TransformerException, IOException {
		metadataExtractorService.initRDFStore(AuthenticationUtilitiesFuseki.loadProperties(), XML_FILE, RDF_FILE);
	}

}
