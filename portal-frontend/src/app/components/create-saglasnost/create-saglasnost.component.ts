import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MatRadioChange } from '@angular/material/radio';
import { ToastrService } from 'ngx-toastr';
import { Pol } from 'src/app/model/Pol';
import { RadniStatus } from 'src/app/model/RadniStatus';
import { Saglasnost } from 'src/app/model/Saglasnost';
import { ZanimanjeZaposlenog } from 'src/app/model/ZanimanjeZaposlenog';
import { SaglasnostService } from 'src/app/services/saglasnost.service';
import { EventEmitter } from 'stream';

@Component({
  selector: 'app-create-saglasnost',
  templateUrl: './create-saglasnost.component.html',
  styleUrls: ['./create-saglasnost.component.less']
})
export class CreateSaglasnostComponent implements OnInit {

  public polFormGroup: FormGroup;
  public radniStatusFormGroup: FormGroup;
  public zanimanjeFormGroup: FormGroup;
  public korisnikSocZastFormGroup: FormGroup;
  public saglasanFormGroup: FormGroup;
  public saglasnostFormGroup: FormGroup;

  public male = Pol['M'];
  public female = Pol['Ž'];

  public zaposlen = RadniStatus['zaposlen'];
  public nezaposlen = RadniStatus['nezaposlen'];
  public penzioner = RadniStatus['penzioner'];
  public ucenik = RadniStatus['učenik'];
  public student = RadniStatus['student'];
  public dete = RadniStatus['dete'];

  public zdravstvenaZastita = ZanimanjeZaposlenog['zdravstvena zaštita'];
  public socijalnaZastita = ZanimanjeZaposlenog['socijalna zaštita'];
  public prosveta = ZanimanjeZaposlenog['prosveta'];
  public mup = ZanimanjeZaposlenog['MUP'];
  public vojskaRS = ZanimanjeZaposlenog['vojska RS'];
  public drugo = ZanimanjeZaposlenog['drugo'];

  constructor(
    private fb: FormBuilder,
    private saglasnostService: SaglasnostService,
    private toastr: ToastrService
  ) {
    this.polFormGroup = fb.group({
      options: new FormControl(null)
    });

    this.radniStatusFormGroup = fb.group({
      options: new FormControl(null)
    });

    this.zanimanjeFormGroup = fb.group({
      options: new FormControl(null)
    });

    this.korisnikSocZastFormGroup = fb.group({
      options: new FormControl(null)
    });

    this.saglasanFormGroup = fb.group({
      options: new FormControl(null)
    });

    this.saglasnostFormGroup = fb.group({
      jmbg: [
        null,
        [
          Validators.minLength(13),
          Validators.maxLength(13),
          Validators.pattern('[0-9]{13}'),
        ],
      ],
      brojPasosa: [null],
      nazivStranogDrzavljanstva: [null],
      punoIme: [null, Validators.required],
      imeRoditelja: [null, Validators.required],
      datumRodjenja: [new Date(), Validators.required],
      mestoRodjenja: [null, Validators.required],
      ulica: [null, Validators.required],
      ulicaBroj: [null, Validators.required],
      mesto: [null, Validators.required],
      opstina: [null, Validators.required],
      fiksni: [
        null,
        [Validators.required, Validators.pattern('[0-9]{9,10}')],
      ],
      mobilni: [
        null,
        [Validators.required, Validators.pattern('[0-9]{9,11}')],
      ],
      email: [
        null,
        [Validators.required, Validators.email],
      ],
      nazivSocZdravstveneUstanove: [null],
      opstinaSedistaSocZdravstveneUstanove: [null],
      nazivLeka: [null, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  onSaveClick(): void {
    const opstinaSedistaSocZdravstveneUstanove: string | undefined = this.saglasnostFormGroup.value.opstinaSedistaSocZdravstveneUstanove;
    const nazivSocZdravstveneUstanove: string | undefined = this.saglasnostFormGroup.value.nazivSocZdravstveneUstanove;
    const jmbg: string | undefined = this.saglasnostFormGroup.value.jmbg;
    const nazivStranogDrzavljanstva: string | undefined = this.saglasnostFormGroup.value.nazivStranogDrzavljanstva;
    const brojPasosa: string | undefined = this.saglasnostFormGroup.value.brojPasosa;
    const zanimanjeZaposlenog: ZanimanjeZaposlenog = this.zanimanjeFormGroup.value.options;

    if (
      (jmbg && (brojPasosa || nazivStranogDrzavljanstva)) ||
      (!jmbg && (!brojPasosa || !nazivStranogDrzavljanstva))
    ) {
      this.toastr.error('Morate popuniti ili JMBG ili informacije za strane državljane');
      return;
    }

    if (this.polFormGroup.value.options === null) {
      this.toastr.error('Morate odabrati pol');
      return;
    }

    if (this.radniStatusFormGroup.value.options === null) {
      this.toastr.error('Morate odabrati radni status');
      return;
    }

    if (
      this.radniStatusFormGroup.value.options === RadniStatus.zaposlen &&
      (zanimanjeZaposlenog === undefined || !zanimanjeZaposlenog)
    ) {
      this.toastr.error('Morate odabrati zanimanje');
      return;
    }

    if (this.korisnikSocZastFormGroup.value.options === null) {
      this.toastr.error('Morate odabrati da li ste korisnik ustanove za socijalnu zaštitu');
      return;
    }

    if (this.saglasanFormGroup.value.options === null) {
      this.toastr.error('Morate odabrati da li ste saglasni ili ne sa sprovođenjem imunizacije');
      return;
    }

    console.log('this.korisnikSocZastFormGroup.value.option')
    console.log(this.korisnikSocZastFormGroup.value.option)

    console.log('nazivOpstineZdravUstanove')
    console.log(nazivSocZdravstveneUstanove)
    if (
      this.korisnikSocZastFormGroup.value.options &&
      (
        (
          nazivSocZdravstveneUstanove === undefined ||
          !nazivSocZdravstveneUstanove ||
          nazivSocZdravstveneUstanove.length === 0
        )
        ||
        (
          opstinaSedistaSocZdravstveneUstanove === undefined ||
          !opstinaSedistaSocZdravstveneUstanove ||
          opstinaSedistaSocZdravstveneUstanove.length === 0
        )
      )
    ) {
      this.toastr.error('Morate navesti naziv i opštinu sedišta ustanove za socijalnu zaštitu');
      return;
    }

    let newSaglasnost: Saglasnost = {
      datumRodjenja: this.saglasnostFormGroup.value.datumRodjenja,
      punoIme: this.saglasnostFormGroup.value.punoIme,
      imeRoditelja: this.saglasnostFormGroup.value.imeRoditelja,
      pol: this.polFormGroup.value.options,
      mestoRodjenja: this.saglasnostFormGroup.value.mestoRodjenja,
      ulica: this.saglasnostFormGroup.value.ulica,
      ulicaBroj: this.saglasnostFormGroup.value.ulicaBroj,
      mesto: this.saglasnostFormGroup.value.mesto,
      opstina: this.saglasnostFormGroup.value.opstina,
      fiksni: this.saglasnostFormGroup.value.fiksni,
      mobilni: this.saglasnostFormGroup.value.mobilni,
      email: this.saglasnostFormGroup.value.email,
      radniStatus: this.radniStatusFormGroup.value.options,
      korisnikZdravstveneZastite: this.korisnikSocZastFormGroup.value.options,
      saglasan: this.saglasanFormGroup.value.options,
      nazivLeka: this.saglasnostFormGroup.value.nazivLeka,
      brojPasosa: brojPasosa && brojPasosa.length !== 0 ? brojPasosa : undefined,
      nazivStranogDrzavljanstva: nazivStranogDrzavljanstva && nazivStranogDrzavljanstva.length !== 0 ? nazivStranogDrzavljanstva : undefined,
      jmbg: jmbg && jmbg.length !== 0 ? jmbg : undefined,
      nazivSocZdravstveneUstanove: nazivSocZdravstveneUstanove && nazivSocZdravstveneUstanove.length !== 0 ? nazivSocZdravstveneUstanove : undefined,
      nazivSedistaOpstineSocZdravstveneUstanove: opstinaSedistaSocZdravstveneUstanove && opstinaSedistaSocZdravstveneUstanove.length !== 0 ? opstinaSedistaSocZdravstveneUstanove : undefined,
      zanimanjeZaposlenog: zanimanjeZaposlenog ? zanimanjeZaposlenog : undefined
    };

    console.log(newSaglasnost)

    this.saglasnostService.create(newSaglasnost).subscribe(
      (res) => {
        this.toastr.success(
          'Saglasnost je uspešno zabeleženo.'
        );
      },
      (error) => {
        this.toastr.error('Došlo je do greške.'); //TODO add to intereceptor?
      }
    );
  }

  radniStatusChanged(event: MatRadioChange) {
    if (event.value !== RadniStatus.zaposlen) {
      this.zanimanjeFormGroup.patchValue({
        options: null
      });
    }
  }

}
