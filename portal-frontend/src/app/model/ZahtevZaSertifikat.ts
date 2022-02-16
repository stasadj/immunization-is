import { PathLocationStrategy } from "@angular/common";
import { Pol } from "./Pol";

export interface ZahtevZaSertifikat {
    mestoIzdavanja: string;
    imeIPrezime: string;
    datumRodjenja: Date;
    pol: Pol;
    jmbg: number;
    brojPasosa: number;
    razlog: string;

}