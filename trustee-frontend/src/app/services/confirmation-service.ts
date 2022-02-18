import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { XmlService } from '../utils/xml.service';
import { Confirmation } from '../model/Confirmation';

@Injectable({
    providedIn: 'root',
})
export class ConfirmationService {
    private readonly path = '/api/confirmation';

    constructor(private http: HttpClient, private XML: XmlService) {}

    getConfirmationsByJMBG(jmbg: string): Observable<Confirmation[]> {
        return this.http
            .get(`${this.path}?jmbg=${jmbg}`, {
                responseType: 'text',
            })
            .pipe(
                map((xml) => this.XML.parse(xml)),
                map((o) =>
                    (<any[]>o.POTVRDA).map((p) => ({
                        uuid: p.UUID[0],
                        date: p.DATUM[0],
                        doza: p.DOZA[0],
                        tip: p.TIP[0],
                    }))
                )
            );
    }
}
