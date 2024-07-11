import { Component, AfterViewInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css'],
})
export class InicioComponent implements AfterViewInit {
  slideIndex: number = 0;
  cantDinero: number = 0;

  showDivs() {
    const slides = document.getElementsByClassName(
      'imageneSlider'
    ) as HTMLCollectionOf<HTMLElement>;
    const dots = document.getElementsByClassName(
      'puntos'
    ) as HTMLCollectionOf<HTMLElement>;

    for (let i = 0; i < slides.length; i++) {
      slides[i].style.display = 'none';
    }
    for (let i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(' blanco', '');
    }

    this.slideIndex++;
    if (this.slideIndex > slides.length) {
      this.slideIndex = 1;
    }
    slides[this.slideIndex - 1].style.display = 'block';
    dots[this.slideIndex - 1].className += ' blanco';
  }

  carousel() {
    this.showDivs();
    setTimeout(() => this.carousel(), 5000); // Cambia la imagen cada 5 segundos
  }

  moverImg(n: number) {
    this.slideIndex += n - 1;
    const slides = document.getElementsByClassName('imageneSlider');
    if (this.slideIndex >= slides.length) {
      this.slideIndex = 0;
    }
    if (this.slideIndex < 0) {
      this.slideIndex = slides.length - 1;
    }
    this.showDivs();
  }

  mostrarImg(n: number) {
    this.slideIndex = n - 1;
    this.showDivs();
  }

  ngAfterViewInit() {
    this.carousel();
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
    this.cantDinero = parseFloat(dinero); // Asegúrate de convertir a número si es necesario
    const mostrarValor = document.getElementById('mostrarValor');
    if (mostrarValor) {
      mostrarValor.textContent = dinero;
    }
  }
}
