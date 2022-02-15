import { Component, OnInit } from '@angular/core';
import { Interesovanje } from '../../model/Interesovanje';
import { Form, FormGroup, FormBuilder } from '@angular/forms';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';

@Component({
    selector: 'app-create-interesovanje',
    templateUrl: './create-interesovanje.component.html',
    styleUrls: ['./create-interesovanje.component.less']
})
export class CreateInteresovanjeComponent implements OnInit {

    public newInteresovanje: Interesovanje = {
        drzavljanstvo: 'srpsko',
        jmbg: 1111111111119,
        punoIme: 'Test Test',
        email: 'test@gmail.com',
        fiksni: 123111111,
        mobilni: 1611111111,
        davalacKrvi: false,
        opstinaVakcinacije: 'Novi Sad',
        opcije: []
    };

    public opcije: FormGroup;

    constructor(private fb: FormBuilder, private interesovanjeService: InteresovanjeService) {
        this.opcije = fb.group({
            "Pfizer-BioNTech": false,
            "Astra Zeneca": false,
            "Moderna": false,
            "Sputnik": false,
            "Sinopharm": false,
            "BILO KOJA": false

        });
    }

    onSaveClick(): void {

        if (!(this.newInteresovanje.drzavljanstvo && this.newInteresovanje.jmbg && this.newInteresovanje.punoIme &&
            this.newInteresovanje.email && this.newInteresovanje.fiksni && this.newInteresovanje.mobilni && this.newInteresovanje.opstinaVakcinacije)) {
            console.log("Please input all fields!");
            return;
        }

        //TODO individual fields validation

        if (!Object.keys(this.opcije.value).some(k => !!this.opcije.value[k])) {
            console.log("Please choose atleast one vaccine option!");
            return;
        }

        this.newInteresovanje.opcije = Object.keys(this.opcije.value).filter(key => this.opcije.get(key)?.value === true);


        //TODO call service method for post method
        this.interesovanjeService.create(this.newInteresovanje).subscribe(res => {
            console.log(res);
        });





    }

    vaccineChosen() {
        if (this.opcije.get("BILO KOJA")?.value === true) {
            this.opcije.get("BILO KOJA")?.setValue(false);
        }

    }

    anyChosen() {

        if (this.opcije.get('BILO KOJA')?.value === true) {
            this.opcije = this.fb.group({
                "Pfizer-BioNTech": false,
                "Astra Zeneca": false,
                "Moderna": false,
                "Sputnik": false,
                "Sinopharm": false,
                "BILO KOJA": true
            });
        }

    }

    ngOnInit(): void {
    }

}
