//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.saglasnost;

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
 *         &lt;element name="saglasan" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="naziv_imunoloskog_leka" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "saglasan",
    "nazivImunoloskogLeka"
})
@XmlRootElement(name = "izjava_saglasnosti")
public class IzjavaSaglasnosti {

    protected boolean saglasan;
    @XmlElement(name = "naziv_imunoloskog_leka", required = true)
    protected String nazivImunoloskogLeka;

    /**
     * Gets the value of the saglasan property.
     * 
     */
    public boolean isSaglasan() {
        return saglasan;
    }

    /**
     * Sets the value of the saglasan property.
     * 
     */
    public void setSaglasan(boolean value) {
        this.saglasan = value;
    }

    /**
     * Gets the value of the nazivImunoloskogLeka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivImunoloskogLeka() {
        return nazivImunoloskogLeka;
    }

    /**
     * Sets the value of the nazivImunoloskogLeka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivImunoloskogLeka(String value) {
        this.nazivImunoloskogLeka = value;
    }

}
