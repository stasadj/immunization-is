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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}vrsta_uzorka"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}proizvodjac"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}datum_vreme_uzorkovanja"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}datum_vreme_izdavanja_rezultata"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}rezultat"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}laboratorija"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTest", propOrder = {
    "vrstaUzorka",
    "proizvodjac",
    "datumVremeUzorkovanja",
    "datumVremeIzdavanjaRezultata",
    "rezultat",
    "laboratorija"
})
public class TTest {

    @XmlElement(name = "vrsta_uzorka", required = true)
    protected String vrstaUzorka;
    @XmlElement(required = true)
    protected String proizvodjac;
    @XmlElement(name = "datum_vreme_uzorkovanja", required = true)
    protected String datumVremeUzorkovanja;
    @XmlElement(name = "datum_vreme_izdavanja_rezultata", required = true)
    protected String datumVremeIzdavanjaRezultata;
    @XmlElement(required = true)
    protected String rezultat;
    @XmlElement(required = true)
    protected String laboratorija;

    /**
     * Gets the value of the vrstaUzorka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaUzorka() {
        return vrstaUzorka;
    }

    /**
     * Sets the value of the vrstaUzorka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaUzorka(String value) {
        this.vrstaUzorka = value;
    }

    /**
     * Gets the value of the proizvodjac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvodjac() {
        return proizvodjac;
    }

    /**
     * Sets the value of the proizvodjac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvodjac(String value) {
        this.proizvodjac = value;
    }

    /**
     * Gets the value of the datumVremeUzorkovanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumVremeUzorkovanja() {
        return datumVremeUzorkovanja;
    }

    /**
     * Sets the value of the datumVremeUzorkovanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumVremeUzorkovanja(String value) {
        this.datumVremeUzorkovanja = value;
    }

    /**
     * Gets the value of the datumVremeIzdavanjaRezultata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumVremeIzdavanjaRezultata() {
        return datumVremeIzdavanjaRezultata;
    }

    /**
     * Sets the value of the datumVremeIzdavanjaRezultata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumVremeIzdavanjaRezultata(String value) {
        this.datumVremeIzdavanjaRezultata = value;
    }

    /**
     * Gets the value of the rezultat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRezultat() {
        return rezultat;
    }

    /**
     * Sets the value of the rezultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRezultat(String value) {
        this.rezultat = value;
    }

    /**
     * Gets the value of the laboratorija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaboratorija() {
        return laboratorija;
    }

    /**
     * Sets the value of the laboratorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaboratorija(String value) {
        this.laboratorija = value;
    }

}
