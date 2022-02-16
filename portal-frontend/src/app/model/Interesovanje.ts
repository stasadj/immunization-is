import { Drzavljanstvo } from "./Drzavljanstvo";

export interface Interesovanje {
    drzavljanstvo: Drzavljanstvo;
    jmbg: number;
    punoIme: string;
    email: string;
    fiksni: number;
    mobilni: number;
    davalacKrvi: boolean;
    opstinaVakcinacije: string;
    opcije: string[];


}