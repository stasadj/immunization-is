package com.immunization.backend.fuseki;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import com.immunization.backend.util.AuthenticationUtilitiesFuseki;
import com.immunization.backend.util.AuthenticationUtilitiesFuseki.ConnectionProperties;
import com.immunization.backend.util.SparqlUtil;

public class Example {

	private static final String ZAHTEV_ZA_SERTIFIKAT_URI = "/zahtev-za-sertifikat/metadata";

	public static void main(String[] args) throws Exception {
		run(AuthenticationUtilitiesFuseki.loadProperties());
	}

	public static void run(ConnectionProperties conn) throws IOException {

		System.out.println("[INFO] Loading triples from an RDF/XML to a model...");

		// RDF triples which are to be loaded into the model
		String rdfFilePath = "./src/main/resources/rdf/zahtev_za_sertifikat.rdf";

		// Creates a default model
		Model model = ModelFactory.createDefaultModel();
		model.read(rdfFilePath);

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		model.write(out, SparqlUtil.NTRIPLES);

		System.out.println("[INFO] Rendering model as RDF/XML...");
		model.write(System.out, SparqlUtil.RDF_XML);

		// Delete all of the triples in all of the named graphs
		UpdateRequest request = UpdateFactory.create();
		request.add(SparqlUtil.dropAll());

		/*
		 * Create UpdateProcessor, an instance of execution of an UpdateRequest.
		 * UpdateProcessor sends update request to a remote SPARQL update service.
		 */
		UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
		processor.execute();

		// Creating the first named graph and updating it with RDF data
		System.out.println("[INFO] Writing the triples to a named graph \"" + ZAHTEV_ZA_SERTIFIKAT_URI + "\".");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + ZAHTEV_ZA_SERTIFIKAT_URI,
				new String(out.toByteArray()));
		System.out.println(sparqlUpdate);

		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();

		System.out.println("[INFO] End.");
	}

}
