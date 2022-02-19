package com.immunization.common.constants;

public abstract class MetadataConstants {
    public static String ABOUT_PREFIX = "http://www.ftn.uns.ac.rs/";
    public static String ABOUT_LICNI_PODACI_PREFIX = ABOUT_PREFIX.concat("licni-podaci/");
    public static String ABOUT_CONSENT_PREFIX = ABOUT_PREFIX.concat("saglasnost/");
    public static String ABOUT_RESIDENCE_PREFIX = ABOUT_PREFIX.concat("prebivaliste/");
    public static String REQUEST_ABOUT_PREFIX = ABOUT_PREFIX.concat("zahtev-za-sertifikat/");
    public static String CERTIFICATE_ABOUT_PREFIX = ABOUT_PREFIX.concat("digitalni-sertifikat/");
    public static String CONFIRMATION_ABOUT_PREFIX = ABOUT_PREFIX.concat("potvrda/");

    public static String RDF_GRAPH_URI = "/immunization-metadata";

    public static String CERTIFICATE_URI_PREFIX = "http://localhost:8080/api/digitalni-sertifikat/pdf/";
    public static String CONFIRMATION_URI_PREFIX = "http://localhost:8080/api/potvrda/pdf/";
}
