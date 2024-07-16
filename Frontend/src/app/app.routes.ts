import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { AboutComponent } from './pages/about/about.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ProductosCatComponent } from './pages/productos-cat/productos-cat.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { LoginComponent } from './pages/login/login.component';
import { InicioSesionComponent } from './pages/inicio-sesion/inicio-sesion.component';

export const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'about', component: AboutComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'productosCat/:categoria/:nombre', component: ProductosCatComponent },
  { path: 'login', component: LoginComponent },
  { path: 'sesion', component: InicioSesionComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'inicio', redirectTo: '', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
