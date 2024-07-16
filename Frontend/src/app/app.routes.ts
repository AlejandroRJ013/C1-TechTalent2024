import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { AboutComponent } from './pages/about/about.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ProductosCatComponent } from './pages/productos-cat/productos-cat.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';

export const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'about', component: AboutComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'productosCat/:categoria/:nombre', component: ProductosCatComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
