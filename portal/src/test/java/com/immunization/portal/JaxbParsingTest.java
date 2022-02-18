package com.immunization.portal;

import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.izvestaj_o_imunizaciji.IzvestajOImunizaciji;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.UnmarshallerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;

import javax.xml.crypto.MarshalException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
public class JaxbParsingTest {

    @Autowired
    private UnmarshallerService unmarshallerService;

    @Autowired
    private MarshallerService marshallerService;

    @Test
    public void testUnmarshalling() throws IOException, MarshalException {
        System.out.println(" ======================== TEST digitalni_sertifikat ======================== ");
        String xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/digitalni_sertifikat.xml")));
        DigitalniSertifikat sertifikat = (DigitalniSertifikat) unmarshallerService.unmarshal(xmlString);
        System.out.println("Digitalni sertifikat date: " + sertifikat.getDatumIzdavanja());
        System.out.println("Digitalni sertifikat osoba: " + sertifikat.getLicniPodaci().getPol().getValue());
        System.out.println("Digitalni sertifikat broj doza osobe: " + sertifikat.getVakcinacija().getVakcina().size());
        sertifikat.getVakcinacija().getVakcina().forEach(vakc -> System.out.println("Proizvodjac vakcine: " + vakc.getProizvodjacSerija().trim()));

        System.out.println(" ======================== TEST interesovanje ======================== ");
        xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/interesovanje.xml")));
        IskazivanjeInteresovanjaZaVakcinaciju interesovanje = (IskazivanjeInteresovanjaZaVakcinaciju) unmarshallerService.unmarshal(xmlString);
        System.out.println("opstina: " + interesovanje.getZeljenaOpstinaVakcinacije());

        System.out.println(" ======================== TEST izvestaj_o_imunizaciji ======================== ");
        xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/izvestaj_o_imunizaciji.xml")));
        IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) unmarshallerService.unmarshal(xmlString);
        System.out.println("broj interesovanja: " + izvestaj.getBrojDokumenataOInteresovanju());


        System.out.println(" ======================== TEST potvrda_o_vakcinaciji ======================== ");
        xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/potvrda_o_vakcinaciji.xml")));
        PotvrdaOVakcinaciji potvrda = (PotvrdaOVakcinaciji) unmarshallerService.unmarshal(xmlString);
        System.out.println("datum izdavanja: " + potvrda.getDatumIzdavanjaPotvrde());

        System.out.println(" ======================== TEST saglasnost ======================== ");
        xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/saglasnost.xml")));
        ObrazacSaglasnostiZaImunizaciju saglasnost = (ObrazacSaglasnostiZaImunizaciju) unmarshallerService.unmarshal(xmlString);
        System.out.println("radni status pacijenta: " + saglasnost.getInformacijeOPacijentu().getRadniStatus().getValue());

        System.out.println(" ======================== TEST zahtev_za_sertifikat ======================== ");
        xmlString = new String(Files.readAllBytes(Paths.get("./src/main/resources/documents/zahtev_za_sertifikat.xml")));
        ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) unmarshallerService.unmarshal(xmlString);
        System.out.println("broj pasosa podnosioca: " + zahtev.getPodnosilacZahteva().getBrojPasosa().getValue());

        String result = marshallerService.marshal(zahtev);
        System.out.println(" ======================== TEST Marshaller:  ======================== ");
        System.out.println(result);

    }
}
