import { Component, OnInit } from '@angular/core';
import { Interesovanje } from '../../model/Interesovanje';
import { Form, FormGroup, FormBuilder } from '@angular/forms';

@Component({
    selector: 'app-create-interesovanje',
    templateUrl: './create-interesovanje.component.html',
    styleUrls: ['./create-interesovanje.component.less']
})
export class CreateInteresovanjeComponent implements OnInit {

    public newInteresovanje: Interesovanje = {
        drzavljanstvo: '',
        jmbg: 0,
        punoIme: '',
        email: '',
        fiksni: 0,
        mobilni: 0,
        davalacKrvi: false,
        opstinaVakcinacije: '',
        opcije: []
    };

    public opcije: FormGroup;

    constructor(private fb: FormBuilder) {
        this.opcije = fb.group({
            pfizer: false,
            astra: false,
            moderna: false,
            sputnik: false,
            sinopharm: false,
            biloKoja: false

        });
    }

    onSaveClick(): void {
        if (!(this.newInteresovanje.drzavljanstvo && this.newInteresovanje.jmbg && this.newInteresovanje.punoIme &&
            this.newInteresovanje.email && this.newInteresovanje.fiksni && this.newInteresovanje.mobilni && this.newInteresovanje.opstinaVakcinacije)) {
            console.log("Please input all fields!");
            return;
        }

        //TODO ndividual fields validation

        if (!Object.keys(this.opcije.value).some(k => !!this.opcije.value[k])){
            console.log("Please choose atleast one vaccine option!");
            return;
        }



    }

    vaccineChosen(){
        if (this.opcije.get("biloKoja")?.value === true){
            this.opcije.get("biloKoja")?.setValue(false);
        }

    }

    anyChosen(){

        if(this.opcije.get('biloKoja')?.value === true){
            this.opcije = this.fb.group({
                pfizer: false,
                astra: false,
                moderna: false,
                sputnik: false,
                sinopharm: false,
                biloKoja: true
            });
        }
        
    }

    ngOnInit(): void {
    }

}
