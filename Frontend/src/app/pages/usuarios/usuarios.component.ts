import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IUsuarios } from '../../interfaces/usuarios';
import { UsuarioService } from '../../servicios/service-usuario.service';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './usuarios.component.html',
  styleUrl: './usuarios.component.css',
})
export class UsuariosComponent implements OnInit {
  public usuariosList: IUsuarios[] = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService
      .getUsuarios()
      .subscribe((data) => (this.usuariosList = data));
  }
}
