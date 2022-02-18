import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-gradjanin-documents',
    templateUrl: './gradjanin-documents.component.html',
    styleUrls: ['./gradjanin-documents.component.less'],
})
export class GradjaninDocumentsComponent implements OnInit {
    @Input() public gradjaninDocuments = {ZAHTEV: [], INTERESOVANJE: [], POTVRDA: [], SAGLASNOST:[], SERTIFIKAT: []};
    public displayedColumns: string[] = ['name', 'view', 'download'];
    constructor() {}

    ngOnInit(): void {}
}
