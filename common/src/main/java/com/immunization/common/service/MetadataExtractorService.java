package com.immunization.common.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.immunization.common.util.AuthenticationUtilitiesFuseki.ConnectionProperties;

import com.immunization.common.util.SparqlUtil;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class MetadataExtractorService {
	@Autowired
	private ConnectionProperties conn;

	private static final String XSLT_FILE = "xsl/grddl.xsl";

    private Resource loadXsltFileAsResource() {
        return new ClassPathResource(XSLT_FILE);
    }

	public void extractMetadata(InputStream in, OutputStream out) throws TransformerException, IOException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// Create transformation source
		StreamSource transformSource = new StreamSource(loadXsltFileAsResource().getFile());

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

	public void insertFromString(String data, String graphUri)
			throws TransformerException, IOException {
		// TODO: Refactor and remove System.out
		System.out.println("[INFO] " + MetadataExtractorService.class.getSimpleName());

		InputStream inStream = new ByteArrayInputStream(data.getBytes());
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		System.out.println("[INFO] Extracting metadata from RDFa attributes...");
		System.out.println(data);
		extractMetadata(inStream, outStream);
		
		String rdfContents = new String(outStream.toByteArray(), StandardCharsets.UTF_8);
		System.out.println(rdfContents);

		// Loading a default model with extracted metadata
		Model model = ModelFactory.createDefaultModel();
		model.read(new ByteArrayInputStream(rdfContents.getBytes()), null);;

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		model.write(out, SparqlUtil.NTRIPLES);

		System.out.println("[INFO] Extracted metadata as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		// Writing the named graph
		System.out.println("[INFO] Populating named graph \"" + graphUri + "\" with extracted metadata.");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + graphUri, out.toString());
		System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();

		System.out.println("[INFO] End.");
	}

	public boolean getPatientExists(String patientID, String graphUri) {
		String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + graphUri, "?s ?p ?o . filter( ?s = <" + patientID + "> )");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

		// Query the collection, dump output response as XML
		ResultSet results = query.execSelect();
		boolean result = results.hasNext();

		ResultSetFormatter.out(System.out, results);
		query.close();

		return result;
	}

	public void initRDFStore(String xmlFilePath, String rdfFilePath, String graphUri)
			throws TransformerException, IOException {
		System.out.println("[INFO] " + MetadataExtractorService.class.getSimpleName());

		System.out.println("[INFO] Extracting metadata from RDFa attributes...");
		extractMetadata(new FileInputStream(xmlFilePath), new FileOutputStream(rdfFilePath));

		// Loading a default model with extracted metadata
		Model model = ModelFactory.createDefaultModel();
		model.read(rdfFilePath);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		model.write(out, SparqlUtil.NTRIPLES);

		System.out.println("[INFO] Extracted metadata as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		// Writing the named graph
		System.out.println("[INFO] Populating named graph \"" + graphUri + "\" with extracted metadata.");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + graphUri, out.toString());
		// System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();

		// Read the triples from the named graph
		System.out.println();
		System.out.println("[INFO] Retrieving triples from RDF store.");
		System.out.println("[INFO] Using \"" + graphUri + "\" named graph.");

		System.out.println("[INFO] Selecting the triples from the named graph \"" + graphUri + "\".");
		String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + graphUri, "?s ?p ?o");

		// Create a QueryExecution that will access a SPARQL service over HTTP
		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

		// Query the collection, dump output response as XML
		ResultSet results = query.execSelect();

		ResultSetFormatter.out(System.out, results);

		query.close();

		System.out.println("[INFO] End.");
	}

	public void dropGraph(String graphUri) {
		// Dropping the third graph...
		System.out.println("[INFO] Dropping the named graph \"" + graphUri + "\"...");

		UpdateRequest dropRequest = UpdateFactory.create();

		String sparqlUpdate = SparqlUtil.dropGraph(conn.dataEndpoint + graphUri);
		System.out.println(graphUri);

		dropRequest.add(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(dropRequest, conn.updateEndpoint);
		processor.execute();

		System.out.println("[INFO] End.");
	}

}
