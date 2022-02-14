package com.immunization.trustee.dto.vaccine;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VaccineReport", propOrder = {
        "vaccine"
})
@XmlRootElement(name = "vaccine_report")
public class VaccineReport {
    public List<VaccineAmount> vaccine;
}
