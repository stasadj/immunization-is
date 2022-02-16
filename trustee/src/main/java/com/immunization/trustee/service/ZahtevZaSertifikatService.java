package com.immunization.trustee.service;

import org.springframework.stereotype.Service;

import com.immunization.common.constants.MetadataConstants;
import com.immunization.common.dao.UserDAO;
import com.immunization.common.model.User;
import com.immunization.trustee.dto.response.Odgovor;
import com.immunization.trustee.service.email.TrusteeEmailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ZahtevZaSertifikatService {
	private final UserDAO userDAO;
	private final TrusteeEmailService emailService;

	public void accept(Odgovor odgovor) {
		String username = this.extractUsernameFromAbout(odgovor.getUserUri());
		User user = userDAO.getByUsername(username).get(0);
		emailService.sendCertificateRequestAccepted(user);
	}

	public void reject(Odgovor odgovor) {
		String username = this.extractUsernameFromAbout(odgovor.getUserUri());
		User user = userDAO.getByUsername(username).get(0);
		emailService.sendCertificateRequestRejected(odgovor.getRazlogOdbijanja(), user);
	}

	private String extractUsernameFromAbout(String about) {
		return about.substring(MetadataConstants.ABOUT_LICNI_PODACI_PREFIX.length());
	}

}
