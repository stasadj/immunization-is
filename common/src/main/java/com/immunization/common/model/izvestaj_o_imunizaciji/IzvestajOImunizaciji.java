//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.izvestaj_o_imunizaciji;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="meta_podaci"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="period_od"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_od" /&gt;
 *                           &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="period_do"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_do" /&gt;
 *                           &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="datum_izdavanja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:izdato" /&gt;
 *                           &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="broj_dokumenata_o_interesovanju" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="broj_zahteva_za_digitalni_sertifikat" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="broj_izdatih_digitalnih_sertifikata" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="raspodela_datih_vakcina_po_rednom_broju_doze"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="doza" maxOccurs="unbounded" minOccurs="3"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                             &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="ukupno_dato" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="raspodela_datih_vakcina_po_proizvodjacima"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="proizvodjac" maxOccurs="unbounded" minOccurs="4"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "metaPodaci",
    "brojDokumenataOInteresovanju",
    "brojZahtevaZaDigitalniSertifikat",
    "brojIzdatihDigitalnihSertifikata",
    "raspodelaDatihVakcinaPoRednomBrojuDoze",
    "raspodelaDatihVakcinaPoProizvodjacima"
})
@XmlRootElement(name = "izvestaj_o_imunizaciji")
public class IzvestajOImunizaciji {

    @XmlElement(name = "meta_podaci", required = true)
    protected IzvestajOImunizaciji.MetaPodaci metaPodaci;
    @XmlElement(name = "broj_dokumenata_o_interesovanju", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected long brojDokumenataOInteresovanju;
    @XmlElement(name = "broj_zahteva_za_digitalni_sertifikat", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected long brojZahtevaZaDigitalniSertifikat;
    @XmlElement(name = "broj_izdatih_digitalnih_sertifikata", defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected long brojIzdatihDigitalnihSertifikata;
    @XmlElement(name = "raspodela_datih_vakcina_po_rednom_broju_doze", required = true)
    protected IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze raspodelaDatihVakcinaPoRednomBrojuDoze;
    @XmlElement(name = "raspodela_datih_vakcina_po_proizvodjacima", required = true)
    protected IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima raspodelaDatihVakcinaPoProizvodjacima;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;

    /**
     * Gets the value of the metaPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.MetaPodaci }
     *     
     */
    public IzvestajOImunizaciji.MetaPodaci getMetaPodaci() {
        return metaPodaci;
    }

    /**
     * Sets the value of the metaPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.MetaPodaci }
     *     
     */
    public void setMetaPodaci(IzvestajOImunizaciji.MetaPodaci value) {
        this.metaPodaci = value;
    }

    /**
     * Gets the value of the brojDokumenataOInteresovanju property.
     * 
     */
    public long getBrojDokumenataOInteresovanju() {
        return brojDokumenataOInteresovanju;
    }

    /**
     * Sets the value of the brojDokumenataOInteresovanju property.
     * 
     */
    public void setBrojDokumenataOInteresovanju(long value) {
        this.brojDokumenataOInteresovanju = value;
    }

    /**
     * Gets the value of the brojZahtevaZaDigitalniSertifikat property.
     * 
     */
    public long getBrojZahtevaZaDigitalniSertifikat() {
        return brojZahtevaZaDigitalniSertifikat;
    }

    /**
     * Sets the value of the brojZahtevaZaDigitalniSertifikat property.
     * 
     */
    public void setBrojZahtevaZaDigitalniSertifikat(long value) {
        this.brojZahtevaZaDigitalniSertifikat = value;
    }

    /**
     * Gets the value of the brojIzdatihDigitalnihSertifikata property.
     * 
     */
    public long getBrojIzdatihDigitalnihSertifikata() {
        return brojIzdatihDigitalnihSertifikata;
    }

    /**
     * Sets the value of the brojIzdatihDigitalnihSertifikata property.
     * 
     */
    public void setBrojIzdatihDigitalnihSertifikata(long value) {
        this.brojIzdatihDigitalnihSertifikata = value;
    }

    /**
     * Gets the value of the raspodelaDatihVakcinaPoRednomBrojuDoze property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze }
     *     
     */
    public IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze getRaspodelaDatihVakcinaPoRednomBrojuDoze() {
        return raspodelaDatihVakcinaPoRednomBrojuDoze;
    }

    /**
     * Sets the value of the raspodelaDatihVakcinaPoRednomBrojuDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze }
     *     
     */
    public void setRaspodelaDatihVakcinaPoRednomBrojuDoze(IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze value) {
        this.raspodelaDatihVakcinaPoRednomBrojuDoze = value;
    }

    /**
     * Gets the value of the raspodelaDatihVakcinaPoProizvodjacima property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima }
     *     
     */
    public IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima getRaspodelaDatihVakcinaPoProizvodjacima() {
        return raspodelaDatihVakcinaPoProizvodjacima;
    }

    /**
     * Sets the value of the raspodelaDatihVakcinaPoProizvodjacima property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima }
     *     
     */
    public void setRaspodelaDatihVakcinaPoProizvodjacima(IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima value) {
        this.raspodelaDatihVakcinaPoProizvodjacima = value;
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
     *         &lt;element name="period_od"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_od" /&gt;
     *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="period_do"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_do" /&gt;
     *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="datum_izdavanja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:izdato" /&gt;
     *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "periodOd",
        "periodDo",
        "datumIzdavanja"
    })
    public static class MetaPodaci {

        @XmlElement(name = "period_od", required = true)
        protected IzvestajOImunizaciji.MetaPodaci.PeriodOd periodOd;
        @XmlElement(name = "period_do", required = true)
        protected IzvestajOImunizaciji.MetaPodaci.PeriodDo periodDo;
        @XmlElement(name = "datum_izdavanja", required = true)
        protected IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja datumIzdavanja;

        /**
         * Gets the value of the periodOd property.
         * 
         * @return
         *     possible object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.PeriodOd }
         *     
         */
        public IzvestajOImunizaciji.MetaPodaci.PeriodOd getPeriodOd() {
            return periodOd;
        }

        /**
         * Sets the value of the periodOd property.
         * 
         * @param value
         *     allowed object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.PeriodOd }
         *     
         */
        public void setPeriodOd(IzvestajOImunizaciji.MetaPodaci.PeriodOd value) {
            this.periodOd = value;
        }

        /**
         * Gets the value of the periodDo property.
         * 
         * @return
         *     possible object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.PeriodDo }
         *     
         */
        public IzvestajOImunizaciji.MetaPodaci.PeriodDo getPeriodDo() {
            return periodDo;
        }

        /**
         * Sets the value of the periodDo property.
         * 
         * @param value
         *     allowed object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.PeriodDo }
         *     
         */
        public void setPeriodDo(IzvestajOImunizaciji.MetaPodaci.PeriodDo value) {
            this.periodDo = value;
        }

        /**
         * Gets the value of the datumIzdavanja property.
         * 
         * @return
         *     possible object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja }
         *     
         */
        public IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja getDatumIzdavanja() {
            return datumIzdavanja;
        }

        /**
         * Sets the value of the datumIzdavanja property.
         * 
         * @param value
         *     allowed object is
         *     {@link IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja }
         *     
         */
        public void setDatumIzdavanja(IzvestajOImunizaciji.MetaPodaci.DatumIzdavanja value) {
            this.datumIzdavanja = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:izdato" /&gt;
         *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class DatumIzdavanja {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:izdato";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_do" /&gt;
         *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class PeriodDo {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:obuhvata_period_do";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:obuhvata_period_od" /&gt;
         *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class PeriodOd {

            @XmlValue
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

            /**
             * Gets the value of the property property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProperty() {
                if (property == null) {
                    return "pred:obuhvata_period_od";
                } else {
                    return property;
                }
            }

            /**
             * Sets the value of the property property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProperty(String value) {
                this.property = value;
            }

            /**
             * Gets the value of the datatype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDatatype() {
                if (datatype == null) {
                    return "xs:string";
                } else {
                    return datatype;
                }
            }

            /**
             * Sets the value of the datatype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDatatype(String value) {
                this.datatype = value;
            }

        }

    }


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
     *         &lt;element name="proizvodjac" maxOccurs="unbounded" minOccurs="4"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "proizvodjac"
    })
    public static class RaspodelaDatihVakcinaPoProizvodjacima {

        @XmlElement(required = true)
        protected List<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac> proizvodjac;

        /**
         * Gets the value of the proizvodjac property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the proizvodjac property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProizvodjac().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac }
         * 
         * 
         */
        public List<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac> getProizvodjac() {
            if (proizvodjac == null) {
                proizvodjac = new ArrayList<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoProizvodjacima.Proizvodjac>();
            }
            return this.proizvodjac;
        }


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
         *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
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
            "naziv",
            "brojDatihDoza"
        })
        public static class Proizvodjac {

            @XmlElement(required = true)
            protected String naziv;
            @XmlElement(name = "broj_datih_doza")
            @XmlSchemaType(name = "unsignedInt")
            protected long brojDatihDoza;

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
             * Gets the value of the brojDatihDoza property.
             * 
             */
            public long getBrojDatihDoza() {
                return brojDatihDoza;
            }

            /**
             * Sets the value of the brojDatihDoza property.
             * 
             */
            public void setBrojDatihDoza(long value) {
                this.brojDatihDoza = value;
            }

        }

    }


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
     *         &lt;element name="doza" maxOccurs="unbounded" minOccurs="3"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                   &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ukupno_dato" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "doza"
    })
    public static class RaspodelaDatihVakcinaPoRednomBrojuDoze {

        @XmlElement(required = true)
        protected List<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza> doza;
        @XmlAttribute(name = "ukupno_dato")
        @XmlSchemaType(name = "unsignedInt")
        protected Long ukupnoDato;

        /**
         * Gets the value of the doza property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doza property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoza().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza }
         * 
         * 
         */
        public List<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza> getDoza() {
            if (doza == null) {
                doza = new ArrayList<IzvestajOImunizaciji.RaspodelaDatihVakcinaPoRednomBrojuDoze.Doza>();
            }
            return this.doza;
        }

        /**
         * Gets the value of the ukupnoDato property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getUkupnoDato() {
            return ukupnoDato;
        }

        /**
         * Sets the value of the ukupnoDato property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setUkupnoDato(Long value) {
            this.ukupnoDato = value;
        }


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
         *         &lt;element name="redni_broj" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *         &lt;element name="broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
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
            "redniBroj",
            "brojDatihDoza"
        })
        public static class Doza {

            @XmlElement(name = "redni_broj", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger redniBroj;
            @XmlElement(name = "broj_datih_doza")
            @XmlSchemaType(name = "unsignedInt")
            protected long brojDatihDoza;

            /**
             * Gets the value of the redniBroj property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRedniBroj() {
                return redniBroj;
            }

            /**
             * Sets the value of the redniBroj property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRedniBroj(BigInteger value) {
                this.redniBroj = value;
            }

            /**
             * Gets the value of the brojDatihDoza property.
             * 
             */
            public long getBrojDatihDoza() {
                return brojDatihDoza;
            }

            /**
             * Sets the value of the brojDatihDoza property.
             * 
             */
            public void setBrojDatihDoza(long value) {
                this.brojDatihDoza = value;
            }

        }

    }

}
