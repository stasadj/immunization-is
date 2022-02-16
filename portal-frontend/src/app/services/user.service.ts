import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegistration } from '../model/UserRegistration';

@Injectable({
    providedIn: 'root',
})
export class UserService {
    private readonly path = '/api/user';

    constructor(private http: HttpClient) {}

    register(patient: UserRegistration): Observable<void> {
        let xml = this.toXML(patient);
        return this.http.post<void>(this.path + '/register', xml);
    }

    private toXML(patient: UserRegistration): string {
        return `
          <user_registration>
              <email>${patient.email}</email>
              <first_name>${patient.firstName}</first_name>
              <last_name>${patient.lastName}</last_name>
              <password>${patient.password}</password>
          </user_registration>
      `;
    }
}
