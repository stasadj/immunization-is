package com.immunization.trustee.dao;

import com.immunization.common.repository.Exist;
import com.immunization.trustee.dto.vaccine.VaccineAmount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VaccineAmountDAO {
    private Exist exist;

    public Optional<VaccineAmount> retrieveById(String documentId) throws Exception {
        VaccineAmount vaccineAmount = (VaccineAmount) exist.retrieveById(documentId, VaccineAmount.class);
        return vaccineAmount == null ? Optional.empty() : Optional.of(vaccineAmount);
    }

    public List<VaccineAmount> retrieveAll() throws Exception {
        return exist.retrieveAllDocuments(VaccineAmount.class)
                .stream().map(o -> (VaccineAmount) o).collect(Collectors.toList());
    }

    public void save(String documentId, VaccineAmount vaccineAmount) throws Exception {
        exist.save(documentId, vaccineAmount);
    }

    public List<String> getTypes() throws Exception {
        return exist.query("//vaccine_amount", VaccineAmount.class, "", "")
                .stream().map(o->((VaccineAmount)o).getType()).collect(Collectors.toList());
    }
}
