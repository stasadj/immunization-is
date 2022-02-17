package com.immunization.trustee.service;

import java.io.IOException;

import javax.xml.crypto.MarshalException;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrusteeMetadataExtractorService {
	private final MetadataExtractorService metadataExtractorService;
	private final MarshallerService marshallerService;

	public boolean extractAndSaveMetadata(IzvestajOImunizaciji izvestaj) {
		try {
			metadataExtractorService.insertFromString(marshallerService.marshal(izvestaj),
					MetadataConstants.RDF_GRAPH_URI);
		} catch (IOException | TransformerException | MarshalException e) {
			return false;
		}
		return true;
	}

	public boolean extractAndSaveMetadata(DigitalniSertifikat sertifikat) {
		try {
			metadataExtractorService.insertFromString(marshallerService.marshal(sertifikat),
					MetadataConstants.RDF_GRAPH_URI);
		} catch (IOException | TransformerException | MarshalException e) {
			return false;
		}
		return true;
	}
}
