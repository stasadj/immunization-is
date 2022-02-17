import { Component, OnInit } from '@angular/core';
import { Interesovanje } from '../../model/Interesovanje';
import { Form, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';
import { ToastrService } from 'ngx-toastr';
import { Drzavljanstvo } from 'src/app/model/Drzavljanstvo';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-create-interesovanje',
    templateUrl: './create-interesovanje.component.html',
    styleUrls: ['./create-interesovanje.component.less'],
})
export class CreateInteresovanjeComponent implements OnInit {
    public loggedUser = { FIRST_NAME: '', LAST_NAME: '', EMAIL: '' };

    public opcije: FormGroup;
    public newInteresovanjeFormGroup: FormGroup;

    public srpsko = Drzavljanstvo['Državljanin Republike Srbije'];
    public saBoravkom = Drzavljanstvo['Strani državljanin sa boravkom u RS'];
    public bezBoravka = Drzavljanstvo['Strani državljanin bez boravka u RS'];

    constructor(
        private fb: FormBuilder,
        private interesovanjeService: InteresovanjeService,
        private authService: AuthService,
        private toastr: ToastrService
    ) {
        this.opcije = fb.group({
            'Pfizer-BioNTech': false,
            'Astra Zeneca': false,
            Moderna: false,
            Sputnik: false,
            Sinopharm: false,
            'BILO KOJA': false,
        });

        this.newInteresovanjeFormGroup = this.fb.group({
            drzavljanstvo: [null, Validators.required],
            jmbg: [
                null,
                [
                    Validators.required,
                    Validators.minLength(13),
                    Validators.maxLength(13),
                    Validators.pattern('[0-9]{13}'),
                ],
            ],
            punoIme: [{ value: null, disabled: true }, Validators.required],

            email: [
                { value: null, disabled: true },
                [Validators.required, Validators.email],
            ],
            mobilni: [
                null,
                [Validators.required, Validators.pattern('[0-9]{9,11}')],
            ],
            fiksni: [
                null,
                [Validators.required, Validators.pattern('[0-9]{9,10}')],
            ],
            opstinaVakcinacije: [null, Validators.required],
            davalacKrvi: [false, Validators.required],
        });
    }

    ngOnInit(): void {
        this.authService.whoAmI().subscribe((res) => {
            this.loggedUser = res;

            this.newInteresovanjeFormGroup.patchValue({
                punoIme:
                    this.loggedUser.FIRST_NAME +
                    ' ' +
                    this.loggedUser.LAST_NAME,

                email: this.loggedUser.EMAIL,
            });
        });
    }

    ngAfterViewInit() {}

    onSaveClick(): void {
        if (
            !Object.keys(this.opcije.value).some((k) => !!this.opcije.value[k])
        ) {
            this.toastr.error('Morate odabrati barem jednu opciju vakcine');
            return;
        }

        let newInteresovanje: Interesovanje = {
            drzavljanstvo: this.newInteresovanjeFormGroup.value.drzavljanstvo,
            jmbg: this.newInteresovanjeFormGroup.value.jmbg,
            punoIme: this.newInteresovanjeFormGroup.getRawValue().punoIme,
            email: this.newInteresovanjeFormGroup.getRawValue().email,
            fiksni: this.newInteresovanjeFormGroup.value.fiksni,
            mobilni: this.newInteresovanjeFormGroup.value.mobilni,
            davalacKrvi: this.newInteresovanjeFormGroup.value.davalacKrvi,
            opstinaVakcinacije:
                this.newInteresovanjeFormGroup.value.opstinaVakcinacije,
            opcije: Object.keys(this.opcije.value).filter(
                (key) => this.opcije.get(key)?.value === true
            ),
        };


        this.interesovanjeService.create(newInteresovanje).subscribe(
            (res) => {
                this.toastr.success(
                    'Interesovanje uspešno zabeleženo. Proverite Vaš mejl.'
                );
            },
            (error) => {
                this.toastr.error('Već postoji interesovanje.'); //TODO add to intereceptor?
            }
        );
    }

    vaccineChosen() {
        if (this.opcije.get('BILO KOJA')?.value === true) {
            this.opcije.get('BILO KOJA')?.setValue(false);
        }
    }

    anyChosen() {
        if (this.opcije.get('BILO KOJA')?.value === true) {
            this.opcije = this.fb.group({
                'Pfizer-BioNTech': false,
                'Astra Zeneca': false,
                Moderna: false,
                Sputnik: false,
                Sinopharm: false,
                'BILO KOJA': true,
            });
        }
    }
}
