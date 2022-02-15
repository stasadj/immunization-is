import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VaccineReportComponent } from './components/vaccine-report/vaccine-report.component';

const routes: Routes = [
    { path: 'vaccines', component: VaccineReportComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
