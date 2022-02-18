import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { VaccineAmount } from 'src/app/model/VaccineAmount';
import { VaccineAmountService } from 'src/app/services/vaccine-amount.service';
import { UpdateVaccineAmountComponent } from '../update-vaccine-amount/update-vaccine-amount.component';

@Component({
    selector: 'app-vaccine-report',
    templateUrl: './vaccine-report.component.html',
    styleUrls: ['./vaccine-report.component.less'],
})
export class VaccineReportComponent implements OnInit {
    vaccines: VaccineAmount[] = [];
    displayedColumns: string[] = ['serialNumber', 'amount'];

    constructor(
        private vaccineAmountService: VaccineAmountService,
        private dialog: MatDialog,
        private toastr: ToastrService
    ) {}

    ngOnInit(): void {
        this.getVaccines();
    }

    getVaccines() {
        this.vaccineAmountService
            .getVaccines()
            .subscribe((v) => (this.vaccines = v));
    }

    updateVaccines(vaccineAmount: VaccineAmount) {
        this.vaccineAmountService.updateAmount(vaccineAmount).subscribe(() => {
            this.toastr.success('Uspesno azurirana kolicina');
            this.getVaccines();
        });
        console.log(vaccineAmount);
    }

    openDialog() {
        const dialogRef = this.dialog.open(UpdateVaccineAmountComponent, {
            disableClose: true,
            width: '50%',
            height: '70%',
            panelClass: 'update-dialog',
        });

        dialogRef.afterClosed().subscribe((va) => {
            if (!va) return;
            this.updateVaccines(va);
        });
    }
}
