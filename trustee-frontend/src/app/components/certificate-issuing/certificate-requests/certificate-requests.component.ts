import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CertificateRequest } from 'src/app/model/CertificateRequest';
import { CertificateRequestService } from 'src/app/services/certificate-request-service';
import { ResponseComponent } from '../response/response.component';

@Component({
    selector: 'app-certificate-requests',
    templateUrl: './certificate-requests.component.html',
    styleUrls: ['./certificate-requests.component.less'],
})
export class CertificateRequestsComponent implements OnInit {
    public zahtevi: CertificateRequest[] = [];
    constructor(
        public dialog: MatDialog,
        private certificateRequestsService: CertificateRequestService
    ) {}

    ngOnInit(): void {
        this.certificateRequestsService
            .getPendingRequests()
            .subscribe((zahtevi) => (this.zahtevi = zahtevi));
    }

    handleRespond = () => {
        this.dialog.open(ResponseComponent, { width: '50%' });
    };
}
