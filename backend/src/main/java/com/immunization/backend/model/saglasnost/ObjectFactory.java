//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 04:37:41 PM CET 
//


package com.immunization.backend.model.saglasnost;

import javax.xml.bind.JAXBElement;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.immunization.backend.model.util.Pol;
import com.immunization.backend.model.util.RadniStatus;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.saglasnost package. 
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

    private final static QName _Pol_QNAME = new QName("http://www.ftn.uns.ac.rs/saglasnost/", "pol");
    private final static QName _RadniStatus_QNAME = new QName("http://www.ftn.uns.ac.rs/saglasnost/", "radni_status");
    private final static QName _ZanimanjeZaposlenog_QNAME = new QName("http://www.ftn.uns.ac.rs/saglasnost/", "zanimanje_zaposlenog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.saglasnost
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Drzavljanstvo }
     * 
     */
    public Drzavljanstvo createDrzavljanstvo() {
        return new Drzavljanstvo();
    }

    /**
     * Create an instance of {@link ZdravstvenaUstanova }
     * 
     */
    public ZdravstvenaUstanova createZdravstvenaUstanova() {
        return new ZdravstvenaUstanova();
    }

    /**
     * Create an instance of {@link ObrazacSaglasnostiZaImunizaciju }
     * 
     */
    public ObrazacSaglasnostiZaImunizaciju createObrazacSaglasnostiZaImunizaciju() {
        return new ObrazacSaglasnostiZaImunizaciju();
    }

    /**
     * Create an instance of {@link InformacijeOPacijentu }
     * 
     */
    public InformacijeOPacijentu createInformacijeOPacijentu() {
        return new InformacijeOPacijentu();
    }

    /**
     * Create an instance of {@link Drzavljanstvo.SrpskoDrzavljanstvo }
     * 
     */
    public Drzavljanstvo.SrpskoDrzavljanstvo createDrzavljanstvoSrpskoDrzavljanstvo() {
        return new Drzavljanstvo.SrpskoDrzavljanstvo();
    }

    /**
     * Create an instance of {@link Drzavljanstvo.StranoDrzavljanstvo }
     * 
     */
    public Drzavljanstvo.StranoDrzavljanstvo createDrzavljanstvoStranoDrzavljanstvo() {
        return new Drzavljanstvo.StranoDrzavljanstvo();
    }

    /**
     * Create an instance of {@link PunoIme }
     * 
     */
    public PunoIme createPunoIme() {
        return new PunoIme();
    }

    /**
     * Create an instance of {@link DatumIMestoRodjenja }
     * 
     */
    public DatumIMestoRodjenja createDatumIMestoRodjenja() {
        return new DatumIMestoRodjenja();
    }

    /**
     * Create an instance of {@link Prebivaliste }
     * 
     */
    public Prebivaliste createPrebivaliste() {
        return new Prebivaliste();
    }

    /**
     * Create an instance of {@link KontaktInformacije }
     * 
     */
    public KontaktInformacije createKontaktInformacije() {
        return new KontaktInformacije();
    }

    /**
     * Create an instance of {@link UstanovaSocijalneZastite }
     * 
     */
    public UstanovaSocijalneZastite createUstanovaSocijalneZastite() {
        return new UstanovaSocijalneZastite();
    }

    /**
     * Create an instance of {@link IzjavaSaglasnosti }
     * 
     */
    public IzjavaSaglasnosti createIzjavaSaglasnosti() {
        return new IzjavaSaglasnosti();
    }

    /**
     * Create an instance of {@link EvidencijaOVakcinaciji }
     * 
     */
    public EvidencijaOVakcinaciji createEvidencijaOVakcinaciji() {
        return new EvidencijaOVakcinaciji();
    }

    /**
     * Create an instance of {@link ZdravstvenaUstanova.Naziv }
     * 
     */
    public ZdravstvenaUstanova.Naziv createZdravstvenaUstanovaNaziv() {
        return new ZdravstvenaUstanova.Naziv();
    }

    /**
     * Create an instance of {@link ZdravstvenaUstanova.InformacijeOLekaru }
     * 
     */
    public ZdravstvenaUstanova.InformacijeOLekaru createZdravstvenaUstanovaInformacijeOLekaru() {
        return new ZdravstvenaUstanova.InformacijeOLekaru();
    }

    /**
     * Create an instance of {@link IzvrsenaImunizacija }
     * 
     */
    public IzvrsenaImunizacija createIzvrsenaImunizacija() {
        return new IzvrsenaImunizacija();
    }

    /**
     * Create an instance of {@link Vakcina }
     * 
     */
    public Vakcina createVakcina() {
        return new Vakcina();
    }

    /**
     * Create an instance of {@link Kontraindikacija }
     * 
     */
    public Kontraindikacija createKontraindikacija() {
        return new Kontraindikacija();
    }

    /**
     * Create an instance of {@link PrivremeneKontraindikacije }
     * 
     */
    public PrivremeneKontraindikacije createPrivremeneKontraindikacije() {
        return new PrivremeneKontraindikacije();
    }

    /**
     * Create an instance of {@link TrajneKontraindikacije }
     * 
     */
    public TrajneKontraindikacije createTrajneKontraindikacije() {
        return new TrajneKontraindikacije();
    }

    /**
     * Create an instance of {@link com.immunization.backend.model.saglasnost.InformacijeOLekaru }
     * 
     */
    public com.immunization.backend.model.saglasnost.InformacijeOLekaru createInformacijeOLekaru() {
        return new com.immunization.backend.model.saglasnost.InformacijeOLekaru();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pol }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Pol }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/saglasnost/", name = "pol")
    public JAXBElement<Pol> createPol(Pol value) {
        return new JAXBElement<>(_Pol_QNAME, Pol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RadniStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RadniStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/saglasnost/", name = "radni_status")
    public JAXBElement<RadniStatus> createRadniStatus(RadniStatus value) {
        return new JAXBElement<>(_RadniStatus_QNAME, RadniStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/saglasnost/", name = "zanimanje_zaposlenog")
    public JAXBElement<String> createZanimanjeZaposlenog(String value) {
        return new JAXBElement<>(_ZanimanjeZaposlenog_QNAME, String.class, null, value);
    }

}
