package com.immunization.trustee.service;

import com.immunization.common.dao.VaccineAmountDAO;
import com.immunization.common.model.VaccineAmount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VaccineAmountService {
    private VaccineAmountDAO vaccineAmountDAO;

    public void updateAmount(VaccineAmount vaccineAmount) throws Exception {
        Optional<VaccineAmount> maybeVaccine = vaccineAmountDAO.retrieveById(vaccineAmount.getType());
        if (maybeVaccine.isPresent()) {
            VaccineAmount vaccine = maybeVaccine.get();
            if (vaccineAmount.getManufacturer().length() > 0)
                vaccine.setManufacturer(vaccineAmount.getManufacturer());
            boolean updated = false;
            for (VaccineAmount.Series series : vaccineAmount.getSeries()) {
                if (series.getAmount() == 0) continue;
                for (VaccineAmount.Series existingSeries : vaccine.getSeries()) {
                    if (Objects.equals(series.getSerialNumber(), existingSeries.getSerialNumber())) {
                        existingSeries.setAmount(existingSeries.getAmount() + series.getAmount());
                        updated = true;
                        break;
                    }
                }
                if (!updated)
                    vaccine.getSeries().add(series);
            }
            vaccineAmountDAO.save(vaccineAmount.getType(), vaccine);
        } else {
            vaccineAmount.setSeries(vaccineAmount.getSeries().stream().filter(s -> s.getAmount() > 0).collect(Collectors.toList()));
            vaccineAmountDAO.save(vaccineAmount.getType(), vaccineAmount);
        }
    }

    public List<VaccineAmount> getAll() throws Exception {
        return vaccineAmountDAO.retrieveAll();
    }

    public List<String> getTypes() throws Exception {
        return vaccineAmountDAO.getTypes();
    }
}
