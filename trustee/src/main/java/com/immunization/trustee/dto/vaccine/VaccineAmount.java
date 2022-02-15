package com.immunization.trustee.dto.vaccine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VaccineAmount", propOrder = {
        "type",
        "manufacturer",
        "series",
})
@XmlRootElement(name = "vaccine_amount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineAmount {
    @XmlElement(required = true)
    private String type;
    @XmlElement(required = true)
    private String manufacturer;
    @XmlElement(required = true)
    private List<VaccineAmount.Series> series;


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "amount",
            "serialNumber"
    })
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Series {
        @XmlElement(required = true)
        private Integer amount;
        @XmlElement(required = true)
        private Integer serialNumber;
    }
}