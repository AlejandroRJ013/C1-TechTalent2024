import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-header2',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './header2.component.html',
  styles: `
  #header {
    background-color: #1D1F1E;
    display: grid;
    grid-template-columns: 20% 80%;
    gap: 80px;

  }
  #logoEslogan {
    justify-self: flex-start;
    display: grid;
    grid-template-rows: 1fr 0.5fr;
  }
  #derecha {
    display: grid;
    grid-template-rows: 1fr 1fr;
    margin-right: 10px;
    width: 100%;
  }
  #superior {
    display: grid;
    grid-template-columns: 200px 200px 200px;
    gap: 10px;
    width: 100%;
    align-self: center;
    justify-items: center;
  }
  #superior > * {
    padding: 5px;
  }
  #superior > *:hover {
    border-radius: 5px;
    background-color: #cdcdf5;
  }
  .imagenTexto {
    display: flex;
    align-items: center;
    justify-content: start;
    color: white;
  }
  .imagenTexto > img {
    margin-right: 5px;
  }
  .dorado {
    color: #94592D;
  }
  `,
})
export class Header2Component {}
