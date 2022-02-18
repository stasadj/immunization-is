import { Component, OnInit, Input } from '@angular/core';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';
import { saveAs } from 'file-saver';
import { DocumentService } from 'src/app/services/document-service';

@Component({
    selector: 'app-document-table',
    templateUrl: './document-table.component.html',
    styleUrls: ['./document-table.component.less'],
})
export class DocumentTableComponent implements OnInit {
    @Input() public documents: any[] = [];
    public displayedColumns: string[] = [
        'name',
        'open as XHTML',
        'open as PDF',
        'download XHTML',
        'download PDF',
    ];
    constructor(
        private documentService: DocumentService
    ) {}
    ngOnInit(): void {}

    viewDoc(docName: string, format: string) {
        let [documentType, documentName] = docName.split('/');
        console.log(documentType, documentName);
        window.open(
            `http://localhost:8080/api/${documentType}/${format}/${documentName}`,
            '_blank'
        );
    }

    downloadDoc(fullDocName: string, documentFormat: string) {
        let [documentType, documentName] = fullDocName.split('/');
        this.documentService
            .getFile(documentName, documentFormat, documentType)
            .subscribe((res: any) => {
                this.onReturnedDocumentForDownload(
                    res,
                    `application/${documentFormat};charset=utf-8`,
                    `a.${documentFormat}`
                );
            });
    }

    onReturnedDocumentForDownload(
        res: any,
        type: string,
        filename: string
    ): void {
        let blob = new Blob([res], { type: type });
        saveAs(blob, filename);
    }
}
