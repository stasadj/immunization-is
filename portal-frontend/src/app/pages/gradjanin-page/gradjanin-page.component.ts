import { Component, OnInit, Output } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { GradjaninService } from 'src/app/services/gradjanin.service';

@Component({
    selector: 'app-gradjanin-page',
    templateUrl: './gradjanin-page.component.html',
    styleUrls: ['./gradjanin-page.component.less'],
})
export class GradjaninPageComponent implements OnInit {

    public documents = null;
    public loggedUser = null;

    constructor(private gradjaninService: GradjaninService, private authService: AuthService){
        this.authService.whoAmI().subscribe((res) => {
            console.log(res);
            this.loggedUser = res;
        })

        this.gradjaninService.getDocs().subscribe(res => {
            console.log(res);
            this.documents = res;
        })
        
    }
    ngOnInit(): void {
        
    }
}
