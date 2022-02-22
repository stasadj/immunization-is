package com.immunization.portal.service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.User;
import com.immunization.common.model.potvrda_o_vakcinaciji.LicniPodaci;
import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.immunization.common.model.potvrda_o_vakcinaciji.Vakcinacija;
import com.immunization.common.model.potvrda_o_vakcinaciji.Vakcinacije;
import com.immunization.common.model.saglasnost.ObrazacSaglasnostiZaImunizaciju;
import com.immunization.common.model.saglasnost.Vakcina;
import com.immunization.common.service.DocumentService;
import com.immunization.common.service.MarshallerService;
import com.immunization.common.service.MetadataExtractorService;
import com.immunization.common.service.UUIDService;
import com.immunization.common.util.PdfTransformer;
import com.immunization.common.util.XhtmlTransformer;
import com.immunization.portal.service.email.PortalEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDate;

@Service
public class PotvrdaService extends DocumentService<PotvrdaOVakcinaciji> {
    private final UUIDService uuidService;
    private final UserDAO userDAO;
    private final QRCodeService qrService;
    private final PortalEmailService portalEmailService;
    private final VaccineAmountService vaccineAmountService;

    @Autowired
    public PotvrdaService(PotvrdaOVakcinacijiDAO documentDAO,
                          MetadataExtractorService metadataExtractorService,
                          MarshallerService marshallerService,
                          PdfTransformer pdfTransformer,
                          XhtmlTransformer xhtmlTransformer,
                          UUIDService uuidService,
                          UserDAO userDAO,
                          QRCodeService qrService,
                          PortalEmailService portalEmailService,
                          VaccineAmountService vaccineAmountService) {
        super(PotvrdaOVakcinaciji.class,
                documentDAO, metadataExtractorService, marshallerService, pdfTransformer, xhtmlTransformer);
        this.uuidService = uuidService;
        this.userDAO = userDAO;
        this.qrService = qrService;
        this.portalEmailService = portalEmailService;
        this.vaccineAmountService = vaccineAmountService;
    }

    public void createPotvrda(ObrazacSaglasnostiZaImunizaciju saglasnost) throws Exception {
        String username = saglasnost.getInformacijeOPacijentu()
                .getAbout().replace(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX, "");
        User user = userDAO.getByUsername(username).get(0);

        if (user.getDocuments().getSaglasnost().size() == user.getDocuments().getPotvrda().size())
            throw new BadRequestException("User already has Potvrda for every Saglasnost.");

        if (saglasnost.getEvidencijaOVakcinaciji().getIzvrsenaImunizacija().getVakcina().size()==0)
            throw new BadRequestException("Evidencija is missing.");

        PotvrdaOVakcinaciji potvrda = new PotvrdaOVakcinaciji();
        String uuid = uuidService.getUUID();
        potvrda.setAbout(MetadataConstants.ABOUT_PREFIX+"potvrda/"+uuid);
        potvrda.setSifraPotvrde(BigInteger.valueOf(Long.parseLong(uuid)));

        LicniPodaci licniPodaci = new LicniPodaci();
        licniPodaci.setPol(saglasnost.getInformacijeOPacijentu().getPol());
        licniPodaci.setImePrezime(saglasnost.getInformacijeOPacijentu().getPunoIme().getImePrezime());
        if (saglasnost.getInformacijeOPacijentu().getDrzavljanstvo().getSrpskoDrzavljanstvo()!=null)
            licniPodaci.setJmbg(saglasnost.getInformacijeOPacijentu().getDrzavljanstvo().getSrpskoDrzavljanstvo().getJmbg());
        licniPodaci.setAbout(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX+username);
        licniPodaci.setDatumRodjenja(saglasnost.getInformacijeOPacijentu().getDatumIMestoRodjenja().getDatumRodjenja());
        potvrda.setLicniPodaci(licniPodaci);

        potvrda.setDatumIzdavanjaPotvrde(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));

        potvrda.setQrKod(qrService.getBase64(MetadataConstants.CONFIRMATION_URI_PREFIX + uuid));

        Vakcinacije vakcinacije = new Vakcinacije();
        vakcinacije.setZdravstvenaUstanova(saglasnost.getEvidencijaOVakcinaciji().getZdravstvenaUstanova().getNaziv().getValue());

        for (Vakcina v : saglasnost.getEvidencijaOVakcinaciji().getIzvrsenaImunizacija().getVakcina()) {
            Vakcinacija vakcinacija = new Vakcinacija();
            vakcinacija.setNazivVakcine(v.getNaziv());
            vakcinacija.setBrojSerije(v.getSerija());
            vakcinacija.setDatumDavanja(v.getDatumDavanja());
            vakcinacije.getVakcinacija().add(vakcinacija);
        }

        Vakcinacija last = vakcinacije.getVakcinacija().get(vakcinacije.getVakcinacija().size()-1);
        potvrda.setVakcinacije(vakcinacije);

        documentDAO.save(uuid, potvrda);

        user.getDocuments().getPotvrda().add(uuid);
        userDAO.save(user);

        portalEmailService.sendConfirmation(user, uuid, generatePdf(uuid));
        if (vakcinacije.getVakcinacija().size()<3) portalEmailService.sendMailAboutAppointment(user, 21);

        vaccineAmountService.decrementAmount(last.getNazivVakcine(), last.getBrojSerije().intValue());
    }
}
