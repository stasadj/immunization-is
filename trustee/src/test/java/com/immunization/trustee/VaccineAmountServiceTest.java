package com.immunization.trustee;

import com.immunization.trustee.dto.vaccine.VaccineAmount;
import com.immunization.trustee.service.VaccineAmountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class VaccineAmountServiceTest {
    @Autowired
    private VaccineAmountService vaccineAmountService;

    @Test
    public void updateTest() throws Exception {
        VaccineAmount va = new VaccineAmount("Pfizer", "Biontech", new ArrayList<>());
        VaccineAmount.Series series = new VaccineAmount.Series(1000, 12345);
        va.getSeries().add(series);

        vaccineAmountService.updateAmount(va);


    }
}
