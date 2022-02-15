import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interesovanje } from '../model/Interesovanje';
import { createInteresovanjeXML } from '../util/interesovanjeXmlCreator';
import { ZahtevZaSertifikat } from '../model/ZahtevZaSertifikat';

@Injectable({
    providedIn: 'root'
})
export class ZahtevService {

    private readonly path = '/api/zahtev-za-sertifikat';

    constructor(private http: HttpClient) { }

    create(zahtev: ZahtevZaSertifikat): Observable<void> {
        let xml = "";
        // let xml = createZahtevXML(zahtev); //TODO
        const headers = new HttpHeaders({ 'Content-Type': 'application/xml; charset=utf-8' }); //TODO add this to interceptor?

        //TODO find fix for response error that happens
        return this.http.post<void>(this.path, xml, { headers });

    }
}
