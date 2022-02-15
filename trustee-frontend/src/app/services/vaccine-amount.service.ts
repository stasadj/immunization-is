import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { VaccineAmount } from '../model/VaccineAmount';
import { XmlService } from '../utils/xml.service';

@Injectable({
    providedIn: 'root',
})
export class VaccineAmountService {
    private readonly path = '/api/vaccine';

    constructor(private http: HttpClient, private XML: XmlService) {}

    updateAmount(vaccineAmount: VaccineAmount): Observable<void> {
        let xml = this.toXML(vaccineAmount);
        const headers = new HttpHeaders({
            'Content-Type': 'application/xml; charset=utf-8',
        }); //TODO add this to interceptor?

        //TODO find fix for response error that happens
        return this.http.post<void>(this.path, xml, { headers });
    }

    getVaccines(): Observable<VaccineAmount[]> {
        return this.http.get(this.path, { responseType: 'text' }).pipe(
            map((xml) => this.XML.parse(xml)),
            map((o) =>
                (<any[]>o.VACCINE).map((v) => ({
                    type: v.TYPE[0],
                    manufacturer: v.MANUFACTURER[0],
                    series: (<any[]>v.SERIES).map((s) => ({
                        serialNumber: +s.SERIALNUMBER[0],
                        amount: +s.AMOUNT[0],
                    })),
                }))
            )
        );
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
