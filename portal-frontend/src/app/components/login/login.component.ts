import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less'],
})
export class LoginComponent {
    username: string = '';
    password: string = '';

    constructor(private auth: AuthService) {}

    onLogin() {
        this.auth.login({ username: this.username, password: this.password });
    }
}
