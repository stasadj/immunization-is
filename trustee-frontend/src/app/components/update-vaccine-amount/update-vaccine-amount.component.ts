import { Component } from '@angular/core';
import { VaccineAmount } from 'src/app/model/VaccineAmount';

@Component({
    selector: 'app-update-vaccine-amount',
    templateUrl: './update-vaccine-amount.component.html',
    styleUrls: ['./update-vaccine-amount.component.less'],
})
export class UpdateVaccineAmountComponent {
    vaccineAmount: VaccineAmount = {
        type: '',
        manufacturer: '',
        series: [{ amount: 0, serialNumber: 0 }],
    };
    types: string[] = [
        'Pfizer-BioNTech',
        'Astra Zeneca',
        'Moderna',
        'Sputnik',
        'Sinopharm',
    ];

    constructor() {}

    onAdd() {
        this.vaccineAmount.series.push({ amount: 0, serialNumber: 0 });
    }
}
