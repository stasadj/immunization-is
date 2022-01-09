package com.immunization.backend.service;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Service;

import com.immunization.backend.util.AuthenticationUtilitiesFuseki;
import com.immunization.backend.util.AuthenticationUtilitiesFuseki.ConnectionProperties;

import com.immunization.backend.util.SparqlUtil;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Service
public class MetadataExtractorService {
	private static final String SPARQL_NAMED_GRAPH_URI = "/zahtev-za-sertifikat/metadata";
	
	private static final String XML_FILE = "./src/main/resources/documents/zahtev_za_sertifikat.xml";
	private static final String XSLT_FILE = "./src/main/resources/xsl/grddl.xsl";
	private static final String RDF_FILE = "./src/main/resources/rdf/zahtev_za_sertifikat.rdf";

	public void extractMetadata(InputStream in, OutputStream out) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// Create transformation source
		StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

		// Initialize GRDDL transformer object
		Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

		// Set the indentation properties
		grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
		grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// Initialize transformation subject
		StreamSource source = new StreamSource(in);

		// Initialize result stream
		StreamResult result = new StreamResult(out);

		// Trigger the transformation
		grddlTransformer.transform(source, result);
	}

	public void initRDFStore(ConnectionProperties conn, String xmlFilePath, String rdfFilePath)
			throws FileNotFoundException, TransformerException {
		System.out.println("[INFO] " + MetadataExtractorService.class.getSimpleName());

		System.out.println("[INFO] Extracting metadata from RDFa attributes...");
		extractMetadata(new FileInputStream(new File(xmlFilePath)), new FileOutputStream(new File(rdfFilePath)));

		// Loading a default model with extracted metadata
		Model model = ModelFactory.createDefaultModel();
		model.read(rdfFilePath);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		model.write(out, SparqlUtil.NTRIPLES);

		System.out.println("[INFO] Extracted metadata as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		// Writing the named graph
		System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI,
				new String(out.toByteArray()));
		System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();

		// Read the triples from the named graph
		System.out.println();
		System.out.println("[INFO] Retrieving triples from RDF store.");
		System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

		System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
		String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

		// Query the collection, dump output response as XML
		ResultSet results = query.execSelect();

		ResultSetFormatter.out(System.out, results);

		query.close();

		System.out.println("[INFO] End.");
	}

	public static void main(String[] args) throws Exception {
		new MetadataExtractorService().initRDFStore(AuthenticationUtilitiesFuseki.loadProperties(), XML_FILE, RDF_FILE);
	}

}
