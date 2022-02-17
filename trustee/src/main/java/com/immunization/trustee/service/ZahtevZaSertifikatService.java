package com.immunization.trustee.service;

import org.springframework.stereotype.Service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.dao.ZahtevZaSertifikatDAO;
import com.immunization.common.model.User;
import com.immunization.common.model.util.StatusZahtevaValue;
import com.immunization.common.model.zahtev_za_sertifikat.ZahtevZaSertifikat;
import com.immunization.trustee.dto.response.Odgovor;
import com.immunization.trustee.service.email.TrusteeEmailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevZaSertifikatService {
	private final ZahtevZaSertifikatDAO zahtevDAO;
	private final UserDAO userDAO;
	private final TrusteeEmailService emailService;

	public void accept(Odgovor odgovor) throws Exception {
		String zahtevUUID = this.extractUUIDFromAbout(odgovor.getZahtevURI());
		ZahtevZaSertifikat zahtev = zahtevDAO.getByUUID(zahtevUUID);
		zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.PRIHVACEN);
		zahtevDAO.save(zahtevUUID + ".xml", zahtev);

		String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
		User user = userDAO.getByUsername(username).get(0);
		emailService.sendCertificateRequestAccepted(user);
	}

	public void reject(Odgovor odgovor) throws Exception {
		String zahtevUUID = this.extractUUIDFromAbout(odgovor.getZahtevURI());
		ZahtevZaSertifikat zahtev = zahtevDAO.getByUUID(zahtevUUID);
		zahtev.getMetaPodaci().getStatusZahteva().setValue(StatusZahtevaValue.ODBIJEN);
		zahtevDAO.save(zahtevUUID + ".xml", zahtev);

		String username = this.extractUsernameFromAbout(zahtev.getPodnosilacZahteva().getAbout());
		User user = userDAO.getByUsername(username).get(0);
		emailService.sendCertificateRequestRejected(odgovor.getRazlogOdbijanja(), user);
	}

	private String extractUsernameFromAbout(String about) {
		return about.substring(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.length());
	}

	private String extractUUIDFromAbout(String about) {
		return about.substring(MetadataConstants.REQUEST_ABOUT_PREFIX.length());
	}

}
