//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package com.immunization.backend.model.interesovanje;

import java.util.ArrayList;

import java.util.List;
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
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://www.ftn.uns.ac.rs/interesovanje/}opcija" maxOccurs="unbounded"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/interesovanje/}bilo_koja_vakcina"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "opcija",
    "biloKojaVakcina"
})
@XmlRootElement(name = "odabir_vakcina")
public class OdabirVakcina {

    protected List<String> opcija;
    @XmlElement(name = "bilo_koja_vakcina")
    protected String biloKojaVakcina;

    /**
     * Gets the value of the opcija property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opcija property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpcija().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOpcija() {
        if (opcija == null) {
            opcija = new ArrayList<String>();
        }
        return this.opcija;
    }

    /**
     * Gets the value of the biloKojaVakcina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiloKojaVakcina() {
        return biloKojaVakcina;
    }

    /**
     * Sets the value of the biloKojaVakcina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiloKojaVakcina(String value) {
        this.biloKojaVakcina = value;
    }

}
