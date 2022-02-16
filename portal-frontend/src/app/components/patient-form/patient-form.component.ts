import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { ConfirmedValidator } from 'src/app/validators/confirmed.validator';

@Component({
    selector: 'app-patient-form',
    templateUrl: './patient-form.component.html',
    styleUrls: ['./patient-form.component.less'],
})
export class PatientFormComponent {
    success: boolean = false;
    registerForm = new FormGroup(
        {
            firstName: new FormControl('', [Validators.required]),
            lastName: new FormControl('', [Validators.required]),
            email: new FormControl('', [Validators.required, Validators.email]),
            password: new FormControl('', [
                Validators.required,
                Validators.minLength(8),
            ]),
            confirmPassword: new FormControl('', [Validators.required]),
        },

        ConfirmedValidator('password', 'confirmPassword')
    );

    constructor(private userService: UserService) {}

    onSubmit() {
        if (this.registerForm.invalid) return;
        this.userService.register(this.registerForm.value).subscribe(() => {
            this.success = true;
        });
        console.log(this.registerForm.value);
    }
}
