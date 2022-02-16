import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInteresovanjeComponent } from './components/create-interesovanje/create-interesovanje.component';
import { CreateZahtevComponent } from './components/create-zahtev/create-zahtev/create-zahtev.component';

const routes: Routes = [
    { path: 'create-interesovanje', component: CreateInteresovanjeComponent },
    { path: 'create-zahtev', component: CreateZahtevComponent },

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
