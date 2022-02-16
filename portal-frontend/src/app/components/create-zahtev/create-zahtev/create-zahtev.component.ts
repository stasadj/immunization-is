import { Component, OnInit } from '@angular/core';
import { Pol } from 'src/app/model/Pol';
import { ZahtevZaSertifikat } from 'src/app/model/ZahtevZaSertifikat';
import { ToastrService } from 'ngx-toastr';
import { ZahtevService } from 'src/app/services/zahtev.service';

declare const Xonomy : any;
declare const Quill : any;

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
        jmbg: 1111111112345,
        brojPasosa: 111111111,
        razlog: 'Apsolventska ekskurzija',
    };

    public muski = Pol.M;
    public zenski = Pol.Z;

    constructor(
        private toastr: ToastrService,
        private zahtevService: ZahtevService
    ) {}

    ngOnInit(): void {}

    ngAfterViewInit(): void {
    
        var quill = new Quill('#editor', {
            theme: 'snow'
          });


      }

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


        this.zahtevService.create(this.newZahtev).subscribe(res => {
            this.toastr.success("Successfully submitted zahtev");
        })
    }

    parseDate(dateString: string): Date {
        return new Date(dateString);
    }
}
