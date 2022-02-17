package com.immunization.trustee.service;

import java.math.BigInteger;

import java.time.LocalDate;
import java.util.Optional;

import javax.xml.datatype.DatatypeFactory;

import com.immunization.common.exception.base.NotFoundException;
import org.springframework.stereotype.Service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.DigitalniSertifikatDAO;
import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.common.exception.FailedMetadataExtractionException;
import com.immunization.common.model.User;
import com.immunization.common.model.digitalni_sertifikat.DigitalniSertifikat;
import com.immunization.common.model.digitalni_sertifikat.LicniPodaci;
import com.immunization.common.model.digitalni_sertifikat.TTest;
import com.immunization.common.model.digitalni_sertifikat.Testovi;
import com.immunization.common.model.digitalni_sertifikat.Vakcina;
import com.immunization.common.model.digitalni_sertifikat.Vakcinacija;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.common.service.UUIDService;
import com.immunization.trustee.dto.response.Odgovor;
import com.immunization.trustee.service.email.TrusteeEmailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevZaSertifikatService {
    private final ZahtevZaSertifikatDAO zahtevDAO;
    private final DigitalniSertifikatDAO sertifikatDAO;
    private final PotvrdaOVakcinacijiDAO potvrdaDAO;
    private final UserDAO userDAO;

    private final TrusteeMetadataExtractorService metadataExtractorService;
    private final TrusteeEmailService emailService;
    private final UUIDService uuidService;

    public DigitalniSertifikat accept(Odgovor odgovor) throws Exception {
        String zahtevUUID = this.extractUUIDFromAbout(odgovor.getZahtevURI());

        Optional<ZahtevZaSertifikat> maybeZahtev = zahtevDAO.retrieveById(zahtevUUID);
        ZahtevZaSertifikat zahtev = maybeZahtev.orElseThrow(() -> new NotFoundException(""));
        zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.PRIHVACEN);
        zahtevDAO.save(zahtevUUID, zahtev);

        DigitalniSertifikat sertifikat = this.createCertificate(zahtev);

        String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
        User user = userDAO.getByUsername(username).get(0);
        emailService.sendCertificateRequestAccepted(user);

        return sertifikat;
    }

    public void reject(Odgovor odgovor) throws Exception {
        String zahtevUUID = this.extractUUIDFromAbout(odgovor.getZahtevURI());
        Optional<ZahtevZaSertifikat> maybeZahtev = zahtevDAO.retrieveById(zahtevUUID);
        ZahtevZaSertifikat zahtev = maybeZahtev.orElseThrow(() -> new NotFoundException(""));
        zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.ODBIJEN);
        zahtevDAO.save(zahtevUUID, zahtev);

        String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
        User user = userDAO.getByUsername(username).get(0);
        emailService.sendCertificateRequestRejected(odgovor.getRazlogOdbijanja(), user);
    }

    private DigitalniSertifikat createCertificate(ZahtevZaSertifikat zahtev) throws Exception {
        DigitalniSertifikat sertifikat = new DigitalniSertifikat();
        String uuid = uuidService.getUUID();
        sertifikat.setAbout(MetadataConstants.CERTIFICATE_ABOUT_PREFIX + uuid);
        sertifikat.setBroj(BigInteger.valueOf(sertifikatDAO.getNumberOfCeritificatesIssued() + 1));
        sertifikat.setDatumIzdavanja(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
        sertifikat.setQr(sertifikat.getAbout());
        sertifikat.setLicniPodaci(this.createLicniPodaci(zahtev));
        sertifikat.setVakcinacija(this.createVakcinacija(zahtev));
        sertifikat.setTestovi(this.createTestovi());
        byte b[] = { 20, 10, 30, 5 };
        sertifikat.setPotpis(b);

        if (!metadataExtractorService.extractAndSaveMetadata(sertifikat)) {
            throw new FailedMetadataExtractionException();
        }

        sertifikatDAO.save(uuid, sertifikat);

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

        PotvrdaOVakcinaciji potvrda = potvrdaDAO
                .getAllConfirmationsByJmbg(zahtev.getPodnosilacZahteva().getJmbg().getValue().toString()).stream()
                .reduce((p1,
                        p2) -> p1.getVakcinacije().getVakcinacija().size() > p2.getVakcinacije().getVakcinacija().size()
                                ? p1
                                : p2)
                .get();

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

    private String extractUsernameFromAbout(String about) {
        return about.substring(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.length());
    }

    private String extractUUIDFromAbout(String about) {
        return about.substring(MetadataConstants.REQUEST_ABOUT_PREFIX.length());
    }
}
