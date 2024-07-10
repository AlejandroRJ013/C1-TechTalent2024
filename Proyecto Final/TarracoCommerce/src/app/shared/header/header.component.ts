import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './header.component.html',
  styles: `
  img {
    margin-right: 0.5vw;
  }
  button:hover {
    cursor: pointer;
  }
  input:focus {
    outline: none;
  }
  #header {
    background-color:  #1b1b1b;
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    position: sticky;
    top: 0;
    z-index: 10;
    justify-content: space-between;
  }
  #empresa {
    width: 22vw;
  }
  #empresa > a {
    text-decoration: none;
  }
  #empresa > p {
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
    flex-wrap: wrap;
    padding-right: 1.5vw;
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
    // width: 100%;
    // background-color: #fff;
    margin-left: 0.2vw;
    margin-right: 0.2vw;
  }
  #logoEslogan > p {
    margin: 2vw;
    margin-top: -2vw;
  }
  #inferior > div {
    display: flex;
    justify-content: center;
    align-content: center;
    padding: 0.5vh;
    padding-left: 1.2vw;
    padding-right: 1.2vw;
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
    gap: 2vw;
  }
  .imagenTexto {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 0.5vw;
    margin-top: 0;
    margin-bottom: 0;
    color: #fff;
  }
  .dorado {
    color: #d4af37;
  }
  .desplegable {
    position: relative;
  }
  .desplegable:hover .elementos-desplegable-categorias {
    display: grid;
    grid-template-rows: repeat(5, 1fr);
    grid-auto-flow: column;
    grid-auto-columns: 1fr;
    grid-auto-flow: column;
    column-gap: 0.2vw;
  }
  .desplegable:hover .elementos-desplegable-comercios {
    display: grid;
    grid-template-rows: repeat(3, 1fr);
    grid-auto-flow: column;
    grid-auto-columns: 1fr;
    grid-auto-flow: column;
    column-gap: 0.2vw;
  }
  .elementos-desplegable-categorias,
  .elementos-desplegable-comercios {
    display: none;
    position: absolute;
    background-color: black;
    justify-content: stretch;
    align-content: stretch;
    z-index: 1;
    top: 100%;
    left: 0;
  }
  .elementos-desplegable-categorias > div,
  .elementos-desplegable-comercios > div {
    background-color: #7b7b7b;
    padding: 1vw;
  }
  .elementos-desplegable-categorias > div > a,
  .elementos-desplegable-comercios > div > a {
    color: white;
    text-decoration: none;
    text-wrap: nowrap;
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
    height: 5vh;
    border: 0;
  }
  .bordeD {
    border-right: 1px solid #fff;
    width: 6vw;
  }
  .bordeI {
    border-left: 1px solid #fff;
    width: 6vw;
  }
  `,
})
export class HeaderComponent {}
