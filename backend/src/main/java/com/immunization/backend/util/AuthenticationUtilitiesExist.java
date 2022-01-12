package com.immunization.backend.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthenticationUtilitiesExist {

	/**
	 * Connection parameters.
	 */
	static public class ConnectionProperties {
		public String host;
		public int port;
		public String user;
		public String password;
		public String driver;
		public String uri;

		public ConnectionProperties(Properties props) {
			user = props.getProperty("conn.user").trim();
			password = props.getProperty("conn.password").trim();

			host = props.getProperty("conn.host").trim();
			port = Integer.parseInt(props.getProperty("conn.port"));

			String connectionUri = "xmldb:exist://%1$s:%2$s/exist/xmlrpc";
			uri = String.format(connectionUri, host, port);
			
			driver = props.getProperty("conn.driver").trim();
		}
	}

	/**
	 * Read the configuration properties.
	 * 
	 * @return the configuration object
	 */
	public static ConnectionProperties loadProperties() throws IOException {
		String propsName = "exist.properties";

		InputStream propsStream = openStream(propsName);
		if (propsStream == null)
			throw new IOException("Could not read properties " + propsName);

		Properties props = new Properties();
		props.load(propsStream);

		return new ConnectionProperties(props);
	}

	/**
	 * Read a resource.
	 * 
	 * @param fileName
	 *            the name of the resource
	 * @return an input stream for the resource
	 */
	public static InputStream openStream(String fileName) {
		return AuthenticationUtilitiesExist.class.getClassLoader().getResourceAsStream(fileName);
	}
	
}
