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
export class AuthService {
    private readonly path: string = '/api/auth';

    private http: HttpClient;
    constructor(
        private handler: HttpBackend,
        private toastr: ToastrService,
        private XML: XmlService,
        private router: Router
    ) {
        this.http = new HttpClient(handler);
    }

    login(credentials: { username: string; password: string }) {
        this.http
            .post(`${this.path}/login`, this.toXML(credentials), {
                responseType: 'text',
                headers: { 'Content-Type': 'application/xml; charset=utf-8' },
            })
            .subscribe({
                next: (t) => {
                    console.log(t);
                    localStorage.setItem('token', t);
                    let d: any = jwt_decode(t);
                    console.log(d);
                    localStorage.setItem('username', d.sub);
                    localStorage.setItem('role', d.userRole);
                    this.changeRoute(d.userRole);
                },
                error: () => {
                    this.toastr.error('Pogresno korisnicko ime ili lozinka.');
                },
            });
    }

    whoAmI(): Observable<any> {
        return this.http
            .get(`${this.path}/whoami`, {
                responseType: 'text',
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`,
                    'Content-Type': 'application/xml; charset=utf-8',
                },
            })
            .pipe(map((d) => this.XML.parse(d)));
    }

    private toXML(credentils: { username: string; password: string }): string {
        return `
        <user_login>
            <username>${credentils.username}</username>
            <password>${credentils.password}</password>
        </user_login>
    `;
    }

    private changeRoute(role: string) {
        if (role === 'GRADANIN') this.router.navigate([`/gradjanin`]);
        else if (role === 'ZDRAVSTVENI_RADNIK')
            this.router.navigate([`/zdravstveni`]);
        else this.toastr.error('Nemoguc pristup');
    }
}
