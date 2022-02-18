import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { XmlService } from '../utils/xml.service';
import { ImmunizationReport } from '../model/ImmunizationReport';

@Injectable({
    providedIn: 'root',
})
export class ImmunizationReportService {
    private readonly path = '/api/immunization-report';

    constructor(private http: HttpClient, private XML: XmlService) {}

    getReport(
        datumOd: string,
        datumDo: string
    ): Observable<ImmunizationReport> {
        return this.http
            .get(`${this.path}?startDate=${datumOd}&endDate=${datumDo}`, {
                responseType: 'text',
            })
            .pipe(
                map((xml) => this.XML.parse(xml)),
                map((i) => ({
                    interesovanjeNum:
                        i['IZVE:BROJ_DOKUMENATA_O_INTERESOVANJU'][0],
                    sertifikatNum:
                        i['IZVE:BROJ_IZDATIH_DIGITALNIH_SERTIFIKATA'][0],
                    zahtevNum:
                        i['IZVE:BROJ_ZAHTEVA_ZA_DIGITALNI_SERTIFIKAT'][0],
                    ukupnoDatoNum:
                        i[
                            'IZVE:RASPODELA_DATIH_VAKCINA_PO_REDNOM_BROJU_DOZE'
                        ][0].$.UKUPNO_DATO,
                    doza1Num:
                        i[
                            'IZVE:RASPODELA_DATIH_VAKCINA_PO_REDNOM_BROJU_DOZE'
                        ][0]['IZVE:DOZA'][0]['IZVE:BROJ_DATIH_DOZA'][0],
                    doza2Num:
                        i[
                            'IZVE:RASPODELA_DATIH_VAKCINA_PO_REDNOM_BROJU_DOZE'
                        ][0]['IZVE:DOZA'][1]['IZVE:BROJ_DATIH_DOZA'][0],
                    doza3Num:
                        i[
                            'IZVE:RASPODELA_DATIH_VAKCINA_PO_REDNOM_BROJU_DOZE'
                        ][0]['IZVE:DOZA'][2]['IZVE:BROJ_DATIH_DOZA'][0],
                    pfizerNum:
                        i['IZVE:RASPODELA_DATIH_VAKCINA_PO_PROIZVODJACIMA'][0][
                            'IZVE:PROIZVODJAC'
                        ][0]['IZVE:BROJ_DATIH_DOZA'][0],
                    sinopharmNum:
                        i['IZVE:RASPODELA_DATIH_VAKCINA_PO_PROIZVODJACIMA'][0][
                            'IZVE:PROIZVODJAC'
                        ][1]['IZVE:BROJ_DATIH_DOZA'][0],
                    sputnikNum:
                        i['IZVE:RASPODELA_DATIH_VAKCINA_PO_PROIZVODJACIMA'][0][
                            'IZVE:PROIZVODJAC'
                        ][2]['IZVE:BROJ_DATIH_DOZA'][0],
                    astraNum:
                        i['IZVE:RASPODELA_DATIH_VAKCINA_PO_PROIZVODJACIMA'][0][
                            'IZVE:PROIZVODJAC'
                        ][3]['IZVE:BROJ_DATIH_DOZA'][0],
                }))
            );
    }

    getPDF(uuid: string): Observable<string> {
        return this.http.get<string>(`${this.path}/pdf/${uuid}`, {
            responseType: 'arraybuffer' as 'json',
        });
    }

    getXHTML(uuid: string): Observable<string> {
        return this.http.get<string>(`${this.path}/xhtml/${uuid}`, {
            responseType: 'arraybuffer' as 'json',
        });
    }
}
