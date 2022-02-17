import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ResponseComponent } from '../response/response.component';

@Component({
    selector: 'app-certificate-requests',
    templateUrl: './certificate-requests.component.html',
    styleUrls: ['./certificate-requests.component.less'],
})
export class CertificateRequestsComponent implements OnInit {
    constructor(public dialog: MatDialog) {}

    ngOnInit(): void {}

    handleRespond = () => {
        this.dialog.open(ResponseComponent, { width: '50%' });
    };
}
