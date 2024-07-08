import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './footer.component.html',
  styles: `
  #footer {
    text-align: center;
    background-color: #96663D;
    color: #fff;
    padding: 10px;
  }
  `,
})
export class FooterComponent {}
