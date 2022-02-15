import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interesovanje } from '../model/Interesovanje';
import { createZahtevXML } from '../util/zahtevXmlCreator';
import { ZahtevZaSertifikat } from '../model/ZahtevZaSertifikat';

@Injectable({
    providedIn: 'root'
})
export class ZahtevService {

    private readonly path = '/api/zahtev-za-sertifikat';

    constructor(private http: HttpClient) { }

    create(zahtev: ZahtevZaSertifikat): void{
        let xml = createZahtevXML(zahtev); //TODO
        console.log(xml);
        return;
        // const headers = new HttpHeaders({ 'Content-Type': 'application/xml; charset=utf-8' }); //TODO add this to interceptor?

        // //TODO find fix for response error that happens
        // return this.http.post<void>(this.path, xml, { headers });

    }
}
