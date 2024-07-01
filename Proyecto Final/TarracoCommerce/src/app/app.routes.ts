import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';

export const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  //   { path: 'portfolio', component: PortfolioComponent },
  //   { path: 'terminos', component: TerminosComponent },
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
