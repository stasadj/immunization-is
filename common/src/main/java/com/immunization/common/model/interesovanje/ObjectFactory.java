//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.17 at 08:23:02 PM CET 
//


package com.immunization.common.model.interesovanje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.immunization.common.model.util.ImePrezime;
import com.immunization.common.model.util.Jmbg;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.immunization.common.model.interesovanje package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Jmbg_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "jmbg");
    private final static QName _PunoIme_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "puno_ime");
    private final static QName _EmailAdresa_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "email_adresa");
    private final static QName _FiksniTelefon_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "fiksni_telefon");
    private final static QName _MobilniTelefon_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "mobilni_telefon");
    private final static QName _ZeljenaOpstinaVakcinacije_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "zeljena_opstina_vakcinacije");
    private final static QName _Opcija_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "opcija");
    private final static QName _BiloKojaVakcina_QNAME = new QName("http://www.ftn.uns.ac.rs/interesovanje/", "bilo_koja_vakcina");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.immunization.common.model.interesovanje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IskazivanjeInteresovanjaZaVakcinaciju }
     * 
     */
    public IskazivanjeInteresovanjaZaVakcinaciju createIskazivanjeInteresovanjaZaVakcinaciju() {
        return new IskazivanjeInteresovanjaZaVakcinaciju();
    }

    /**
     * Create an instance of {@link Pacijent }
     * 
     */
    public Pacijent createPacijent() {
        return new Pacijent();
    }

    /**
     * Create an instance of {@link Drzavljanstvo }
     * 
     */
    public Drzavljanstvo createDrzavljanstvo() {
        return new Drzavljanstvo();
    }

    /**
     * Create an instance of {@link KontaktInformacije }
     * 
     */
    public KontaktInformacije createKontaktInformacije() {
        return new KontaktInformacije();
    }

    /**
     * Create an instance of {@link DobrovoljniDavalacKrvi }
     * 
     */
    public DobrovoljniDavalacKrvi createDobrovoljniDavalacKrvi() {
        return new DobrovoljniDavalacKrvi();
    }

    /**
     * Create an instance of {@link OdabirVakcina }
     * 
     */
    public OdabirVakcina createOdabirVakcina() {
        return new OdabirVakcina();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Jmbg }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Jmbg }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "jmbg")
    public JAXBElement<Jmbg> createJmbg(Jmbg value) {
        return new JAXBElement<Jmbg>(_Jmbg_QNAME, Jmbg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImePrezime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImePrezime }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "puno_ime")
    public JAXBElement<ImePrezime> createPunoIme(ImePrezime value) {
        return new JAXBElement<ImePrezime>(_PunoIme_QNAME, ImePrezime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "email_adresa")
    public JAXBElement<String> createEmailAdresa(String value) {
        return new JAXBElement<String>(_EmailAdresa_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "fiksni_telefon")
    public JAXBElement<String> createFiksniTelefon(String value) {
        return new JAXBElement<String>(_FiksniTelefon_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "mobilni_telefon")
    public JAXBElement<String> createMobilniTelefon(String value) {
        return new JAXBElement<String>(_MobilniTelefon_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "zeljena_opstina_vakcinacije")
    public JAXBElement<String> createZeljenaOpstinaVakcinacije(String value) {
        return new JAXBElement<String>(_ZeljenaOpstinaVakcinacije_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "opcija")
    public JAXBElement<String> createOpcija(String value) {
        return new JAXBElement<String>(_Opcija_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/interesovanje/", name = "bilo_koja_vakcina")
    public JAXBElement<String> createBiloKojaVakcina(String value) {
        return new JAXBElement<String>(_BiloKojaVakcina_QNAME, String.class, null, value);
    }

}
