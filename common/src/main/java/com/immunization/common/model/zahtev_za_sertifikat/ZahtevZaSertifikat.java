//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.zahtev_za_sertifikat;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import org.w3c.dom.Element;
import com.immunization.common.model.util.BrojPasosa;
import com.immunization.common.model.util.DatumRodjenja;
import com.immunization.common.model.util.ImePrezime;
import com.immunization.common.model.util.Jmbg;
import com.immunization.common.model.util.Pol;
import com.immunization.common.model.util.StatusZahtevaValue;


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
 *                   &lt;element name="mesto_izdavanja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_mesto_izdavanja" /&gt;
 *                           &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="datum_izdavanja"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;nillableDate"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_datum_izdavanja" /&gt;
 *                           &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="status_zahteva"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;status_zahteva_value"&gt;
 *                           &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_status" /&gt;
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
 *         &lt;element name="podnosilac_zahteva"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ime_prezime" type="{http://ftn.uns.ac.rs/util}ime_prezime"/&gt;
 *                   &lt;element name="datum_rodjenja" type="{http://ftn.uns.ac.rs/util}datum_rodjenja"/&gt;
 *                   &lt;element name="pol" type="{http://ftn.uns.ac.rs/util}pol"/&gt;
 *                   &lt;element name="jmbg" type="{http://ftn.uns.ac.rs/util}jmbg"/&gt;
 *                   &lt;element name="broj_pasosa" type="{http://ftn.uns.ac.rs/util}broj_pasosa"/&gt;
 *                   &lt;element name="razlog_za_podnosenje_zahteva"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;any processContents='lax' namespace='https://www.w3.org/1999/xhtml' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
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
    "podnosilacZahteva"
})
@XmlRootElement(name = "zahtev_za_sertifikat")
public class ZahtevZaSertifikat {

    @XmlElement(name = "meta_podaci", required = true)
    protected ZahtevZaSertifikat.MetaPodaci metaPodaci;
    @XmlElement(name = "podnosilac_zahteva", required = true)
    protected ZahtevZaSertifikat.PodnosilacZahteva podnosilacZahteva;
    @XmlAttribute(name = "about", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String about;

    /**
     * Gets the value of the metaPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaSertifikat.MetaPodaci }
     *     
     */
    public ZahtevZaSertifikat.MetaPodaci getMetaPodaci() {
        return metaPodaci;
    }

    /**
     * Sets the value of the metaPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaSertifikat.MetaPodaci }
     *     
     */
    public void setMetaPodaci(ZahtevZaSertifikat.MetaPodaci value) {
        this.metaPodaci = value;
    }

    /**
     * Gets the value of the podnosilacZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaSertifikat.PodnosilacZahteva }
     *     
     */
    public ZahtevZaSertifikat.PodnosilacZahteva getPodnosilacZahteva() {
        return podnosilacZahteva;
    }

    /**
     * Sets the value of the podnosilacZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaSertifikat.PodnosilacZahteva }
     *     
     */
    public void setPodnosilacZahteva(ZahtevZaSertifikat.PodnosilacZahteva value) {
        this.podnosilacZahteva = value;
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
     *         &lt;element name="mesto_izdavanja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_mesto_izdavanja" /&gt;
     *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="datum_izdavanja"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;nillableDate"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_datum_izdavanja" /&gt;
     *                 &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="xs:string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="status_zahteva"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;status_zahteva_value"&gt;
     *                 &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_status" /&gt;
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
        "mestoIzdavanja",
        "datumIzdavanja",
        "statusZahteva"
    })
    public static class MetaPodaci {

        @XmlElement(name = "mesto_izdavanja", required = true)
        protected ZahtevZaSertifikat.MetaPodaci.MestoIzdavanja mestoIzdavanja;
        @XmlElement(name = "datum_izdavanja", required = true)
        protected ZahtevZaSertifikat.MetaPodaci.DatumIzdavanja datumIzdavanja;
        @XmlElement(name = "status_zahteva", required = true)
        protected ZahtevZaSertifikat.MetaPodaci.StatusZahteva statusZahteva;

        /**
         * Gets the value of the mestoIzdavanja property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.MestoIzdavanja }
         *     
         */
        public ZahtevZaSertifikat.MetaPodaci.MestoIzdavanja getMestoIzdavanja() {
            return mestoIzdavanja;
        }

        /**
         * Sets the value of the mestoIzdavanja property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.MestoIzdavanja }
         *     
         */
        public void setMestoIzdavanja(ZahtevZaSertifikat.MetaPodaci.MestoIzdavanja value) {
            this.mestoIzdavanja = value;
        }

        /**
         * Gets the value of the datumIzdavanja property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.DatumIzdavanja }
         *     
         */
        public ZahtevZaSertifikat.MetaPodaci.DatumIzdavanja getDatumIzdavanja() {
            return datumIzdavanja;
        }

        /**
         * Sets the value of the datumIzdavanja property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.DatumIzdavanja }
         *     
         */
        public void setDatumIzdavanja(ZahtevZaSertifikat.MetaPodaci.DatumIzdavanja value) {
            this.datumIzdavanja = value;
        }

        /**
         * Gets the value of the statusZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.StatusZahteva }
         *     
         */
        public ZahtevZaSertifikat.MetaPodaci.StatusZahteva getStatusZahteva() {
            return statusZahteva;
        }

        /**
         * Sets the value of the statusZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaSertifikat.MetaPodaci.StatusZahteva }
         *     
         */
        public void setStatusZahteva(ZahtevZaSertifikat.MetaPodaci.StatusZahteva value) {
            this.statusZahteva = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;nillableDate"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_datum_izdavanja" /&gt;
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
            protected String value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
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
                    return "pred:ima_datum_izdavanja";
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
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_mesto_izdavanja" /&gt;
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
        public static class MestoIzdavanja {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
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
                    return "pred:ima_mesto_izdavanja";
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
         *     &lt;extension base="&lt;http://ftn.uns.ac.rs/util&gt;status_zahteva_value"&gt;
         *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:ima_status" /&gt;
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
        public static class StatusZahteva {

            @XmlValue
            protected StatusZahtevaValue value;
            @XmlAttribute(name = "property", required = true)
            protected String property;
            @XmlAttribute(name = "datatype", required = true)
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link StatusZahtevaValue }
             *     
             */
            public StatusZahtevaValue getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link StatusZahtevaValue }
             *     
             */
            public void setValue(StatusZahtevaValue value) {
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
                    return "pred:ima_status";
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
     *         &lt;element name="ime_prezime" type="{http://ftn.uns.ac.rs/util}ime_prezime"/&gt;
     *         &lt;element name="datum_rodjenja" type="{http://ftn.uns.ac.rs/util}datum_rodjenja"/&gt;
     *         &lt;element name="pol" type="{http://ftn.uns.ac.rs/util}pol"/&gt;
     *         &lt;element name="jmbg" type="{http://ftn.uns.ac.rs/util}jmbg"/&gt;
     *         &lt;element name="broj_pasosa" type="{http://ftn.uns.ac.rs/util}broj_pasosa"/&gt;
     *         &lt;element name="razlog_za_podnosenje_zahteva"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;any processContents='lax' namespace='https://www.w3.org/1999/xhtml' maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "imePrezime",
        "datumRodjenja",
        "pol",
        "jmbg",
        "brojPasosa",
        "razlogZaPodnosenjeZahteva"
    })
    public static class PodnosilacZahteva {

        @XmlElement(name = "ime_prezime", required = true)
        protected ImePrezime imePrezime;
        @XmlElement(name = "datum_rodjenja", required = true)
        protected DatumRodjenja datumRodjenja;
        @XmlElement(required = true)
        protected Pol pol;
        @XmlElement(required = true)
        protected Jmbg jmbg;
        @XmlElement(name = "broj_pasosa", required = true)
        protected BrojPasosa brojPasosa;
        @XmlElement(name = "razlog_za_podnosenje_zahteva", required = true)
        protected ZahtevZaSertifikat.PodnosilacZahteva.RazlogZaPodnosenjeZahteva razlogZaPodnosenjeZahteva;
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
         * Gets the value of the jmbg property.
         * 
         * @return
         *     possible object is
         *     {@link Jmbg }
         *     
         */
        public Jmbg getJmbg() {
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
        public void setJmbg(Jmbg value) {
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
         * Gets the value of the razlogZaPodnosenjeZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaSertifikat.PodnosilacZahteva.RazlogZaPodnosenjeZahteva }
         *     
         */
        public ZahtevZaSertifikat.PodnosilacZahteva.RazlogZaPodnosenjeZahteva getRazlogZaPodnosenjeZahteva() {
            return razlogZaPodnosenjeZahteva;
        }

        /**
         * Sets the value of the razlogZaPodnosenjeZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaSertifikat.PodnosilacZahteva.RazlogZaPodnosenjeZahteva }
         *     
         */
        public void setRazlogZaPodnosenjeZahteva(ZahtevZaSertifikat.PodnosilacZahteva.RazlogZaPodnosenjeZahteva value) {
            this.razlogZaPodnosenjeZahteva = value;
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
         *         &lt;any processContents='lax' namespace='https://www.w3.org/1999/xhtml' maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "content"
        })
        public static class RazlogZaPodnosenjeZahteva {

            @XmlMixed
            @XmlAnyElement(lax = true)
            protected List<Object> content;

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Element }
             * {@link Object }
             * {@link String }
             * 
             * 
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
            }

        }

    }

}
