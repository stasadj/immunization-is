package com.immunization.trustee.service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.DigitalniSertifikatDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.digitalni_sertifikat.*;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDate;

@Service
public class SertifikatService extends DocumentService<DigitalniSertifikat> {
    private final UUIDService uuidService;
    private final PotvrdaOVakcinacijiService potvrdaService;

    @Autowired
    protected SertifikatService(DigitalniSertifikatDAO documentDAO,
                                MetadataExtractorService metadataExtractorService,
                                MarshallerService marshallerService,
                                PdfTransformer pdfTransformer,
                                XhtmlTransformer xhtmlTransformer,
                                UUIDService uuidService,
                                PotvrdaOVakcinacijiService potvrdaService) {
        super(DigitalniSertifikat.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.uuidService = uuidService;
        this.potvrdaService = potvrdaService;
    }

    public DigitalniSertifikat createCertificate(ZahtevZaSertifikat zahtev) throws Exception {
        DigitalniSertifikat sertifikat = new DigitalniSertifikat();
        String uuid = uuidService.getUUID();
        sertifikat.setAbout(MetadataConstants.CERTIFICATE_ABOUT_PREFIX + uuid);
        sertifikat.setBroj(BigInteger.valueOf(((DigitalniSertifikatDAO)documentDAO).getNumberOfCeritificatesIssued() + 1));
        sertifikat.setDatumIzdavanja(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
        sertifikat.setQr(sertifikat.getAbout());
        sertifikat.setLicniPodaci(this.createLicniPodaci(zahtev));
        sertifikat.setVakcinacija(this.createVakcinacija(zahtev));
        sertifikat.setTestovi(this.createTestovi());
        byte[] b = { 20, 10, 30, 5 };
        sertifikat.setPotpis(b);

        if (!extractAndSaveMetadata(sertifikat)) {
            throw new FailedMetadataExtractionException();
        }

        documentDAO.save(uuid, sertifikat);

        return sertifikat;
    }

    private LicniPodaci createLicniPodaci(ZahtevZaSertifikat zahtev) {
        LicniPodaci podaci = new LicniPodaci();
        podaci.setAbout(zahtev.getPodnosilacZahteva().getAbout());
        podaci.setBrojPasosa(zahtev.getPodnosilacZahteva().getBrojPasosa());
        podaci.setDatumRodjenja(zahtev.getPodnosilacZahteva().getDatumRodjenja());
        podaci.setImePrezime(zahtev.getPodnosilacZahteva().getImePrezime());
        podaci.setJMBG(zahtev.getPodnosilacZahteva().getJmbg());
        podaci.setPol(zahtev.getPodnosilacZahteva().getPol());
        return podaci;
    }

    private Testovi createTestovi() {
        Testovi testovi = new Testovi();
        TTest test = new TTest();
        test.setDatumVremeIzdavanjaRezultata("");
        test.setDatumVremeUzorkovanja("");
        test.setLaboratorija("");
        test.setProizvodjac("");
        test.setRezultat("");
        test.setVrstaUzorka("");
        testovi.setAgRDTTest(test);
        testovi.setRBDSProteinTest(test);
        testovi.setRTTest(test);
        return testovi;
    }

    private Vakcinacija createVakcinacija(ZahtevZaSertifikat zahtev) throws Exception {
        PotvrdaOVakcinaciji potvrda = potvrdaService
                .getAllConfirmationsForUser(zahtev.getPodnosilacZahteva().getJmbg().getValue()).getPotvrde().stream()
                .reduce((p1, p2) -> p1.getVakcinacije().getVakcinacija().size() > p2.getVakcinacije().getVakcinacija().size()
                        ? p1
                        : p2)
                .orElseThrow(Exception::new);

        Vakcinacija vakcinacija = new Vakcinacija();

        for (int i = 0; i < potvrda.getVakcinacije().getVakcinacija().size(); i++) {
            com.immunization.common.model.potvrda_o_vakcinaciji.Vakcinacija vakcPotvrda = potvrda.getVakcinacije()
                    .getVakcinacija().get(i);
            Vakcina vakcina = new Vakcina();
            vakcina.setDatum(vakcPotvrda.getDatumDavanja());
            vakcina.setDoza(BigInteger.valueOf(i + 1));
            vakcina.setProizvodjacSerija(vakcPotvrda.getNazivVakcine() + ", " + vakcPotvrda.getBrojSerije());
            vakcina.setTip(vakcPotvrda.getNazivVakcine());
            vakcina.setZdravstvenaUstanova(potvrda.getVakcinacije().getZdravstvenaUstanova());

            vakcinacija.getVakcina().add(vakcina);
        }
        return vakcinacija;
    }
}
