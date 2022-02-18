import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-gradjanin-page',
    templateUrl: './gradjanin-page.component.html',
    styleUrls: ['./gradjanin-page.component.less'],
})
export class GradjaninPageComponent implements OnInit {
    public documents = null;
    public loggedUser = null;
    public navLinks: any[];
    public activeLinkIndex = -1;

    constructor(private router: Router) {
        this.navLinks = [
            {
                label: 'Interesovanje za imunizaciju',
                link: '/gradjanin/create-interesovanje',
                index: 0,
            },
            {
                label: 'Podnošenje zahteva za sertifikat',
                link: '/gradjanin/create-zahtev',
                index: 1,
            },
            {
                label: 'Podnošenje saglasnosti za imunizacijom',
                link: '/gradjanin/create-saglasnost',
                index: 2,
            },
            {
                label: 'Moji dokumenti',
                link: '/gradjanin/gradjanin-documents',
                index: 3,
            }
        ];
    }
    ngOnInit(): void {
        this.router.events.subscribe((res) => {
            this.activeLinkIndex = this.navLinks.indexOf(
                this.navLinks.find((tab) => tab.link === '.' + this.router.url)
            );
        });
    }
}
