import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Confirmation } from 'src/app/model/Confirmation';
import { CertificateRequestService } from 'src/app/services/certificate-request-service';
import { ConfirmationService } from 'src/app/services/confirmation-service';
import { ReasonForRejectionComponent } from '../reason-for-rejection/reason-for-rejection.component';

@Component({
    selector: 'app-response',
    templateUrl: './response.component.html',
    styleUrls: ['./response.component.less'],
})
export class ResponseComponent implements OnInit {
    public potvrde: Confirmation[] = [];
    constructor(
        public dialog: MatDialog,
        private toastr: ToastrService,
        private confirmationService: ConfirmationService,
        private certificateRequestService: CertificateRequestService,
        @Inject(MAT_DIALOG_DATA) public data: any
    ) {}

    ngOnInit(): void {
        this.confirmationService
            .getConfirmationsByJMBG(this.data.zahtev.jmbg)
            .subscribe((potvrde) => (this.potvrde = potvrde));
    }

    handleAccept = () => {
        this.certificateRequestService
            .accept({
                uuid: this.data.zahtev.uuid,
                reason: '',
            })
            .subscribe(() => {
                this.dialog.closeAll();
                this.toastr.success('Zahtev uspešno prihvaćen.');
            });
    };

    handleReject = () => {
        this.dialog.open(ReasonForRejectionComponent, {
            width: '40%',
        });
    };
}
