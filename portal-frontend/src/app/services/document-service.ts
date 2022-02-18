import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interesovanje } from '../model/Interesovanje';
import { createInteresovanjeXML } from '../util/interesovanjeXmlCreator';

@Injectable({
    providedIn: 'root',
})
export class DocumentService {
    private readonly path = '/api';

    constructor(private http: HttpClient) {}

    getFile(id: string, documentFormat: string, documentType: string): Observable<string> {
        if (documentType.startsWith("potvrda")){
            documentType = "potvrda";
        }
        return this.http.get<string>(`${this.path}/${documentType}/${documentFormat}/${id}`, {
            responseType: 'arraybuffer' as 'json',
        });
    }
}
