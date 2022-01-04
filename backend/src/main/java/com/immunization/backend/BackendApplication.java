package com.immunization.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.xml.crypto.MarshalException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.immunization.backend.service.MarshallerService;
import com.immunization.backend.service.UnmarshallerService;

import rs.ac.uns.ftn.digitalni_sertifikat.DigitalniSertifikat;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws MarshalException, IOException {
		SpringApplication.run(BackendApplication.class, args);

		// TEST: Parsing digitalni sertifikat xml from file system
		String xmlString = new String(
				Files.readAllBytes(Paths.get("./src/main/resources/documents/digitalni_sertifikat.xml")));
		UnmarshallerService unmService = new UnmarshallerService(); // we will autowire this service in the future
		DigitalniSertifikat sert = (DigitalniSertifikat) unmService.unmarshal(xmlString, DigitalniSertifikat.class);
		System.out.println("Digitalni sertifikat date: " + sert.getDatumIzdavanja()); // TODO: On automatski prebaci u
																						// XML Gregorian
		System.out.println("Digitalni sertifikat osoba: " + sert.getLicniPodaci().getPol());
		System.out.println("Digitalni sertifikat broj doza osobe: " + sert.getVakcinacija().getVakcina().size());
		sert.getVakcinacija().getVakcina().forEach(vakc -> System.out.println(vakc.getProizvodjacSerija()));

		// TEST: OBJECT -> XML
		MarshallerService marshService = new MarshallerService(); // we will autowire this in the future
		marshService.marshal(sert); // printing to System.out

	}

}
