import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { EventosComponent } from './pages/eventos/eventos.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ContactoComponent } from './pages/contacto/contacto.component';
import { ComerciosComponent } from './pages/comercios/comercios.component';

export const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'eventos', component: EventosComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'contacto', component: ContactoComponent },
  { path: 'comercios', component: ComerciosComponent },
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
