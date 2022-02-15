package com.immunization.trustee.dao;

import org.springframework.stereotype.Component;

import com.immunization.common.repository.Exist;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ImmunizationReportDAO {
	private final Exist exist;

	public Integer getNumberOfDocumentsOfInterest() {
		return 0;
	}

	public Integer getNumberOfCertificateRequests() {
		return 0;
	}

	public Integer getNumberOfCeritificatesIssued() {
		return 0;
	}

	public Integer getDistributionOfGivenVaccinesByManufacturer() {
		return 0;
	}

	public Integer getDistributionOfGivenVaccinesByDose() {
		return 0;
	}

}
