import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInteresovanjeComponent } from './create-interesovanje/create-interesovanje.component';

const routes: Routes = [
    { path: 'create-interesovanje', component: CreateInteresovanjeComponent },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
