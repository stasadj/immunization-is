import * as moment from 'moment';
import { EvidencijaOVakcinaciji } from '../model/EvidencijaOVakcinaciji';

export function createEvidencijaXML(
    evidencija: EvidencijaOVakcinaciji
): string {
    let vakcinacije = '';
    evidencija.vakcinacije.forEach(
        (v, i) =>
            (vakcinacije += `
      <vakcina>
        <broj_doze>${i + 1}</broj_doze>
        <naziv>${v.proizvodjac}</naziv>
        <datum_davanja>${moment(v.datumDavanja)
            .format('yyyy-MM-DD')
            .toString()}</datum_davanja>
        <nacin_davanja>IM</nacin_davanja>
        <ekstremitet>${v.ekstramitet}</ekstremitet>
        <serija>${v.serija}</serija>
        <proizvodjac>${v.proizvodjac}</proizvodjac>
        <nezeljena_reakcija>${v.reakcija}</nezeljena_reakcija>
      </vakcina>
    `)
    );
    return `<evidencija_o_vakcinaciji xmlns="http://www.ftn.uns.ac.rs/saglasnost/"
    xmlns:xs="http://www.w3.org/2001/XMLSchema#"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:pred="http://www.ftn.uns.ac.rs/rdf/predicate/"
    xsi:schemaLocation="http://www.ftn.uns.ac.rs/saglasnost/ saglasnost.xsd">
            <zdravstvena_ustanova>
                <naziv property="pred:vakcinisan_u" datatype="xs:string"></naziv>
                <vakcinacijski_punkt>${evidencija.vakcinacijskiPunkt}</vakcinacijski_punkt>
                <informacije_o_lekaru>
                    <ime>${evidencija.imeLekara}</ime>
                    <prezime>${evidencija.prezimeLekara}</prezime>
                    <faksimil></faksimil>
                    <broj_telefona>${evidencija.telefon}</broj_telefona>
                </informacije_o_lekaru>
            </zdravstvena_ustanova>
            <izvrsena_imunizacija>
              ${vakcinacije}
            </izvrsena_imunizacija>
            <kontraindikacija>
                <privremene_kontraindikacije>
                    <datum_utvrdjivanja></datum_utvrdjivanja>
                    <dijagnoza>${evidencija.kontraindikacije}</dijagnoza>
                </privremene_kontraindikacije>
                <trajne_kontraindikacije>
                    <odluka_komisije>${evidencija.odluka}</odluka_komisije>
                </trajne_kontraindikacije>
            </kontraindikacija> 
        </evidencija_o_vakcinaciji>
    `;
}
