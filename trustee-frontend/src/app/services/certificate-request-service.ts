import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { XmlService } from '../utils/xml.service';
import { CertificateRequest } from '../model/CertificateRequest';
import { Odgovor } from '../model/Odgovor';

@Injectable({
    providedIn: 'root',
})
export class CertificateRequestService {
    private readonly path = '/api/certificate-request';

    constructor(private http: HttpClient, private XML: XmlService) {}

    getPendingRequests(): Observable<CertificateRequest[]> {
        return this.http
            .get(`${this.path}/pending`, {
                responseType: 'text',
            })
            .pipe(
                map((xml) => this.XML.parse(xml)),
                map((o) =>
                    (<any[]>o.ZAHTEV).map((z) => ({
                        uuid: z.UUID[0],
                        date: z.DATUM[0],
                        jmbg: z.JMBG[0],
                    }))
                )
            );
    }

    public accept(odgovor: Odgovor): Observable<void> {
        let xml = this.toXML(odgovor);
        return this.http.post<void>(`${this.path}/accept`, xml);
    }

    public reject(odgovor: Odgovor): Observable<void> {
        let xml = this.toXML(odgovor);
        return this.http.post<void>(`${this.path}/reject`, xml);
    }

    private toXML(odgovor: Odgovor): string {
        return `
        <odgovor>
          <uuid>${odgovor.uuid}</uuid>
          <razlog_odbijanja>${odgovor.reason}</razlog_odbijanja>
        </odgovor>
      `;
    }
}
