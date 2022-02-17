//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.potvrda_o_vakcinaciji;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/}sifra_potvrde"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/}datum_izdavanja_potvrde"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/}qr_kod"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/}licni_podaci"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/potvrda-o-vakcinaciji/}vakcinacije"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="potreban_pecat" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
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
    "sifraPotvrde",
    "datumIzdavanjaPotvrde",
    "qrKod",
    "licniPodaci",
    "vakcinacije"
})
@XmlRootElement(name = "potvrda_o_vakcinaciji")
public class PotvrdaOVakcinaciji {

    @XmlElement(name = "sifra_potvrde", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sifraPotvrde;
    @XmlElement(name = "datum_izdavanja_potvrde", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanjaPotvrde;
    @XmlElement(name = "qr_kod", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String qrKod;
    @XmlElement(name = "licni_podaci", required = true)
    protected LicniPodaci licniPodaci;
    @XmlElement(required = true)
    protected Vakcinacije vakcinacije;
    @XmlAttribute(name = "potreban_pecat", required = true)
    protected boolean potrebanPecat;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;

    /**
     * Gets the value of the sifraPotvrde property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSifraPotvrde() {
        return sifraPotvrde;
    }

    /**
     * Sets the value of the sifraPotvrde property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSifraPotvrde(BigInteger value) {
        this.sifraPotvrde = value;
    }

    /**
     * Gets the value of the datumIzdavanjaPotvrde property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdavanjaPotvrde() {
        return datumIzdavanjaPotvrde;
    }

    /**
     * Sets the value of the datumIzdavanjaPotvrde property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdavanjaPotvrde(XMLGregorianCalendar value) {
        this.datumIzdavanjaPotvrde = value;
    }

    /**
     * Gets the value of the qrKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQrKod() {
        return qrKod;
    }

    /**
     * Sets the value of the qrKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQrKod(String value) {
        this.qrKod = value;
    }

    /**
     * Gets the value of the licniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link LicniPodaci }
     *     
     */
    public LicniPodaci getLicniPodaci() {
        return licniPodaci;
    }

    /**
     * Sets the value of the licniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicniPodaci }
     *     
     */
    public void setLicniPodaci(LicniPodaci value) {
        this.licniPodaci = value;
    }

    /**
     * Gets the value of the vakcinacije property.
     * 
     * @return
     *     possible object is
     *     {@link Vakcinacije }
     *     
     */
    public Vakcinacije getVakcinacije() {
        return vakcinacije;
    }

    /**
     * Sets the value of the vakcinacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vakcinacije }
     *     
     */
    public void setVakcinacije(Vakcinacije value) {
        this.vakcinacije = value;
    }

    /**
     * Gets the value of the potrebanPecat property.
     * 
     */
    public boolean isPotrebanPecat() {
        return potrebanPecat;
    }

    /**
     * Sets the value of the potrebanPecat property.
     * 
     */
    public void setPotrebanPecat(boolean value) {
        this.potrebanPecat = value;
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
