import { Component, OnInit, Input } from '@angular/core';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';

@Component({
    selector: 'app-document-table',
    templateUrl: './document-table.component.html',
    styleUrls: ['./document-table.component.less'],
})
export class DocumentTableComponent implements OnInit {
    @Input() public documents: any[] = [];
    public displayedColumns: string[] = ['name', 'view', 'download'];
    constructor(private interesovanjeService : InteresovanjeService) {}
    ngOnInit(): void {}

    viewDoc(docName : string){
        let [documentType, documentName] = docName.split("/");
        console.log(documentType, documentName);
        window.open(
            `http://localhost:8080/api/${documentType}/xhtml/${documentName}`,
            '_blank'
        );

    }

    downloadDoc(docName : string){
        console.log("downloading " + docName);
        //TODO
    }

}
