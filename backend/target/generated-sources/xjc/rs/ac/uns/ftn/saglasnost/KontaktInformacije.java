//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package rs.ac.uns.ftn.saglasnost;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fiksni_telefon" type="{http://ftn.uns.ac.rs/util}fiksni"/&gt;
 *         &lt;element name="mobilni_telefon" type="{http://ftn.uns.ac.rs/util}mobilni"/&gt;
 *         &lt;element name="email_adresa" type="{http://ftn.uns.ac.rs/util}email"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fiksniTelefon",
    "mobilniTelefon",
    "emailAdresa"
})
@XmlRootElement(name = "kontakt_informacije")
public class KontaktInformacije {

    @XmlElement(name = "fiksni_telefon", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger fiksniTelefon;
    @XmlElement(name = "mobilni_telefon", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger mobilniTelefon;
    @XmlElement(name = "email_adresa", required = true)
    protected String emailAdresa;

    /**
     * Gets the value of the fiksniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFiksniTelefon() {
        return fiksniTelefon;
    }

    /**
     * Sets the value of the fiksniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFiksniTelefon(BigInteger value) {
        this.fiksniTelefon = value;
    }

    /**
     * Gets the value of the mobilniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMobilniTelefon() {
        return mobilniTelefon;
    }

    /**
     * Sets the value of the mobilniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMobilniTelefon(BigInteger value) {
        this.mobilniTelefon = value;
    }

    /**
     * Gets the value of the emailAdresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAdresa() {
        return emailAdresa;
    }

    /**
     * Sets the value of the emailAdresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAdresa(String value) {
        this.emailAdresa = value;
    }

}