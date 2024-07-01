import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './inicio.component.html',
  styles: `
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    background-color: #292727;
  }
  .container {
    max-width: 1200px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  .product {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 20px;
  }
  .product-item {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
  }
  .product-item img {
    max-width: 100%;
    height: auto;
  }
  .product-item h2 {
    font-size: 1.2rem;
    margin: 10px 0;
  }
  .product-item p {
    color: #888;
  }
  .product-item button {
    background-color: #4caf50;
    color: #fff;
    border: none;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 10px 0;
    cursor: pointer;
    border-radius: 5px;
  }
  .product-item button:hover {
    background-color: #45a049;
  }
  `,
})
export class InicioComponent {}
