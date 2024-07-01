import { Component, ViewEncapsulation } from '@angular/core';
import { RouterLink } from '@angular/router'; // Hay que poner esto para que funcionen los routerLinks

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink], // Hay que poner esto para que funcionen los routerLinks
  // FALTA REPETIR EL PROCESO EN LOS DEMÁS
  templateUrl: './header.component.html',
  encapsulation: ViewEncapsulation.None,
  styles: `
    #header {
      background-color: #1D1F1E;
      color: #fff;
      padding: 10px 20px;
      display: grid;
      grid-template-rows: 1fr 1fr;
    }
    #superior {
      display: grid;
      grid-template-columns: 2fr 1fr 1fr;
      gap: 50px;
    }
    #inferior {
      display: flex;
      justify-content: end;
      height: 50px;
    }
    #imgTitul {
      display: flex;
      align-items: center;
      justify-content: start;
    }
    .search-bar {
      background: linear-gradient(#FBEFD5, #E2C092);
      overflow: hidden;
      border-radius: 30px;
    }
    img {
      width: 50px;
      align-self: start;
    }
    nav {
      padding: 10px;
      display: flex;
      justify-content: end;
      align-items: center;
      position: relative;
    }
    nav a, .menu-item a {
      color: #fff;
      text-decoration: none;
      width: 100px;
    }
    .transparente {
      background-color: transparent;
      height: 40px;
      border: 0;
    }
    .menu-item {
      position: relative;
      height: 100%;
    }
    .desplegable {
      display: none;
      position: absolute;
      background: linear-gradient(#444 90%, #fff); // CAMBIAR
      box-shadow: 0px 8px 16px rgba(0,0,0,0.2);
      z-index: 1;
      top: 100%;
      left: 0;
    }
    .menu-item:hover .desplegable {
      display: block;
    }
    .desPro, .desCom {
      width: 150px;
    }
    .desplegable a {
      display: block;
      padding: 8px 16px;
      text-decoration: none;
      color: white;
    }
    .desplegable a:hover {
      background-color: #ddd;
    }
    .bordes {
      border-right: 1px solid #ccc;
      border-left: 1px solid #ccc;
      padding: 5px;
      height: 100%;
    }
  `,
})
export class HeaderComponent {}
