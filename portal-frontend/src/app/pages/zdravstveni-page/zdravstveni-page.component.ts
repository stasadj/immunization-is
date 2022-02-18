import { Component, OnInit } from '@angular/core';
import { ImmunizationService } from 'src/app/services/immunization.service';

@Component({
    selector: 'app-zdravstveni-page',
    templateUrl: './zdravstveni-page.component.html',
    styleUrls: ['./zdravstveni-page.component.less'],
})
export class ZdravstveniPageComponent implements OnInit {
    idNumber: string = '';
    saglasnostId: string = '';

    constructor(private immunizationService: ImmunizationService) {}

    ngOnInit(): void {}

    search() {}
}
