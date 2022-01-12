package com.immunization.backend;

import com.immunization.backend.service.MetadataExtractorService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.TransformerException;
import java.io.IOException;

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

	private static final String GRAPH_URI_IZVESTAJ = "/izvestaj/metadata";
	private static final String XML_FILE_IZVESTAJ = "./src/main/resources/documents/izvestaj_o_imunizaciji.xml";
	private static final String RDF_FILE_IZVESTAJ = "./src/main/resources/rdf/izvestaj_o_imunizaciji.rdf";

	private static final String GRAPH_URI_SAGLASNOST = "/saglasnost/metadata";
	private static final String XML_FILE_SAGLASNOST = "./src/main/resources/documents/saglasnost.xml";
	private static final String RDF_FILE_SAGLASNOST = "./src/main/resources/rdf/saglasnost.rdf";

	private static final String GRAPH_URI_POTVRDA = "/potvrda/metadata";
	private static final String XML_FILE_POTVRDA = "./src/main/resources/documents/potvrda_o_vakcinaciji.xml";
	private static final String RDF_FILE_POTVRDA = "./src/main/resources/rdf/potvrda_o_vakcinaciji.rdf";

	@Test
	@Order(1)
	public void testInitRDFStore_zahtevZaSertifikat() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_ZAHTEV, RDF_FILE_ZAHTEV, GRAPH_URI_ZAHTEV);
		metadataExtractorService.dropGraph(GRAPH_URI_ZAHTEV);
	}

	@Test
	@Order(2)
	public void testInitRDFStore_sertifikat() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_SERT, RDF_FILE_SERT, GRAPH_URI_SERT);
		metadataExtractorService.dropGraph(GRAPH_URI_SERT);
	}

	@Test
	@Order(3)
	public void testInitRDFStore_interesovanje() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_INTERESOVANJE, RDF_FILE_INTERESOVANJE, GRAPH_URI_INTERESOVANJE);
		metadataExtractorService.dropGraph(GRAPH_URI_INTERESOVANJE);
	}

	@Test
	@Order(4)
	public void testInitRDFStore_izvestaj() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_IZVESTAJ, RDF_FILE_IZVESTAJ, GRAPH_URI_IZVESTAJ);
		metadataExtractorService.dropGraph(GRAPH_URI_IZVESTAJ);
	}

	@Test
	@Order(5)
	public void testInitRDFStore_saglasnost() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_SAGLASNOST, RDF_FILE_SAGLASNOST, GRAPH_URI_SAGLASNOST);
		metadataExtractorService.dropGraph(GRAPH_URI_SAGLASNOST);
	}

	@Test
	@Order(6)
	public void testInitRDFStore_potvrda() throws TransformerException, IOException {
		metadataExtractorService.initRDFStore(XML_FILE_POTVRDA, RDF_FILE_POTVRDA, GRAPH_URI_POTVRDA);
		metadataExtractorService.dropGraph(GRAPH_URI_POTVRDA);
	}
}
