import { Drzavljanstvo } from "./Drzavljanstvo";
import { Pol } from "./Pol";
import { RadniStatus } from "./RadniStatus";
import { ZanimanjeZaposlenog } from "./ZanimanjeZaposlenog";

export interface Saglasnost {
    jmbg?: string;
    brojPasosa?: string;
    nazivStranogDrzavljanstva?: string;
    punoIme: string;
    imeRoditelja: string;
    pol: Pol;
    datumRodjenja: Date;
    mestoRodjenja: string;
    ulica: string;
    ulicaBroj: string;
    mesto: string;
    opstina: string;
    fiksni: string;
    mobilni: string;
    email: string;
    radniStatus: RadniStatus;
    zanimanjeZaposlenog?: ZanimanjeZaposlenog;
    korisnikZdravstveneZastite: boolean;
    nazivSocZdravstveneUstanove?: string;
    nazivSedistaOpstineSocZdravstveneUstanove?: string;
    saglasan: boolean;
    nazivLeka: string;
}