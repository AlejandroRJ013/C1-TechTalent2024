import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../servicios/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styles: ``,
})
export class LoginComponent implements OnInit {
  ngOnInit() {
    console.log('LoginComponent cargado');
  }

  email: string = '';
  password: string = '';
  nombre: string = '';

  // constructor(private authService: AuthService) {}

  // async onLogin() {
  //   try {
  //     await this.authService.emailSignIn(this.email, this.password);
  //     alert('Inicio de sesión exitoso');
  //   } catch (error) {
  //     alert('Error al iniciar sesión');
  //   }
  // }

  // async onSignup() {
  //   try {
  //     await this.authService.emailSignUp(
  //       this.email,
  //       this.password,
  //       this.nombre
  //     );
  //     alert('Registro exitoso');
  //   } catch (error) {
  //     alert('Error al registrarse');
  //   }
  // }

  // async onGoogleSignIn() {
  //   try {
  //     await this.authService.googleSignin();
  //     alert('Inicio de sesión con Google exitoso');
  //   } catch (error) {
  //     alert('Error al iniciar sesión con Google');
  //   }
  // }

  // async onFacebookSignIn() {
  //   try {
  //     await this.authService.facebookSignin();
  //     alert('Inicio de sesión con Facebook exitoso');
  //   } catch (error) {
  //     alert('Error al iniciar sesión con Facebook');
  //   }
  // }
}
