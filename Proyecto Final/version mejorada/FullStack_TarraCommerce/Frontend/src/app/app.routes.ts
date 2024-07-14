import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { AboutComponent } from './pages/about/about.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ArtesaniaManualidadesComponent } from './pages/artesania-manualidades/artesania-manualidades.component';
import { ProductosCategorizadosComponent } from './pages/productos-categorizados/productos-categorizados.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';

export const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'about', component: AboutComponent },
  { path: 'productos', component: ProductosComponent },
  {
    path: 'productos/artesania-y-manualidades',
    component: ProductosCategorizadosComponent,
  },
  { path: 'usuarios', component: UsuariosComponent },
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
