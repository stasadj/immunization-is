import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInteresovanjeComponent } from './components/create-interesovanje/create-interesovanje.component';
import { CreateZahtevComponent } from './components/create-zahtev/create-zahtev.component';
import { GradjaninDocumentsComponent } from './components/gradjanin-documents/gradjanin-documents.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { PatientFormComponent } from './components/patient-form/patient-form.component';
import { GradjaninPageComponent } from './pages/gradjanin-page/gradjanin-page.component';

const routes: Routes = [
    // { path: 'create-interesovanje', component: CreateInteresovanjeComponent },
    // { path: 'create-zahtev', component: CreateZahtevComponent },
    {
        path: 'gradjanin',
        component: GradjaninPageComponent,
        children: [
            {
                path: 'create-interesovanje',
                component: CreateInteresovanjeComponent,
            },
            {
                path: 'create-zahtev',
                component: CreateZahtevComponent,
            },
            {
                path: 'gradjanin-documents',
                component: GradjaninDocumentsComponent,
            },
        ],
    },
    { path: 'register', component: PatientFormComponent },
    { path: 'login', component: LoginComponent },
    { path: '**', component: NotFoundComponent },
    // { path: 'gradjanin-documents', component: GradjaninDocumentsComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
