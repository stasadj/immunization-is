import { Component, OnInit } from '@angular/core';
import { Pol } from 'src/app/model/Pol';
import { ZahtevZaSertifikat } from 'src/app/model/ZahtevZaSertifikat';
import * as moment from 'moment';
import { ToastrService } from 'ngx-toastr';
import { ZahtevService } from 'src/app/services/zahtev.service';

@Component({
    selector: 'app-create-zahtev',
    templateUrl: './create-zahtev.component.html',
    styleUrls: ['./create-zahtev.component.less'],
})
export class CreateZahtevComponent implements OnInit {
    public newZahtev: ZahtevZaSertifikat = {
        mestoIzdavanja: 'Novi Sad',
        imeIPrezime: 'Proba Proba',
        datumRodjenja: new Date('01-01-1999'),
        pol: Pol.M,
        jmbg: 123456789,
        brojPasosa: 65432,
        razlog: 'Apsolventska ekskurzija',
    };

    public muski = Pol.M;
    public zenski = Pol.Z;

    constructor(
        private toastr: ToastrService,
        private zahtevService: ZahtevService
    ) {}

    ngOnInit(): void {}

    onSaveClick() {
        if (
            !(
                this.newZahtev.mestoIzdavanja &&
                this.newZahtev.jmbg &&
                this.newZahtev.imeIPrezime &&
                this.newZahtev.pol &&
                this.newZahtev.brojPasosa &&
                this.newZahtev.razlog &&
                this.newZahtev.datumRodjenja
            )
        ) {
            this.toastr.error('Please input all fields!');
            return;
        }

        //TODO date of birth before today validation
        //TODO other field validations

        this.zahtevService.create(this.newZahtev);
        
        // this.zahtevService.create(this.newZahtev).subscribe(res => {
        //     this.toastr.success("Successfully submitted zahtev");
        // })
    }

    parseDate(dateString: string): Date {
        return new Date(dateString);
    }
}
