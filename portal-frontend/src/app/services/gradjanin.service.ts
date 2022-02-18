import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { XmlService } from '../util/xml.service';
import jwt_decode from 'jwt-decode';
import { map, Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
    providedIn: 'root',
})
export class GradjaninService {
    private readonly path: string = '/api/dokumenti-gradjanina';

    private http: HttpClient;
    constructor(
        private handler: HttpBackend,
        private XML: XmlService,
        private router: Router
    ) {
        this.http = new HttpClient(handler);
    }

    getDocs(): Observable<any> {
        return this.http
            .get(`${this.path}`, {
                responseType: 'text',
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`,
                    'Content-Type': 'application/xml; charset=utf-8',
                },
            })
            .pipe(map((d) => this.XML.parse(d)));
    }

}