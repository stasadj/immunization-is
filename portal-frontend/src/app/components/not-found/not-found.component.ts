import { Component, OnInit } from '@angular/core';
import { InteresovanjeService } from 'src/app/services/interesovanje.service';

@Component({
    selector: 'app-not-found',
    templateUrl: './not-found.component.html',
    styleUrls: ['./not-found.component.less'],
})
export class NotFoundComponent implements OnInit {
    constructor() {}

    ngOnInit(): void {}
}
