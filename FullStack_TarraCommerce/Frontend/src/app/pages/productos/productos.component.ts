import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProductosCategorizadosComponent } from './productos-categorizados/productos-categorizados.component';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [RouterLink, ProductosCategorizadosComponent],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css',
})
export class ProductosComponent {
  categoria: string = '';

  cambiarCat(cat: string): void {
    this.categoria = cat;
  }
}

/*

import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { IProductos } from '../../interfaces/productos';
import { ProductosService } from '../../servicios/service-productos.service';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css',
})
export class ProductosComponent implements OnInit {
  public productosList: IProductos[] = [];

  constructor(private productosService: ProductosService) {}

  ngOnInit(): void {
    this.productosService
      .getProductos()
      .subscribe((data) => (this.productosList = data));
  }
}

*/
