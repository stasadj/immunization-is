import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ImmunizationReport } from 'src/app/model/ImmunizationReport';
import { ImmunizationReportService } from 'src/app/services/immunization-report-service';

@Component({
    selector: 'app-immunization-report',
    templateUrl: './immunization-report.component.html',
    styleUrls: ['./immunization-report.component.less'],
})
export class ImmunizationReportComponent implements OnInit {
    datumOd?: Date;
    datumDo?: Date;
    izvestaj?: ImmunizationReport;

    constructor(
        private toastr: ToastrService,
        private immunizationReportService: ImmunizationReportService
    ) {}

    ngOnInit(): void {}

    handleInputChange = () => {
        console.log(this.datumOd?.toISOString().substring(0, 10));
        console.log(this.datumDo?.toISOString().substring(0, 10));
        if (this.datumOd && this.datumDo) {
            if (this.datumOd > this.datumDo) {
                this.toastr.error(
                    'Vrednost od ne može biti nakon vrednosti do.'
                );
            } else {
                this.immunizationReportService
                    .getReport(
                        this.datumOd?.toISOString().substring(0, 10),
                        this.datumDo?.toISOString().substring(0, 10)
                    )
                    .subscribe((izvestaj) => (this.izvestaj = izvestaj));
            }
        }
    };
}
