import { Interesovanje } from "../model/Interesovanje";


export function createInteresovanjeXML(interesovanje: Interesovanje): string {

    return `<?xml version="1.0" encoding="UTF-8"?>
    <iskazivanje_interesovanja_za_vakcinaciju xmlns="http://www.ftn.uns.ac.rs/interesovanje/"
        xmlns:xs="http://www.w3.org/2001/XMLSchema#"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:pred="http://www.ftn.uns.ac.rs/rdf/predicate/"
        xsi:schemaLocation="http://www.ftn.uns.ac.rs/interesovanje/ interesovanje.xsd" 
        datum=""
        about="">
        <pacijent about="">
            <drzavljanstvo property="pred:ima_drzavljanstvo" datatype="xs:string">${interesovanje.drzavljanstvo}</drzavljanstvo>
            <jmbg property="pred:ima_jmbg" datatype="xs:string">${interesovanje.jmbg}</jmbg>
            <puno_ime property="pred:se_zove" datatype="xs:string">${interesovanje.punoIme}</puno_ime>
            <kontakt_informacije>
                <email_adresa>${interesovanje.email}</email_adresa>
                <fiksni_telefon>${interesovanje.fiksni}</fiksni_telefon>
                <mobilni_telefon>${interesovanje.mobilni}</mobilni_telefon>
            </kontakt_informacije>
            <dobrovoljni_davalac_krvi property="pred:je_dobrovoljni_davalac_krvi" datatype="xs:string">${interesovanje.davalacKrvi}</dobrovoljni_davalac_krvi>
        </pacijent>
        <zeljena_opstina_vakcinacije>${interesovanje.opstinaVakcinacije}</zeljena_opstina_vakcinacije>
        <odabir_vakcina>
            ${getVaccines(interesovanje.opcije)}
        </odabir_vakcina>
    </iskazivanje_interesovanja_za_vakcinaciju>

    `

}


function getVaccines(opcije: string[]): string {
    if (opcije.length == 1 && opcije[0] === "BILO KOJA") {
        return `
            <bilo_koja_vakcina/>
        `
    }

    let xmlOpcije: string = "";
    opcije.forEach(opcija => xmlOpcije += `<opcija>${opcija}</opcija>`)
    return xmlOpcije;


}