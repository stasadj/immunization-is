import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-document-table',
  templateUrl: './document-table.component.html',
  styleUrls: ['./document-table.component.less']
})
export class DocumentTableComponent implements OnInit {

    @Input() public documents : any[] = [];
    public displayedColumns: string[] = ['name', 'view', 'download'];
    constructor() {}
  ngOnInit(): void {
  }

}
