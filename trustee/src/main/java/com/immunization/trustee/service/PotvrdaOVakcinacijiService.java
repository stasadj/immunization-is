package com.immunization.trustee.service;

import org.springframework.stereotype.Service;

import com.immunization.common.dao.PotvrdaOVakcinacijiDAO;
import com.immunization.trustee.dto.confirmation.PotvrdeOVakcinaciji;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PotvrdaOVakcinacijiService {
	private final PotvrdaOVakcinacijiDAO potvrdaDAO;

	public PotvrdeOVakcinaciji getAllConfirmationsForUser(String jmbg) throws Exception {
		PotvrdeOVakcinaciji potvrde = new PotvrdeOVakcinaciji();
		potvrde.setPotvrde(potvrdaDAO.getAllConfirmationsByJmbg(jmbg));
		return potvrde;
	}
}
