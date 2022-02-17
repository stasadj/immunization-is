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
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

import { ToastrModule } from 'ngx-toastr';
import { VaccineReportComponent } from './components/vaccine-report/vaccine-report.component';
import { UpdateVaccineAmountComponent } from './components/update-vaccine-amount/update-vaccine-amount.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { XmlContentInterceptor } from './interceptors/xml-content.interceptor';
import { HandleErrorInterceptor } from './interceptors/handle-error.interceptor';
import { ImmunizationReportComponent } from './components/immunization-report/immunization-report.component';
import { CertificateIssuingComponent } from './components/certificate-issuing/certificate-issuing.component';

@NgModule({
    declarations: [
        AppComponent,
        UpdateVaccineAmountComponent,
        VaccineReportComponent,
        LoginComponent,
        NotFoundComponent,
        ImmunizationReportComponent,
        CertificateIssuingComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatCardModule,
        FormsModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatCheckboxModule,
        MatSelectModule,
        MatDialogModule,
        MatTableModule,
        MatIconModule,
        MatButtonModule,
        HttpClientModule,
        ToastrModule.forRoot(),
        MatDatepickerModule,
        MatNativeDateModule,
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
