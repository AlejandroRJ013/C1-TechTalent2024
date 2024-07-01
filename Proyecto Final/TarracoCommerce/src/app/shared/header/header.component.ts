import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './header.component.html',
  styles: `
  img {
    margin-right: 5px;
  }
  input:focus {
    outline: none;
  }
  #header {
    position: fixed;
    top: 0;
    left: 0;
    background-color:  #1D1D1D;
    width: 100%;
    // background: linear-gradient(to right, #1D1D1D 15%, #252422 45% 55%, #1D1D1D 85%);
    display: flex;
  }
  #empresa > a{
    text-decoration: none;
  }
  #empresa > p{
    margin-top: 0;
  }
  #superior {
    display: grid;
    grid-template-columns: 1fr 2fr;
    align-items: center;
  }
  #inferior {
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
  #superior > div {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  #superior > div > a {
    text-decoration: none;
  }
  #header > div {
    display: flex;
    flex-direction: column;
    width: 100%;
    margin-left: 25px;
    margin-right: 25px;
  }
  #logoEslogan > p {
    margin: 5px;
    margin-top: -5px;
  }
  #inferior > div {
    display: flex;
    justify-content: center;
    align-content: center;
    padding: 5px;
    padding-left: 10px;
    padding-right: 10px;
  }
  #inferior > div > a {
    color: white;
    text-decoration: none;
    text-transform: uppercase;
  }
  .alante {
    justify-self: flex-start;
  }
  .atras {
    justify-self: flex-end;
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 15px;
  }
  .imagenTexto {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 5px;
    margin-top: 0;
    margin-bottom: 0;
    color: #fff;
  }
  .dorado {
    color: #B4916C;
  }
  .desplegable {
    position: relative;
  }
  .desplegable:hover .elementos-desplegable {
    display: grid;
    gap: 10px;
  }
  .elementos-desplegable {
    display: none;
    position: absolute;
    background: linear-gradient(#444 90%, #fff); // CAMBIAR
    z-index: 1;
    top: 100%;
    left: 0;
  }
  .barraBusqueda {
    display: flex;
    flex-wrap: nowrap;
    background: linear-gradient(#FBEFD5, #E2C092);
    overflow: hidden;
    border-radius: 30px;
  }
  .transparente {
    background-color: transparent;
    height: 40px;
    border: 0;
  }
  #inferior > .bordes {
    border-left: 1px solid #fff;
    border-right: 1px solid #fff;
  }
  .primero {
    border-left: 0;
  }
  .ultimo {
    border-right: 0;
  }
  `,
})
export class HeaderComponent {}
