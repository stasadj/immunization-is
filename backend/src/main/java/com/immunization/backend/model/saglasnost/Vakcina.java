//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 11:03:10 AM CET 
//


package com.immunization.backend.model.saglasnost;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import rs.ac.uns.ftn.util.Ekstremitet;
import rs.ac.uns.ftn.util.NacinDavanja;


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
 *         &lt;element name="broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datum_davanja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="nacin_davanja" type="{http://ftn.uns.ac.rs/util}nacin_davanja"/&gt;
 *         &lt;element name="ekstremitet" type="{http://ftn.uns.ac.rs/util}ekstremitet"/&gt;
 *         &lt;element name="serija" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="proizvodjac" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nezeljena_reakcija" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "brojDoze",
    "naziv",
    "datumDavanja",
    "nacinDavanja",
    "ekstremitet",
    "serija",
    "proizvodjac",
    "nezeljenaReakcija"
})
@XmlRootElement(name = "vakcina")
public class Vakcina {

    @XmlElement(name = "broj_doze", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojDoze;
    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(name = "datum_davanja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDavanja;
    @XmlElement(name = "nacin_davanja", required = true)
    @XmlSchemaType(name = "string")
    protected NacinDavanja nacinDavanja;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Ekstremitet ekstremitet;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger serija;
    @XmlElement(required = true)
    protected String proizvodjac;
    @XmlElement(name = "nezeljena_reakcija", required = true)
    protected String nezeljenaReakcija;

    /**
     * Gets the value of the brojDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDoze() {
        return brojDoze;
    }

    /**
     * Sets the value of the brojDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDoze(BigInteger value) {
        this.brojDoze = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the datumDavanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDavanja() {
        return datumDavanja;
    }

    /**
     * Sets the value of the datumDavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDavanja(XMLGregorianCalendar value) {
        this.datumDavanja = value;
    }

    /**
     * Gets the value of the nacinDavanja property.
     * 
     * @return
     *     possible object is
     *     {@link NacinDavanja }
     *     
     */
    public NacinDavanja getNacinDavanja() {
        return nacinDavanja;
    }

    /**
     * Sets the value of the nacinDavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link NacinDavanja }
     *     
     */
    public void setNacinDavanja(NacinDavanja value) {
        this.nacinDavanja = value;
    }

    /**
     * Gets the value of the ekstremitet property.
     * 
     * @return
     *     possible object is
     *     {@link Ekstremitet }
     *     
     */
    public Ekstremitet getEkstremitet() {
        return ekstremitet;
    }

    /**
     * Sets the value of the ekstremitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ekstremitet }
     *     
     */
    public void setEkstremitet(Ekstremitet value) {
        this.ekstremitet = value;
    }

    /**
     * Gets the value of the serija property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSerija() {
        return serija;
    }

    /**
     * Sets the value of the serija property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSerija(BigInteger value) {
        this.serija = value;
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
     * Gets the value of the nezeljenaReakcija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNezeljenaReakcija() {
        return nezeljenaReakcija;
    }

    /**
     * Sets the value of the nezeljenaReakcija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNezeljenaReakcija(String value) {
        this.nezeljenaReakcija = value;
    }

}
