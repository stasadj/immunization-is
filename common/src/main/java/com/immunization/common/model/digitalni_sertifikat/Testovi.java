//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.digitalni_sertifikat;

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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}RT_test"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}Ag_RDT_test"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}RBD_S_protein_test"/&gt;
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
    "rtTest",
    "agRDTTest",
    "rbdsProteinTest"
})
@XmlRootElement(name = "testovi")
public class Testovi {

    @XmlElement(name = "RT_test", required = true)
    protected TTest rtTest;
    @XmlElement(name = "Ag_RDT_test", required = true)
    protected TTest agRDTTest;
    @XmlElement(name = "RBD_S_protein_test", required = true)
    protected TTest rbdsProteinTest;

    /**
     * Gets the value of the rtTest property.
     * 
     * @return
     *     possible object is
     *     {@link TTest }
     *     
     */
    public TTest getRTTest() {
        return rtTest;
    }

    /**
     * Sets the value of the rtTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTest }
     *     
     */
    public void setRTTest(TTest value) {
        this.rtTest = value;
    }

    /**
     * Gets the value of the agRDTTest property.
     * 
     * @return
     *     possible object is
     *     {@link TTest }
     *     
     */
    public TTest getAgRDTTest() {
        return agRDTTest;
    }

    /**
     * Sets the value of the agRDTTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTest }
     *     
     */
    public void setAgRDTTest(TTest value) {
        this.agRDTTest = value;
    }

    /**
     * Gets the value of the rbdsProteinTest property.
     * 
     * @return
     *     possible object is
     *     {@link TTest }
     *     
     */
    public TTest getRBDSProteinTest() {
        return rbdsProteinTest;
    }

    /**
     * Sets the value of the rbdsProteinTest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTest }
     *     
     */
    public void setRBDSProteinTest(TTest value) {
        this.rbdsProteinTest = value;
    }

}
