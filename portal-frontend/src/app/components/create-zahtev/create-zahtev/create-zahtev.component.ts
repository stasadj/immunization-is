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

declare const Quill: any;

@Component({
    selector: 'app-create-zahtev',
    templateUrl: './create-zahtev.component.html',
    styleUrls: ['./create-zahtev.component.less'],
    providers: [DatePipe],
})
export class CreateZahtevComponent implements OnInit {
    public quill: any;

    //TODO: delete default values after testing
    public newZahtev: ZahtevZaSertifikat = {
        mestoIzdavanja: 'Novi Sad',
        imeIPrezime: 'Proba Proba',
        datumRodjenja: new Date('01-01-1999'),
        pol: Pol["M"],
        jmbg: 1111111112345,
        brojPasosa: 111111111,
        razlog: 'Apsolventska ekskurzija',
    };

    public newZahtevFormGroup: FormGroup;

    public muski = Pol["M"];
    public zenski = Pol["Ž"];

    constructor(
        private toastr: ToastrService,
        private zahtevService: ZahtevService,
        private fb: FormBuilder,
        private datePipe: DatePipe
    ) {
        this.newZahtevFormGroup = this.fb.group({
            jmbg: [
                this.newZahtev.jmbg,
                [
                    Validators.required,
                    Validators.minLength(13),
                    Validators.maxLength(13),
                    Validators.pattern('[0-9]{13}'),
                ],
            ],
            imeIPrezime: [this.newZahtev.imeIPrezime, Validators.required],

            datumRodjenja: [
                [
                    this.datePipe.transform(
                        this.newZahtev.datumRodjenja,
                        'yyyy-MM-dd'
                    ),
                ],
                [Validators.required, this.dateValidator()],
            ],
            pol: [this.newZahtev.pol, [Validators.required]],
            brojPasosa: [
                this.newZahtev.brojPasosa,
                [Validators.required, Validators.pattern('[0-9]{9}')],
            ],
            mestoIzdavanja: [
                this.newZahtev.mestoIzdavanja,
                Validators.required,
            ],
        });
    }

    ngOnInit(): void {}

    ngAfterViewInit(): void {
        this.quill = new Quill('#editor', {
            theme: 'snow',
        });
    }

    onSaveClick() {
        this.newZahtev = {
            mestoIzdavanja: this.newZahtevFormGroup.value.mestoIzdavanja,
            imeIPrezime: this.newZahtevFormGroup.value.imeIPrezime,
            datumRodjenja: this.newZahtevFormGroup.value.datumRodjenja,
            pol: this.newZahtevFormGroup.value.pol,
            jmbg: this.newZahtevFormGroup.value.jmbg,
            brojPasosa: this.newZahtevFormGroup.value.brojPasosa,
            razlog: this.quill.root.innerHTML, //getting razlog from quill
        };

        this.zahtevService.create(this.newZahtev).subscribe((res) => {
            this.toastr.success('Zahtev za sertifikat uspešno poslat.');
        });
    }

    parseDate(dateString: string): Date {
        return new Date(dateString);
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
