//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package com.immunization.common.model.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.immunization.common.model.util.Pol;
import com.immunization.common.model.util.RadniStatus;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}drzavljanstvo"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}puno_ime"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}pol"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}datum_i_mesto_rodjenja"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}prebivaliste"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}kontakt_informacije"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}radni_status"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}zanimanje_zaposlenog"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}ustanova_socijalne_zastite"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/saglasnost/}izjava_saglasnosti"/&gt;
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
    "drzavljanstvo",
    "punoIme",
    "pol",
    "datumIMestoRodjenja",
    "prebivaliste",
    "kontaktInformacije",
    "radniStatus",
    "zanimanjeZaposlenog",
    "ustanovaSocijalneZastite",
    "izjavaSaglasnosti"
})
@XmlRootElement(name = "informacije_o_pacijentu")
public class InformacijeOPacijentu {

    @XmlElement(required = true)
    protected Drzavljanstvo drzavljanstvo;
    @XmlElement(name = "puno_ime", required = true)
    protected PunoIme punoIme;
    @XmlElement(required = true)
    protected Pol pol;
    @XmlElement(name = "datum_i_mesto_rodjenja", required = true)
    protected DatumIMestoRodjenja datumIMestoRodjenja;
    @XmlElement(required = true)
    protected Prebivaliste prebivaliste;
    @XmlElement(name = "kontakt_informacije", required = true)
    protected KontaktInformacije kontaktInformacije;
    @XmlElement(name = "radni_status", required = true)
    protected RadniStatus radniStatus;
    @XmlElement(name = "zanimanje_zaposlenog", required = true)
    protected String zanimanjeZaposlenog;
    @XmlElement(name = "ustanova_socijalne_zastite", required = true)
    protected UstanovaSocijalneZastite ustanovaSocijalneZastite;
    @XmlElement(name = "izjava_saglasnosti", required = true)
    protected IzjavaSaglasnosti izjavaSaglasnosti;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link Drzavljanstvo }
     *     
     */
    public Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Drzavljanstvo }
     *     
     */
    public void setDrzavljanstvo(Drzavljanstvo value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the punoIme property.
     * 
     * @return
     *     possible object is
     *     {@link PunoIme }
     *     
     */
    public PunoIme getPunoIme() {
        return punoIme;
    }

    /**
     * Sets the value of the punoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link PunoIme }
     *     
     */
    public void setPunoIme(PunoIme value) {
        this.punoIme = value;
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
     * Gets the value of the datumIMestoRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link DatumIMestoRodjenja }
     *     
     */
    public DatumIMestoRodjenja getDatumIMestoRodjenja() {
        return datumIMestoRodjenja;
    }

    /**
     * Sets the value of the datumIMestoRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatumIMestoRodjenja }
     *     
     */
    public void setDatumIMestoRodjenja(DatumIMestoRodjenja value) {
        this.datumIMestoRodjenja = value;
    }

    /**
     * Gets the value of the prebivaliste property.
     * 
     * @return
     *     possible object is
     *     {@link Prebivaliste }
     *     
     */
    public Prebivaliste getPrebivaliste() {
        return prebivaliste;
    }

    /**
     * Sets the value of the prebivaliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prebivaliste }
     *     
     */
    public void setPrebivaliste(Prebivaliste value) {
        this.prebivaliste = value;
    }

    /**
     * Gets the value of the kontaktInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link KontaktInformacije }
     *     
     */
    public KontaktInformacije getKontaktInformacije() {
        return kontaktInformacije;
    }

    /**
     * Sets the value of the kontaktInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link KontaktInformacije }
     *     
     */
    public void setKontaktInformacije(KontaktInformacije value) {
        this.kontaktInformacije = value;
    }

    /**
     * Gets the value of the radniStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RadniStatus }
     *     
     */
    public RadniStatus getRadniStatus() {
        return radniStatus;
    }

    /**
     * Sets the value of the radniStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RadniStatus }
     *     
     */
    public void setRadniStatus(RadniStatus value) {
        this.radniStatus = value;
    }

    /**
     * Gets the value of the zanimanjeZaposlenog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZanimanjeZaposlenog() {
        return zanimanjeZaposlenog;
    }

    /**
     * Sets the value of the zanimanjeZaposlenog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZanimanjeZaposlenog(String value) {
        this.zanimanjeZaposlenog = value;
    }

    /**
     * Gets the value of the ustanovaSocijalneZastite property.
     * 
     * @return
     *     possible object is
     *     {@link UstanovaSocijalneZastite }
     *     
     */
    public UstanovaSocijalneZastite getUstanovaSocijalneZastite() {
        return ustanovaSocijalneZastite;
    }

    /**
     * Sets the value of the ustanovaSocijalneZastite property.
     * 
     * @param value
     *     allowed object is
     *     {@link UstanovaSocijalneZastite }
     *     
     */
    public void setUstanovaSocijalneZastite(UstanovaSocijalneZastite value) {
        this.ustanovaSocijalneZastite = value;
    }

    /**
     * Gets the value of the izjavaSaglasnosti property.
     * 
     * @return
     *     possible object is
     *     {@link IzjavaSaglasnosti }
     *     
     */
    public IzjavaSaglasnosti getIzjavaSaglasnosti() {
        return izjavaSaglasnosti;
    }

    /**
     * Sets the value of the izjavaSaglasnosti property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzjavaSaglasnosti }
     *     
     */
    public void setIzjavaSaglasnosti(IzjavaSaglasnosti value) {
        this.izjavaSaglasnosti = value;
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