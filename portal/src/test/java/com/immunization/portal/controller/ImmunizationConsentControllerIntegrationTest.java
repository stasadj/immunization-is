package com.immunization.portal.controller;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.immunization.common.service.MetadataExtractorService;
import static com.immunization.portal.constants.MetadataConstants.RDF_GRAPH_URI;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class ImmunizationConsentControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MetadataExtractorService metadataExtractorService;

    private MockMvc mockMvc;

	private static final String XML_FILE_SAGLASNOST = "./src/main/resources/documents/saglasnost.xml";
	private static final String RDF_FILE_SAGLASNOST = "./src/main/resources/rdf/saglasnost.rdf";

    @BeforeAll
    void setup() throws Exception {
		metadataExtractorService.initRDFStore(XML_FILE_SAGLASNOST, RDF_FILE_SAGLASNOST, RDF_GRAPH_URI);
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @AfterAll
    void dropGraph() throws Exception {
		// metadataExtractorService.dropGraph(RDF_GRAPH_URI);
    }

    @Test
    @Order(1)
    void consentToImmunization_succesfully() throws Exception {
        // TODO: This is passing in debug but Ž is being read as ? during unmarshalling of the object.
        // Tried putting parameter of controller to be String but that still printed ? when reading it.
        File file = new File("./src/main/resources/documents/saglasnost.xml");
        String xmlData = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/consent/")
                .contentType(MediaType.APPLICATION_XML)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(xmlData))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
