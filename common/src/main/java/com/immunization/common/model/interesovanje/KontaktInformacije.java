//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.interesovanje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/interesovanje/}email_adresa"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/interesovanje/}fiksni_telefon"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/interesovanje/}mobilni_telefon"/&gt;
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
    "emailAdresa",
    "fiksniTelefon",
    "mobilniTelefon"
})
@XmlRootElement(name = "kontakt_informacije")
public class KontaktInformacije {

    @XmlElement(name = "email_adresa", required = true)
    protected String emailAdresa;
    @XmlElement(name = "fiksni_telefon", required = true)
    protected String fiksniTelefon;
    @XmlElement(name = "mobilni_telefon", required = true)
    protected String mobilniTelefon;

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

    /**
     * Gets the value of the fiksniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiksniTelefon() {
        return fiksniTelefon;
    }

    /**
     * Sets the value of the fiksniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiksniTelefon(String value) {
        this.fiksniTelefon = value;
    }

    /**
     * Gets the value of the mobilniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    /**
     * Sets the value of the mobilniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilniTelefon(String value) {
        this.mobilniTelefon = value;
    }

}
