import { Component, OnInit } from '@angular/core';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';

import { saveAs } from 'file-saver';

@Component({
    selector: 'app-not-found',
    templateUrl: './not-found.component.html',
    styleUrls: ['./not-found.component.less'],
})
export class NotFoundComponent implements OnInit {
    constructor(private interesovanjeS: InteresovanjeService) {}

    ngOnInit(): void {}

    foo() {
        this.interesovanjeS
            .getPDF('2312999850013.xml')
            .subscribe((res: any) => {
                this.onReturnedDocument(
                    res,
                    'application/pdf;charset=utf-8',
                    'a.pdf'
                );
            });
    }

    display(): void {
        window.open(
            `http://localhost:8080/api/interesovanje/xhtml/Albert.Makan3879`,
            '_blank'
        );
    }

    onReturnedDocument(res: any, type: string, filename: string): void {
        let blob = new Blob([res], { type: type });
        saveAs(blob, filename);
    }
}
