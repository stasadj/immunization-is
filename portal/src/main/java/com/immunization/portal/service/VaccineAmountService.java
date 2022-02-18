package com.immunization.portal.service;

import com.immunization.common.dao.VaccineAmountDAO;
import com.immunization.common.exception.base.BadRequestException;
import com.immunization.common.model.VaccineAmount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VaccineAmountService {
    private VaccineAmountDAO vaccineAmountDAO;

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

    public List<String> getTypes() throws Exception {
        return vaccineAmountDAO.getTypes();
    }

    public String choose(List<String> types) {

        return "";
    }
}
