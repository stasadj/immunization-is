package com.immunization.backend.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthenticationUtilitiesFuseki {
	/**
	 * ExampleProperties represents the configuration for the examples.
	 */
	static public class ConnectionProperties {

		public String endpoint;
		public String dataset;

		public String queryEndpoint;
		public String updateEndpoint;
		public String dataEndpoint;

		public ConnectionProperties(Properties props) {
			super();
			dataset = props.getProperty("conn.dataset").trim();
			endpoint = props.getProperty("conn.endpoint").trim();

			queryEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.query").trim());
			updateEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.update").trim());
			dataEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.data").trim());

			System.out.println("[INFO] Parsing connection properties:");
			System.out.println("[INFO] Query endpoint: " + queryEndpoint);
			System.out.println("[INFO] Update endpoint: " + updateEndpoint);
			System.out.println("[INFO] Graph store endpoint: " + dataEndpoint);
		}
	}

	/**
	 * Read the configuration properties for the example.
	 * 
	 * @return the configuration object
	 */
	public static ConnectionProperties loadProperties() throws IOException {
		String propsName = "fuseki.properties";

		InputStream propsStream = openStream(propsName);
		if (propsStream == null)
			throw new IOException("Could not read properties " + propsName);

		Properties props = new Properties();
		props.load(propsStream);

		return new ConnectionProperties(props);
	}

	/**
	 * Read a resource for an example.
	 * 
	 * @param fileName the name of the resource
	 * @return an input stream for the resource
	 */
	public static InputStream openStream(String fileName) {
		return AuthenticationUtilitiesExist.class.getClassLoader().getResourceAsStream(fileName);
	}

}
