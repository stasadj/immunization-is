import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReasonForRejectionComponent } from '../reason-for-rejection/reason-for-rejection.component';

@Component({
    selector: 'app-response',
    templateUrl: './response.component.html',
    styleUrls: ['./response.component.less'],
})
export class ResponseComponent implements OnInit {
    constructor(public dialog: MatDialog) {}

    ngOnInit(): void {}

    handleReject = () => {
        this.dialog.open(ReasonForRejectionComponent, { width: '30%' });
    };
}
