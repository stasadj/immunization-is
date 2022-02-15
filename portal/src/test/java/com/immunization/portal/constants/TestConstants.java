package com.immunization.portal.constants;

import com.immunization.portal.dto.UserRegistrationDTO;
import com.immunization.portal.util.NumberStringGenerator;

public class TestConstants {
    private TestConstants() {
    }

    public static UserRegistrationDTO USER_REGISTRATION_DTO = new UserRegistrationDTO(
            String.format("email%s@email.com", NumberStringGenerator.generateNumberSequence(10)),
            "password",
            "first_name".concat(NumberStringGenerator.generateNumberSequence(10)),
            "last_name");
}
