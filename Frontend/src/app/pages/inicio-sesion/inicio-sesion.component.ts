import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../servicios/auth.service';

@Component({
  selector: 'app-inicio-sesion',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './inicio-sesion.component.html',
  styleUrl: './inicio-sesion.component.css',
})
export class InicioSesionComponent {
  email: string = '';
  password: string = '';
  nombre: string = '';

  constructor(private authService: AuthService) {}

  async onLogin() {
    try {
      await this.authService.emailSignIn(this.email, this.password);
      alert('Inicio de sesión exitoso');
    } catch (error) {
      alert('Error al iniciar sesión: ');
    }
  }

  async onSignup() {
    try {
      await this.authService.emailSignUp(
        this.email,
        this.password,
        this.nombre
      );
      alert('Registro exitoso');
    } catch (error) {
      alert('Error al registrarse: ');
    }
  }

  async onGoogleSignIn() {
    try {
      await this.authService.googleSignin();
      alert('Inicio de sesión con Google exitoso');
    } catch (error) {
      alert('Error al iniciar sesión con Google: ');
    }
  }

  async onFacebookSignIn() {
    try {
      await this.authService.facebookSignin();
      alert('Inicio de sesión con Facebook exitoso');
    } catch (error) {
      alert('Error al iniciar sesión con Facebook: ');
    }
  }
}
