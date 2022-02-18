export interface EvidencijaOVakcinaciji {
    zdravstvenaUstanova: string;
    imeLekara: string;
    prezimeLekara: string;
    telefon: string;
    vakcinacijskiPunkt: string;
    kontraindikacije: string;
    odluka: string;
    vakcinacije: Vakcinacija[];
}

interface Vakcinacija {
    naziv: string;
    datumDavanja: Date;
    ekstramitet: 'LR' | 'DR';
    serija: number;
    proizvodjac: string;
    reakcija: string;
}
