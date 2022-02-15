import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateVaccineAmountComponent } from './components/update-vaccine-amount/update-vaccine-amount.component';

const routes: Routes = [
    { path: 'vaccine-amount', component: UpdateVaccineAmountComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
