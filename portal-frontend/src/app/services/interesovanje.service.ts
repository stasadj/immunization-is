import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interesovanje } from '../model/Interesovanje';
import { createInteresovanjeXML } from '../util/interesovanjeXmlCreator';

@Injectable({
    providedIn: 'root'
})
export class InteresovanjeService {

    private readonly path = '/api/interesovanje';

    constructor(private http: HttpClient) { }

    create(interesovanje: Interesovanje): Observable<void> {
        let xml = createInteresovanjeXML(interesovanje);
        const headers = new HttpHeaders({'Content-Type':'application/xml; charset=utf-8'});
        return this.http.post<void>(this.path, xml, {headers});

    }
}
