import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interesovanje } from '../model/Interesovanje';
import { createInteresovanjeXML } from '../util/interesovanjeXmlCreator';

@Injectable({
    providedIn: 'root',
})
export class InteresovanjeService {
    private readonly path = '/api/interesovanje';

    constructor(private http: HttpClient) {}

    create(interesovanje: Interesovanje): Observable<void> {
        let xml = createInteresovanjeXML(interesovanje);

        return this.http.post<void>(this.path, xml);
    }

    getPDF(id: string): Observable<string> {
        return this.http.get<string>(`${this.path}/pdf/${id}`, {
            responseType: 'arraybuffer' as 'json',
        });
    }
}
