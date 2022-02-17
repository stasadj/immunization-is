import { Component, OnInit } from '@angular/core';
import { Interesovanje } from '../../model/Interesovanje';
import { Form, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';
import { ToastrService } from 'ngx-toastr';
import { Drzavljanstvo } from 'src/app/model/Drzavljanstvo';

@Component({
    selector: 'app-create-interesovanje',
    templateUrl: './create-interesovanje.component.html',
    styleUrls: ['./create-interesovanje.component.less'],
})
export class CreateInteresovanjeComponent implements OnInit {

    //TODO delete default values after testing
    public newInteresovanje: Interesovanje = {
        drzavljanstvo: Drzavljanstvo['Državljanin Republike Srbije'],
        jmbg: 1111111111111,
        punoIme: 'Test Test',
        email: 'test@gmail.com',
        fiksni: 123111111,
        mobilni: 1611111111,
        davalacKrvi: false,
        opstinaVakcinacije: 'Novi Sad',
        opcije: [],
    };

    public opcije: FormGroup;
    public newInteresovanjeFormGroup: FormGroup;

    public srpsko = Drzavljanstvo['Državljanin Republike Srbije'];
    public saBoravkom = Drzavljanstvo['Strani državljanin sa boravkom u RS'];
    public bezBoravka = Drzavljanstvo['Strani državljanin bez boravka u RS'];

    constructor(
        private fb: FormBuilder,
        private interesovanjeService: InteresovanjeService,
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
            drzavljanstvo: [this.newInteresovanje.drzavljanstvo, Validators.required],
            jmbg: [
                this.newInteresovanje.jmbg,
                [
                    Validators.required,
                    Validators.minLength(13),
                    Validators.maxLength(13),
                    Validators.pattern('[0-9]{13}'),
                ],
            ],
            punoIme: [
                this.newInteresovanje.punoIme,
                Validators.required,
            ],

            email: [
                this.newInteresovanje.email,
                [Validators.required, Validators.email],
            ],
            mobilni: [
                this.newInteresovanje.mobilni,
                [Validators.required, Validators.pattern('[0-9]{9,11}')],
            ],
            fiksni: [
                this.newInteresovanje.fiksni,
                [Validators.required, Validators.pattern('[0-9]{9,10}')],
            ],
            opstinaVakcinacije: [
                this.newInteresovanje.opstinaVakcinacije,
                Validators.required,
            ],
            davalacKrvi: [
                this.newInteresovanje.davalacKrvi,
                Validators.required,
            ],
        });
    }

    ngAfterViewInit(){
        
    }

    onSaveClick(): void {

        if (
            !Object.keys(this.opcije.value).some((k) => !!this.opcije.value[k])
        ) {
            this.toastr.error('Morate odabrati barem jednu opciju vakcine');
            return;
        }


        this.newInteresovanje = {
            drzavljanstvo: this.newInteresovanjeFormGroup.value.drzavljanstvo,
            jmbg: this.newInteresovanjeFormGroup.value.jmbg,
            punoIme: this.newInteresovanjeFormGroup.value.punoIme,
            email: this.newInteresovanjeFormGroup.value.email,
            fiksni: this.newInteresovanjeFormGroup.value.fiksni,
            mobilni: this.newInteresovanjeFormGroup.value.mobilni,
            davalacKrvi: this.newInteresovanjeFormGroup.value.davalacKrvi,
            opstinaVakcinacije: this.newInteresovanjeFormGroup.value.opstinaVakcinacije,
            opcije:  Object.keys(this.opcije.value).filter(
                (key) => this.opcije.get(key)?.value === true
            ),
        };


        this.interesovanjeService.create(this.newInteresovanje).subscribe(
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

    ngOnInit(): void {}
}
