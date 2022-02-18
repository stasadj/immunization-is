import * as moment from "moment";
import { Pol } from "../model/Pol";
import { RadniStatus } from "../model/RadniStatus";
import { Saglasnost } from "../model/Saglasnost";
import { ZanimanjeZaposlenog } from "../model/ZanimanjeZaposlenog";

export function createSaglasnostXML(saglasnost: Saglasnost): string {
    return `<?xml version="1.0" encoding="UTF-8"?>
    <obrazac_saglasnosti_za_imunizaciju xmlns="http://www.ftn.uns.ac.rs/saglasnost/"
        xmlns:xs="http://www.w3.org/2001/XMLSchema#"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:pred="http://www.ftn.uns.ac.rs/rdf/predicate/"
        xsi:schemaLocation="http://www.ftn.uns.ac.rs/saglasnost/ saglasnost.xsd"
        broj="0000000001" datum="${moment().format('yyyy-MM-DD').toString()}"
        about="http://www.ftn.uns.ac.rs/saglasnost/0000000001">
        <informacije_o_pacijentu about="http://www.ftn.uns.ac.rs/licni-podaci/about">
            <drzavljanstvo>
                ${saglasnost.jmbg ?
            '<srpsko_drzavljanstvo>\
                <jmbg property="pred:ima_jmbg" datatype="xs:string">' + saglasnost.jmbg + '</jmbg>\
            </srpsko_drzavljanstvo>'
            :
            '<strano_drzavljanstvo>\
                <naziv_stranog_drzavljanstva>' + saglasnost.nazivStranogDrzavljanstva + '</naziv_stranog_drzavljanstva>\
                <broj_pasosa_ili_ebs property="pred:ima_broj_pasosa" datatype="xs:string">' + saglasnost.brojPasosa + '</broj_pasosa_ili_ebs>\
            </strano_drzavljanstvo>'}
            </drzavljanstvo>
            <puno_ime>
                <ime_prezime property="pred:se_zove" datatype="xs:string">${saglasnost.punoIme}</ime_prezime>
                <ime_roditelja>${saglasnost.imeRoditelja}</ime_roditelja>
            </puno_ime>
            <pol property="pred:ima_pol" datatype="xs:string">${getPolEnum(saglasnost.pol)}</pol>
            <datum_i_mesto_rodjenja>
                <datum_rodjenja property="pred:je_rodjen" datatype="xs:string">${moment(saglasnost.datumRodjenja).format('yyyy-MM-DD').toString()}</datum_rodjenja>
                <mesto_rodjenja property="pred:je_rodjen_u" datatype="xs:string">${saglasnost.mestoRodjenja}</mesto_rodjenja>
            </datum_i_mesto_rodjenja>
            <prebivaliste about="http://www.ftn.uns.ac.rs/prebivaliste/about">
                <ulica property="pred:nalazi_se_u_ulici" datatype="xs:string">${saglasnost.ulica}</ulica>
                <broj property="pred:nalazi_se_na_broju" datatype="xs:string">${saglasnost.ulicaBroj}</broj>
                <mesto property="pred:nalazi_se_u_mestu" datatype="xs:string">${saglasnost.mesto}</mesto>
                <opstina property="pred:nalazi_se_u_opstini" datatype="xs:string">${saglasnost.opstina}</opstina>
            </prebivaliste>
            <kontakt_informacije>
                <fiksni_telefon>${saglasnost.fiksni}</fiksni_telefon>
                <mobilni_telefon>${saglasnost.mobilni}</mobilni_telefon>
                <email_adresa>${saglasnost.email}</email_adresa>
            </kontakt_informacije>
            <radni_status property="pred:ima_radni_status" datatype="xs:string">${getRadniStatusEnum(saglasnost.radniStatus)}</radni_status>
            <zanimanje_zaposlenog>${saglasnost.radniStatus === RadniStatus.zaposlen && saglasnost.zanimanjeZaposlenog ? getZanimanjeEnum(saglasnost.zanimanjeZaposlenog) : ''}</zanimanje_zaposlenog>
            <ustanova_socijalne_zastite>
                <pacijent_koristi_zastitu>${saglasnost.korisnikZdravstveneZastite ? 'true' : 'false'}</pacijent_koristi_zastitu>
                <naziv_sedista>${saglasnost.nazivSocZdravstveneUstanove}</naziv_sedista>
                <opstina_sedista>${saglasnost.nazivSedistaOpstineSocZdravstveneUstanove}</opstina_sedista>
            </ustanova_socijalne_zastite>
            <izjava_saglasnosti>
                <saglasan>${saglasnost.saglasan ? 'true' : 'false'}</saglasan>
                <naziv_imunoloskog_leka>${saglasnost.nazivLeka}</naziv_imunoloskog_leka>
            </izjava_saglasnosti>
        </informacije_o_pacijentu>
        <evidencija_o_vakcinaciji>
            <zdravstvena_ustanova>
                <naziv property="pred:vakcinisan_u" datatype="xs:string"></naziv>
                <vakcinacijski_punkt></vakcinacijski_punkt>
                <informacije_o_lekaru>
                    <ime></ime>
                    <prezime></prezime>
                    <faksimil></faksimil>
                    <broj_telefona>123123123</broj_telefona>
                </informacije_o_lekaru>
            </zdravstvena_ustanova>
            <izvrsena_imunizacija/>
            <kontraindikacija>
                <privremene_kontraindikacije>
                    <datum_utvrdjivanja></datum_utvrdjivanja>
                    <dijagnoza></dijagnoza>
                </privremene_kontraindikacije>
                <trajne_kontraindikacije>
                    <odluka_komisije></odluka_komisije>
                </trajne_kontraindikacije>
            </kontraindikacija> 
        </evidencija_o_vakcinaciji>
    </obrazac_saglasnosti_za_imunizaciju>
    `
}

function getPolEnum(value: Pol) {
    return Pol[value];
}

function getRadniStatusEnum(value: RadniStatus) {
    return RadniStatus[value];
}

function getZanimanjeEnum(value: ZanimanjeZaposlenog) {
    return ZanimanjeZaposlenog[value];
}