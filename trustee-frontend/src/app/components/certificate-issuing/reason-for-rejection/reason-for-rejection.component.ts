import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { CertificateRequestService } from 'src/app/services/certificate-request-service';

@Component({
    selector: 'app-reason-for-rejection',
    templateUrl: './reason-for-rejection.component.html',
    styleUrls: ['./reason-for-rejection.component.less'],
})
export class ReasonForRejectionComponent implements OnInit {
    public razlog: string = '';
    constructor(
        public dialog: MatDialog,
        private toastr: ToastrService,
        private certificateRequestService: CertificateRequestService,
        @Inject(MAT_DIALOG_DATA) public data: any
    ) {}

    ngOnInit(): void {}

    handleReject = () => {
        if (!this.razlog) {
            this.toastr.error('Morate uneti razlog odbijanja.');
            return;
        }
        this.certificateRequestService
            .reject({
                uuid: this.data.zahtev.uuid,
                reason: this.razlog,
            })
            .subscribe(() => {
                this.dialog.closeAll();
                this.toastr.success('Zahtev uspešno odbijen.');
            });
    };
}
