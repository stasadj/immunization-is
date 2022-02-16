import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { XmlService } from '../util/xml.service';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    private readonly path: string = '/api/auth';

    private http: HttpClient;
    constructor(
        private handler: HttpBackend,
        private toastr: ToastrService,
        private XML: XmlService
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
                    console.log(t), localStorage.setItem('token', t);
                    this.whoAmI(t);
                },
                error: () => {
                    this.toastr.error('Incorrect username or password.');
                },
            });
    }

    whoAmI(token: string) {
        this.http
            .get(`${this.path}/whoami`, {
                responseType: 'text',
                headers: {
                    Authorization: `Bearer ${token}`,
                    'Content-Type': 'application/xml; charset=utf-8',
                },
            })
            .subscribe((d: any) => {
                d = this.XML.parse(d);
                console.log(d);
                localStorage.setItem('username', d.USERNAME[0]);
                localStorage.setItem('role', d.ROLE[0]);
            });
    }

    private toXML(credentils: { username: string; password: string }): string {
        return `
        <user_login>
            <username>${credentils.username}</username>
            <password>${credentils.password}</password>
        </user_login>
    `;
    }
}
