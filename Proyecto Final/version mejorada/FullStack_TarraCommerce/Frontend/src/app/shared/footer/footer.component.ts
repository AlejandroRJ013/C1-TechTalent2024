import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './footer.component.html',
  styles: [
    `
      footer {
        text-align: center;
        background-color: #96663d;
        color: #fff;
        padding: 1em 1em;
      }
    `,
  ],
})
export class FooterComponent {}
