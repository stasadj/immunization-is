import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { VaccineAmount } from 'src/app/model/VaccineAmount';
import { VaccineAmountService } from 'src/app/services/vaccine-amount.service';

@Component({
    selector: 'app-update-vaccine-amount',
    templateUrl: './update-vaccine-amount.component.html',
    styleUrls: ['./update-vaccine-amount.component.less'],
})
export class UpdateVaccineAmountComponent implements OnInit {
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

    constructor(
        private vaccineAmountService: VaccineAmountService,
        private toastr: ToastrService
    ) {}

    ngOnInit(): void {}

    onAdd() {
        this.vaccineAmount.series.push({ amount: 0, serialNumber: 0 });
    }

    onSubmit() {
        this.vaccineAmountService
            .updateAmount(this.vaccineAmount)
            .subscribe((res) => {
                this.toastr.success('Uspesno azurirana kolicina');
            });
    }
}
