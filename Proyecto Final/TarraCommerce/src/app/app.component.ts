import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './shared/header/header.component';
import { Header2Component } from './shared/header2/header2.component';
import { FooterComponent } from './shared/footer/footer.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { EventosComponent } from './pages/eventos/eventos.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ContactoComponent } from './pages/contacto/contacto.component';
import { ComerciosComponent } from './pages/comercios/comercios.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    Header2Component,
    InicioComponent,
    EventosComponent,
    ProductosComponent,
    ContactoComponent,
    ComerciosComponent,
    FooterComponent,
  ],
  templateUrl: './app.component.html',

  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'TarraCommerce';
}
