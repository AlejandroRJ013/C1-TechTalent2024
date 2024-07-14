import {
  Component,
  OnInit,
  AfterViewInit,
  Input,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { CommonModule } from '@angular/common';
import { IProductos } from '../../../interfaces/productos';
import { ProductosService } from '../../../servicios/service-productos.service';

@Component({
  selector: 'app-productos-categorizados',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './productos-categorizados.component.html',
  styleUrl: './productos-categorizados.component.css',
})
export class ProductosCategorizadosComponent implements OnInit, AfterViewInit {
  cantDinero: number = 0;
  public productosList: IProductos[] = [];

  constructor(private productoService: ProductosService) {}

  ngOnInit(): void {
    this.productoService
      .getProductos()
      .subscribe((data) => (this.productosList = data));
  }

  ngAfterViewInit() {
    this.initSlider();
  }

  initSlider() {
    const input = document.getElementById(
      'filtroDinero'
    ) as HTMLInputElement | null;
    if (input) {
      input.addEventListener('input', () => this.mostrarDinero(input));
    }
  }

  mostrarDinero(input: HTMLInputElement) {
    const dinero = input.value;
    this.cantDinero = parseFloat(dinero);
    const mostrarValor = document.getElementById('mostrarValor');
    if (mostrarValor) {
      mostrarValor.textContent = dinero;
    }
  }

  @Input() categoriaRecibida!: string;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['categoriaRecibida']) {
      this.categoriaRecibida = changes['categoriaRecibida'].currentValue;
    }
  }
}
