import { Component, OnInit, Input } from '@angular/core';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';
import { saveAs } from 'file-saver';


@Component({
    selector: 'app-document-table',
    templateUrl: './document-table.component.html',
    styleUrls: ['./document-table.component.less'],
})
export class DocumentTableComponent implements OnInit {
    @Input() public documents: any[] = [];
    public displayedColumns: string[] = ['name', 'open as XHTML', 'open as PDF', 'download XHTML'];
    constructor(private interesovanjeService : InteresovanjeService) {}
    ngOnInit(): void {}

    viewDoc(docName : string, format: string){
        let [documentType, documentName] = docName.split("/");
        console.log(documentType, documentName);
        window.open(
            `http://localhost:8080/api/${documentType}/${format}/${documentName}`,
            '_blank'
        );

    }

    downloadDoc(docName : string){
        // let [documentType, documentName] = docName.split("/");
        // this.interesovanjeService
        //     .getPDF('2312999850013.xml')
        //     .subscribe((res: any) => {
        //         this.onReturnedDocument(
        //             res,
        //             'application/pdf;charset=utf-8',
        //             'a.pdf'
        //         );
        //     });
    }

    onReturnedDocumentForDownload(res: any, type: string, filename: string): void {
        let blob = new Blob([res], { type: type });
        saveAs(blob, filename);
    }


}
