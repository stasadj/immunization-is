import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CertificateRequestsComponent } from './components/certificate-issuing/certificate-requests/certificate-requests.component';
import { ImmunizationReportComponent } from './components/immunization-report/immunization-report.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { VaccineReportComponent } from './components/vaccine-report/vaccine-report.component';

const routes: Routes = [
    { path: 'vaccines', component: VaccineReportComponent },
    { path: 'login', component: LoginComponent },
    { path: 'immunization-report', component: ImmunizationReportComponent },
    { path: 'certificate-issuing', component: CertificateRequestsComponent },
    { path: '**', component: NotFoundComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
