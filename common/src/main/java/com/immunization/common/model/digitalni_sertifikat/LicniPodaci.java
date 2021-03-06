//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.digitalni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.immunization.common.model.util.BrojPasosa;
import com.immunization.common.model.util.DatumRodjenja;
import com.immunization.common.model.util.ImePrezime;
import com.immunization.common.model.util.Jmbg;
import com.immunization.common.model.util.Pol;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}ime_prezime"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}pol"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}datum_rodjenja"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}JMBG"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}broj_pasosa"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imePrezime",
    "pol",
    "datumRodjenja",
    "jmbg",
    "brojPasosa"
})
@XmlRootElement(name = "licni_podaci")
public class LicniPodaci {

    @XmlElement(name = "ime_prezime", required = true)
    protected ImePrezime imePrezime;
    @XmlElement(required = true)
    protected Pol pol;
    @XmlElement(name = "datum_rodjenja", required = true)
    protected DatumRodjenja datumRodjenja;
    @XmlElement(name = "JMBG", required = true)
    protected Jmbg jmbg;
    @XmlElement(name = "broj_pasosa", required = true)
    protected BrojPasosa brojPasosa;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;

    /**
     * Gets the value of the imePrezime property.
     * 
     * @return
     *     possible object is
     *     {@link ImePrezime }
     *     
     */
    public ImePrezime getImePrezime() {
        return imePrezime;
    }

    /**
     * Sets the value of the imePrezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImePrezime }
     *     
     */
    public void setImePrezime(ImePrezime value) {
        this.imePrezime = value;
    }

    /**
     * Gets the value of the pol property.
     * 
     * @return
     *     possible object is
     *     {@link Pol }
     *     
     */
    public Pol getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pol }
     *     
     */
    public void setPol(Pol value) {
        this.pol = value;
    }

    /**
     * Gets the value of the datumRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link DatumRodjenja }
     *     
     */
    public DatumRodjenja getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Sets the value of the datumRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatumRodjenja }
     *     
     */
    public void setDatumRodjenja(DatumRodjenja value) {
        this.datumRodjenja = value;
    }

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link Jmbg }
     *     
     */
    public Jmbg getJMBG() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Jmbg }
     *     
     */
    public void setJMBG(Jmbg value) {
        this.jmbg = value;
    }

    /**
     * Gets the value of the brojPasosa property.
     * 
     * @return
     *     possible object is
     *     {@link BrojPasosa }
     *     
     */
    public BrojPasosa getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * Sets the value of the brojPasosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrojPasosa }
     *     
     */
    public void setBrojPasosa(BrojPasosa value) {
        this.brojPasosa = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbout(String value) {
        this.about = value;
    }

}
