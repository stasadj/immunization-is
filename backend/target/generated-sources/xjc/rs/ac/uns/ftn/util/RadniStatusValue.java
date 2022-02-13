//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package rs.ac.uns.ftn.util;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for radni_status_value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="radni_status_value"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="zaposlen"/&gt;
 *     &lt;enumeration value="nezaposlen"/&gt;
 *     &lt;enumeration value="penzioner"/&gt;
 *     &lt;enumeration value="u\u010denik"/&gt;
 *     &lt;enumeration value="student"/&gt;
 *     &lt;enumeration value="dete"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "radni_status_value")
@XmlEnum
public enum RadniStatusValue {

    @XmlEnumValue("zaposlen")
    ZAPOSLEN("zaposlen"),
    @XmlEnumValue("nezaposlen")
    NEZAPOSLEN("nezaposlen"),
    @XmlEnumValue("penzioner")
    PENZIONER("penzioner"),
    @XmlEnumValue("u\u010denik")
    U\u010cENIK("u\u010denik"),
    @XmlEnumValue("student")
    STUDENT("student"),
    @XmlEnumValue("dete")
    DETE("dete");
    private final String value;

    RadniStatusValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RadniStatusValue fromValue(String v) {
        for (RadniStatusValue c: RadniStatusValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
