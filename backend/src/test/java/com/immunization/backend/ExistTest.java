package com.immunization.backend;

import com.immunization.backend.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.backend.repository.Exist;
import com.immunization.backend.service.UnmarshallerService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExistTest {
    @Autowired
    private Exist exist;
    @Autowired
    private UnmarshallerService unmarshallerService;

    @Test @Order(1)
    public void testSave() throws Exception {
        String xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/digitalni_sertifikat.xml")));
        DigitalniSertifikat sertifikat = (DigitalniSertifikat) unmarshallerService.unmarshal(xmlString);
        sertifikat.getLicniPodaci().getImePrezime().setValue("Ime Prezime");

        String id = exist.save("ds0.xml", sertifikat);
    }

    @Test @Order(2)
    public void testGet() throws Exception {
        DigitalniSertifikat sertifikat =  (DigitalniSertifikat) exist.retrieveById("ds0.xml", DigitalniSertifikat.class);

        Assertions.assertEquals("Ime Prezime", sertifikat.getLicniPodaci().getImePrezime().getValue());
    }
}
