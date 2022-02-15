package com.immunization.trustee.service;

import com.immunization.common.exception.BadRequestException;
import com.immunization.trustee.dao.VaccineAmountDAO;
import com.immunization.trustee.dto.vaccine.VaccineAmount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VaccineAmountService {
    private VaccineAmountDAO vaccineAmountDAO;

    public void updateAmount(VaccineAmount vaccineAmount) throws Exception {
        Optional<VaccineAmount> maybeVaccine = vaccineAmountDAO.retrieveById(vaccineAmount.getType());
        if (maybeVaccine.isPresent()) {
            VaccineAmount vaccine = maybeVaccine.get();
            boolean updated = false;
            for (VaccineAmount.Series series : vaccineAmount.getSeries()) {
                for (VaccineAmount.Series existingSeries : vaccine.getSeries()) {
                    if (Objects.equals(series.getSerialNumber(), existingSeries.getSerialNumber())) {
                        existingSeries.setAmount(existingSeries.getAmount()+series.getAmount());
                        updated = true;
                        break;
                    }
                }
                if (!updated)
                    vaccine.getSeries().add(series);
            }
            vaccineAmountDAO.save(vaccineAmount.getType(), vaccine);
        } else {
            vaccineAmountDAO.save(vaccineAmount.getType(), vaccineAmount);
        }
    }

    public List<VaccineAmount> getAll() throws Exception {
        return vaccineAmountDAO.retrieveAll();
    }

    public boolean decrementAmount(String vaccineType, Integer serialNumber) throws Exception {
        Optional<VaccineAmount> maybeVaccine = vaccineAmountDAO.retrieveById(vaccineType);
        if (maybeVaccine.isPresent()) {
            VaccineAmount vaccine = maybeVaccine.get();
            for (VaccineAmount.Series series : vaccine.getSeries()) {
                if (Objects.equals(series.getSerialNumber(), serialNumber)) {
                    int newAmount = series.getAmount()-1;
                    if (newAmount < 0)
                        throw new BadRequestException("Amount cannot be negative");
                    series.setAmount(newAmount);
                    vaccineAmountDAO.save(vaccineType, vaccine);
                    return true;
                }
            }
        }
        return false;
    }
}
