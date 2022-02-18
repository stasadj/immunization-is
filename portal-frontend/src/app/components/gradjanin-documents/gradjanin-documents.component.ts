import { Component, OnInit, Input } from '@angular/core';
import { GradjaninService } from 'src/app/services/gradjanin.service';

@Component({
    selector: 'app-gradjanin-documents',
    templateUrl: './gradjanin-documents.component.html',
    styleUrls: ['./gradjanin-documents.component.less'],
})
export class GradjaninDocumentsComponent implements OnInit {
    public documents = {ZAHTEV: [], INTERESOVANJE: [], POTVRDA: [], SAGLASNOST:[], SERTIFIKAT: []};
    public displayedColumns: string[] = ['name', 'view', 'download'];
    constructor(private gradjaninService: GradjaninService) {}

    ngOnInit(): void {
        this.gradjaninService.getDocs().subscribe((res) => {
            console.log(res);
            this.documents = res;
        });
    }
}
