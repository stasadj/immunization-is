import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class ImmunizationService {
    private readonly path = '/api/consent';

    constructor(private http: HttpClient) {}

    getLatestConsentId(idNumber: string): Observable<string> {
        return this.http.get(this.path + '/' + idNumber, {
            responseType: 'text',
        });
    }
}
