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
 * <p>Java class for drzavljanstvo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="drzavljanstvo"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Državljanin Republike Srbije"/&gt;
 *     &lt;enumeration value="Strani državljanin sa boravkom u RS"/&gt;
 *     &lt;enumeration value="Strani državljanin bez boravka u RS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "drzavljanstvo")
@XmlEnum
public enum Drzavljanstvo {

    @XmlEnumValue("Dr\u017eavljanin Republike Srbije")
    DRŽAVLJANIN_REPUBLIKE_SRBIJE("Dr\u017eavljanin Republike Srbije"),
    @XmlEnumValue("Strani dr\u017eavljanin sa boravkom u RS")
    STRANI_DRŽAVLJANIN_SA_BORAVKOM_U_RS("Strani dr\u017eavljanin sa boravkom u RS"),
    @XmlEnumValue("Strani dr\u017eavljanin bez boravka u RS")
    STRANI_DRŽAVLJANIN_BEZ_BORAVKA_U_RS("Strani dr\u017eavljanin bez boravka u RS");
    private final String value;

    Drzavljanstvo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Drzavljanstvo fromValue(String v) {
        for (Drzavljanstvo c: Drzavljanstvo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
