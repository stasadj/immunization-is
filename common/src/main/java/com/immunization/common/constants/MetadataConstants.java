package com.immunization.common.constants;

public abstract class MetadataConstants {
	public static String ABOUT_PREFIX = "http://www.ftn.uns.ac.rs/";
	public static String ABOUT_LICNI_PODACI_PREFIX = ABOUT_PREFIX.concat("licni-podaci/");
	public static String CONSENT_ABOUT_PREFIX = ABOUT_PREFIX.concat("saglasnost/");
	public static String REQUEST_ABOUT_PREFIX = ABOUT_PREFIX.concat("zahtev-za-sertifikat/");
	public static String CERTIFICATE_ABOUT_PREFIX = ABOUT_PREFIX.concat("digitalni-sertifikat/");

	public static String RDF_GRAPH_URI = "/immunization-metadata";
}