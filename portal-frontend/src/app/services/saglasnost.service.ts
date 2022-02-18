import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Saglasnost } from '../model/Saglasnost';
import { createSaglasnostXML } from '../util/saglasnostXmlCreator';

@Injectable({
  providedIn: 'root'
})
export class SaglasnostService {
  private readonly path = '/api/consent/';

  constructor(private http: HttpClient) { }

  create(saglasnost: Saglasnost): Observable<void> {
      let xml = createSaglasnostXML(saglasnost);

      return this.http.put<void>(this.path, xml);
  }
}
