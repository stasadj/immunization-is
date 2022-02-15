import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VaccineAmount } from '../model/VaccineAmount';

@Injectable({
    providedIn: 'root',
})
export class VaccineAmountService {
    private readonly path = '/api/vaccine';

    constructor(private http: HttpClient) {}

    updateAmount(vaccineAmount: VaccineAmount): Observable<void> {
        let xml = this.toXML(vaccineAmount);
        const headers = new HttpHeaders({
            'Content-Type': 'application/xml; charset=utf-8',
        }); //TODO add this to interceptor?

        //TODO find fix for response error that happens
        return this.http.post<void>(this.path, xml, { headers });
    }

    private toXML(vaccineAmount: VaccineAmount): string {
        return `
        <vaccine_amount>
          <type>${vaccineAmount.type}</type>
          <manufacturer>${vaccineAmount.manufacturer}</manufacturer>
          ${vaccineAmount.series
              .map(
                  (s) => `
            <series>
                <amount>${s.amount}</amount>
                <serialNumber>${s.serialNumber}</serialNumber>
            </series>
          `
              )
              .join('')}
        </vaccine_amount>
      `;
    }
}
