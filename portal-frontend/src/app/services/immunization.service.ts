import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EvidencijaOVakcinaciji } from '../model/EvidencijaOVakcinaciji';
import { createEvidencijaXML } from '../util/evidencijaXmlCreator';

@Injectable({
    providedIn: 'root',
})
export class ImmunizationService {
    private readonly path: string = '/api/saglasnost';

    constructor(private http: HttpClient) {}

    getLatestConsentId(idNumber: string): Observable<string> {
        return this.http.get(this.path + '/latest/' + idNumber, {
            responseType: 'text',
        });
    }

    addEvidencija(evidencija: EvidencijaOVakcinaciji, documentId: string) {
        return this.http.put(
            this.path + `/vaccination-record/${documentId}`,
            createEvidencijaXML(evidencija)
        );
    }
}
