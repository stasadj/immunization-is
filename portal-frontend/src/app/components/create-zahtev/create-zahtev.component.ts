import { Component, OnInit } from '@angular/core';
import { Pol } from 'src/app/model/Pol';
import { ZahtevZaSertifikat } from 'src/app/model/ZahtevZaSertifikat';
import { ToastrService } from 'ngx-toastr';
import { ZahtevService } from 'src/app/services/zahtev.service';
import {
    AbstractControl,
    FormBuilder,
    FormGroup,
    ValidatorFn,
    Validators,
} from '@angular/forms';
import { DatePipe } from '@angular/common';
import * as moment from 'moment';
import { AuthService } from 'src/app/services/auth.service';
import { ɵNoopAnimationStyleNormalizer } from '@angular/animations/browser';

declare const Quill: any;

@Component({
    selector: 'app-create-zahtev',
    templateUrl: './create-zahtev.component.html',
    styleUrls: ['./create-zahtev.component.less'],
    providers: [DatePipe],
})
export class CreateZahtevComponent implements OnInit {
    public quill: any;

    public loggedUser = { FIRST_NAME: '', LAST_NAME: '' };

    public newZahtevFormGroup: FormGroup;

    public muski = Pol['M'];
    public zenski = Pol['Ž'];

    constructor(
        private toastr: ToastrService,
        private zahtevService: ZahtevService,
        private authService: AuthService,
        private fb: FormBuilder,
        private datePipe: DatePipe
    ) {
        this.newZahtevFormGroup = this.fb.group({
            jmbg: [
                null,
                [Validators.required, Validators.pattern('[0-9]{13}')],
            ],
            imeIPrezime: [{ value: null, disabled: true }, Validators.required],

            datumRodjenja: [
                [this.datePipe.transform(new Date('01-01-1999'), 'yyyy-MM-dd')],
                [Validators.required, this.dateValidator()],
            ],
            pol: [null, [Validators.required]],
            brojPasosa: [
                null,
                [Validators.required, Validators.pattern('[0-9]{9}')],
            ],
            mestoIzdavanja: [null, Validators.required],
        });
    }

    ngOnInit(): void {
        this.authService.whoAmI().subscribe((res) => {
            this.loggedUser = res;

            this.newZahtevFormGroup.patchValue({
                imeIPrezime:
                    this.loggedUser.FIRST_NAME +
                    ' ' +
                    this.loggedUser.LAST_NAME,
            });
        });
    }

    ngAfterViewInit(): void {
        this.quill = new Quill('#editor', {
            theme: 'snow',
        });
    }

    onSaveClick() {
        let newZahtev: ZahtevZaSertifikat = {
            mestoIzdavanja: this.newZahtevFormGroup.value.mestoIzdavanja,
            imeIPrezime: this.newZahtevFormGroup.getRawValue().imeIPrezime,
            datumRodjenja: this.newZahtevFormGroup.value.datumRodjenja,
            pol: this.newZahtevFormGroup.value.pol,
            jmbg: this.newZahtevFormGroup.value.jmbg,
            brojPasosa: this.newZahtevFormGroup.value.brojPasosa,
            razlog: this.quill.root.innerHTML, //getting razlog from quill
        };

        this.zahtevService.create(newZahtev).subscribe((res) => {
            this.toastr.success('Zahtev za sertifikat uspešno poslat.');
        });
    }

    dateValidator(): ValidatorFn {
        return (control: AbstractControl): { [key: string]: any } | null => {
            if (!(control && control.value)) {
                // if there's no control or no value, that's ok
                return null;
            }

            // return null if there's no errors
            return moment().isBefore(moment(control.value))
                ? { invalidDate: 'Datum rodjenja mora biti u proslosti' }
                : null;
        };
    }
}
