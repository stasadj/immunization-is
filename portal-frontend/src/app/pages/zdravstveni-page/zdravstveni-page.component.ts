import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { EvidencijaOVakcinaciji } from 'src/app/model/EvidencijaOVakcinaciji';
import { AuthService } from 'src/app/services/auth.service';
import { ImmunizationService } from 'src/app/services/immunization.service';

@Component({
    selector: 'app-zdravstveni-page',
    templateUrl: './zdravstveni-page.component.html',
    styleUrls: ['./zdravstveni-page.component.less'],
})
export class ZdravstveniPageComponent implements OnInit {
    idNumber: string = '';
    saglasnostId: string = '';
    formView: boolean = false;
    evidencija: EvidencijaOVakcinaciji = {
        zdravstvenaUstanova: '',
        imeLekara: '',
        prezimeLekara: '',
        telefon: '',
        vakcinacijskiPunkt: '',
        kontraindikacije: '',
        odluka: '',
        vakcinacije: [
            {
                naziv: '',
                datumDavanja: new Date(),
                ekstramitet: 'LR',
                serija: 0,
                proizvodjac: '',
                reakcija: '',
            },
            {
                naziv: '',
                datumDavanja: new Date(),
                ekstramitet: 'LR',
                serija: 0,
                proizvodjac: '',
                reakcija: '',
            },
            {
                naziv: '',
                datumDavanja: new Date(),
                ekstramitet: 'LR',
                serija: 0,
                proizvodjac: '',
                reakcija: '',
            },
        ],
    };
    types: string[] = [
        'Pfizer-BioNTech',
        'Astra Zeneca',
        'Moderna',
        'Sputnik',
        'Sinopharm',
    ];

    constructor(
        private immunizationService: ImmunizationService,
        private authService: AuthService,
        private toastr: ToastrService
    ) {}

    ngOnInit(): void {
        this.authService.whoAmI().subscribe((i) => {
            this.evidencija.imeLekara = i.FIRST_NAME[0];
            this.evidencija.prezimeLekara = i.LAST_NAME[0];
        });
    }

    search() {
        this.immunizationService
            .getLatestConsentId(this.idNumber)
            .subscribe((id) => (this.saglasnostId = id));
    }

    display() {
        window.open(
            `http://localhost:8080/api/saglasnost/xhtml/${this.saglasnostId}`,
            '_blank'
        );
    }

    open() {
        this.formView = true;
    }

    submit() {
        this.evidencija.vakcinacije = this.evidencija.vakcinacije.filter(
            (v) => v.proizvodjac
        );

        console.log(this.evidencija);
        this.immunizationService
            .addEvidencija(this.evidencija, this.saglasnostId)
            .subscribe(
                (r) => {
                    this.toastr.success('Vakcinacija je evidentirana');
                    this.formView = false;
                    this.saglasnostId = '';
                },
                () => this.toastr.error('Neuspesna evidencija')
            );
    }
}
