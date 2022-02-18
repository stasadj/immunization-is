import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';


import { ToastrModule } from 'ngx-toastr';

import { CreateInteresovanjeComponent } from './components/create-interesovanje/create-interesovanje.component';
import { CreateZahtevComponent } from './components/create-zahtev/create-zahtev.component';
import { PatientFormComponent } from './components/patient-form/patient-form.component';
import { LoginComponent } from './components/login/login.component';
import { XmlContentInterceptor } from './interceptors/xml-content.interceptor';
import { HandleErrorInterceptor } from './interceptors/handle-error.interceptor';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { GradjaninPageComponent } from './pages/gradjanin-page/gradjanin-page.component';
import { GradjaninDocumentsComponent } from './components/gradjanin-documents/gradjanin-documents.component';
import { DocumentTableComponent } from './components/gradjanin-documents/document-table/document-table.component';

@NgModule({
    declarations: [
        AppComponent,
        CreateInteresovanjeComponent,
        CreateZahtevComponent,
        PatientFormComponent,
        LoginComponent,
        NotFoundComponent,
        GradjaninPageComponent,
        GradjaninDocumentsComponent,
        DocumentTableComponent,
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
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatTabsModule,
        BrowserAnimationsModule,
        HttpClientModule,
        ToastrModule.forRoot(),
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: XmlContentInterceptor,
            multi: true,
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: HandleErrorInterceptor,
            multi: true,
        },
    ],
    bootstrap: [AppComponent],
})
export class AppModule {}
