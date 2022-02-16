import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';

import { ToastrModule } from 'ngx-toastr';

import { CreateInteresovanjeComponent } from './components/create-interesovanje/create-interesovanje.component';
import { CreateZahtevComponent } from './components/create-zahtev/create-zahtev/create-zahtev.component';

@NgModule({
    declarations: [
        AppComponent,
        CreateInteresovanjeComponent,
        CreateZahtevComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        MatCardModule,
        FormsModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatCheckboxModule,
        MatSelectModule,
        BrowserAnimationsModule,
        HttpClientModule,
        ToastrModule.forRoot()
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
