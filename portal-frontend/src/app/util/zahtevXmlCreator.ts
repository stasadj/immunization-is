import { Pol } from "../model/Pol";
import { ZahtevZaSertifikat } from "../model/ZahtevZaSertifikat";
import * as moment from "moment";

export function createZahtevXML(zahtev: ZahtevZaSertifikat): string {

    return `<?xml version="1.0" encoding="UTF-8"?>
    <zahtev_za_sertifikat xmlns="http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/"
        xmlns:xs="http://www.w3.org/2001/XMLSchema#"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:pred="http://www.ftn.uns.ac.rs/rdf/predicate/"
        xsi:schemaLocation="http://www.ftn.uns.ac.rs/zahtev-za-sertifikat/ zahtev_za_sertifikat.xsd" 
        about="">
        
        <meta_podaci>
            <mesto_izdavanja property="pred:ima_mesto_izdavanja" datatype="xs:string">${zahtev.mestoIzdavanja}</mesto_izdavanja>
            <datum_izdavanja property="pred:ima_datum_izdavanja" datatype="xs:string">${moment().format('yyyy-MM-DD').toString()}</datum_izdavanja>
            <status_zahteva property="pred:ima_status" datatype="xs:string">NA CEKANJU</status_zahteva>
        </meta_podaci>
        
        <podnosilac_zahteva about="">
            <ime_prezime property="pred:se_zove" datatype="xs:string">${zahtev.imeIPrezime}</ime_prezime>
            <datum_rodjenja property="pred:je_rodjen" datatype="xs:string">${formatDate(zahtev.datumRodjenja)}</datum_rodjenja>
            <pol property="pred:ima_pol" datatype="xs:string">${getEnum(zahtev.pol)}</pol>
            <jmbg property="pred:ima_jmbg" datatype="xs:string">${zahtev.jmbg}</jmbg>
            <broj_pasosa property="pred:ima_broj_pasosa" datatype="xs:string">${zahtev.brojPasosa}</broj_pasosa>
            <razlog_za_podnosenje_zahteva> 
                <div xmlns="https://www.w3.org/1999/xhtml">${zahtev.razlog}</div> 
            </razlog_za_podnosenje_zahteva> 
        </podnosilac_zahteva>
    </zahtev_za_sertifikat>
    `

}

function getEnum(value: Pol){
    return Pol[value];
}

function formatDate(date: Date){
    return moment(date).format('yyyy-MM-DD').toString();
}
