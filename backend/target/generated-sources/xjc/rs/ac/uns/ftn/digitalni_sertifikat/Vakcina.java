//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package rs.ac.uns.ftn.digitalni_sertifikat;

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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}tip"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}proizvodjac_serija"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}datum"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/digitalni-sertifikat/}zdravstvena_ustanova"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="doza" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tip",
    "proizvodjacSerija",
    "datum",
    "zdravstvenaUstanova"
})
@XmlRootElement(name = "vakcina")
public class Vakcina {

    @XmlElement(required = true)
    protected String tip;
    @XmlElement(name = "proizvodjac_serija", required = true)
    protected String proizvodjacSerija;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "zdravstvena_ustanova", required = true)
    protected String zdravstvenaUstanova;
    @XmlAttribute(name = "doza", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger doza;

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTip(String value) {
        this.tip = value;
    }

    /**
     * Gets the value of the proizvodjacSerija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvodjacSerija() {
        return proizvodjacSerija;
    }

    /**
     * Sets the value of the proizvodjacSerija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvodjacSerija(String value) {
        this.proizvodjacSerija = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the zdravstvenaUstanova property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdravstvenaUstanova() {
        return zdravstvenaUstanova;
    }

    /**
     * Sets the value of the zdravstvenaUstanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdravstvenaUstanova(String value) {
        this.zdravstvenaUstanova = value;
    }

    /**
     * Gets the value of the doza property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDoza() {
        return doza;
    }

    /**
     * Sets the value of the doza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDoza(BigInteger value) {
        this.doza = value;
    }

}
