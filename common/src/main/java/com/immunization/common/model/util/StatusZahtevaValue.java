//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.16 at 11:58:33 AM CET 
//

package com.immunization.common.model.util;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for status_zahteva_value.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="status_zahteva_value"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NA CEKANJU"/&gt;
 *     &lt;enumeration value="ODOBREN"/&gt;
 *     &lt;enumeration value="PRIHVACEN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "status_zahteva_value")
@XmlEnum
public enum StatusZahtevaValue {

	@XmlEnumValue("NA CEKANJU")
	NA_CEKANJU("NA CEKANJU"), ODBIJEN("ODBIJEN"), PRIHVACEN("PRIHVACEN");

	private final String value;

	StatusZahtevaValue(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static StatusZahtevaValue fromValue(String v) {
		for (StatusZahtevaValue c : StatusZahtevaValue.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
