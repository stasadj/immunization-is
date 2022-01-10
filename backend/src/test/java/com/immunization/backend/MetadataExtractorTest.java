package com.immunization.backend;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.immunization.backend.service.MetadataExtractorService;
import com.immunization.backend.util.AuthenticationUtilitiesFuseki;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MetadataExtractorTest {
	@Autowired
	private MetadataExtractorService metadataExtractorService;

	private static final String GRAPH_URI_SERT = "/digitalni-sertifikat/metadata";
	private static final String XML_FILE_SERT = "./src/main/resources/documents/digitalni_sertifikat.xml";
	private static final String RDF_FILE_SERT = "./src/main/resources/rdf/digitalni_sertifikat.rdf";

	private static final String GRAPH_URI_ZAHTEV = "/zahtev-za-sertifikat/metadata";
	private static final String XML_FILE_ZAHTEV = "./src/main/resources/documents/zahtev_za_sertifikat.xml";
	private static final String RDF_FILE_ZAHTEV = "./src/main/resources/rdf/zahtev_za_sertifikat.rdf";

	private static final String GRAPH_URI_INTERESOVANJE = "/interesovanje/metadata";
	private static final String XML_FILE_INTERESOVANJE = "./src/main/resources/documents/interesovanje.xml";
	private static final String RDF_FILE_INTERESOVANJE = "./src/main/resources/rdf/interesovanje.rdf";

	@Test
	@Order(1)
	public void testInitRDFStore_zahtevZaSertifikat() throws FileNotFoundException, TransformerException, IOException {
		metadataExtractorService.initRDFStore(AuthenticationUtilitiesFuseki.loadProperties(), XML_FILE_ZAHTEV,
				RDF_FILE_ZAHTEV, GRAPH_URI_ZAHTEV);
		metadataExtractorService.dropGraph(AuthenticationUtilitiesFuseki.loadProperties(), GRAPH_URI_ZAHTEV);
	}

	@Test
	@Order(2)
	public void testInitRDFStore_sertifikat() throws FileNotFoundException, TransformerException, IOException {
		metadataExtractorService.initRDFStore(AuthenticationUtilitiesFuseki.loadProperties(), XML_FILE_SERT,
				RDF_FILE_SERT, GRAPH_URI_SERT);
		metadataExtractorService.dropGraph(AuthenticationUtilitiesFuseki.loadProperties(), GRAPH_URI_SERT);
	}

	@Test
	@Order(3)
	public void testInitRDFStore_interesovanje() throws FileNotFoundException, TransformerException, IOException {
		metadataExtractorService.initRDFStore(AuthenticationUtilitiesFuseki.loadProperties(), XML_FILE_INTERESOVANJE,
				RDF_FILE_INTERESOVANJE, GRAPH_URI_INTERESOVANJE);
		metadataExtractorService.dropGraph(AuthenticationUtilitiesFuseki.loadProperties(), GRAPH_URI_INTERESOVANJE);
	}
}
