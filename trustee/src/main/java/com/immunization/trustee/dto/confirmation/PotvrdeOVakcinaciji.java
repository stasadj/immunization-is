package com.immunization.trustee.dto.confirmation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.immunization.common.model.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "potvrde" })
@XmlRootElement(name = "potvrde_o_vakcinaciji")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PotvrdeOVakcinaciji {
	@XmlElement(name = "potvrda_o_vakcinaciji")
	protected List<PotvrdaOVakcinaciji> potvrde;
}
