import { Injectable } from '@angular/core';
import {
  Auth,
  signInWithPopup,
  GoogleAuthProvider,
  FacebookAuthProvider,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
} from '@angular/fire/auth';
import { Firestore, doc, setDoc, getDoc } from '@angular/fire/firestore';
import { Observable, of } from 'rxjs';
import { User } from 'firebase/auth';
import { IUsuarios } from '../interfaces/usuarios';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  user$: Observable<IUsuarios | null>;

  constructor(private afAuth: Auth, private firestore: Firestore) {
    this.user$ = new Observable<IUsuarios | null>((observer) => {
      const unsubscribe = this.afAuth.onAuthStateChanged(async (user) => {
        if (user) {
          const userData = await this.getUserData(user.uid);
          observer.next(userData);
        } else {
          observer.next(null);
        }
      });

      return { unsubscribe };
    });
  }

  private async getUserData(uid: string): Promise<IUsuarios | null> {
    const userRef = doc(this.firestore, `users/${uid}`);
    const userDoc = await getDoc(userRef);
    return userDoc.exists() ? (userDoc.data() as IUsuarios) : null;
  }

  async googleSignin() {
    const provider = new GoogleAuthProvider();
    const credential = await signInWithPopup(this.afAuth, provider);
    return this.updateUserData(credential.user);
  }

  async facebookSignin() {
    const provider = new FacebookAuthProvider();
    const credential = await signInWithPopup(this.afAuth, provider);
    return this.updateUserData(credential.user);
  }

  async emailSignUp(email: string, password: string, nombre: string) {
    const credential = await createUserWithEmailAndPassword(
      this.afAuth,
      email,
      password
    );
    return this.updateUserData({ ...credential.user, displayName: nombre });
  }

  async emailSignIn(email: string, password: string) {
    const credential = await signInWithEmailAndPassword(
      this.afAuth,
      email,
      password
    );
    return this.updateUserData(credential.user);
  }

  private async updateUserData(user: User) {
    const userRef = doc(this.firestore, `users/${user.uid}`);
    const data: IUsuarios = {
      uid: user.uid,
      nombre: user.displayName || 'Anonimo',
      correo: user.email || '',
      emailVerified: user.emailVerified || false,
    };

    this.setCookie('user', JSON.stringify(data), 1); // Guardar en cookies por 1 día

    return setDoc(userRef, data, { merge: true });
  }

  async signOut() {
    await this.afAuth.signOut();
  }

  private setCookie(name: string, value: string, days: number) {
    let expires = '';
    if (days) {
      const date = new Date();
      date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
      expires = '; expires=' + date.toUTCString();
    }
    document.cookie = name + '=' + (value || '') + expires + '; path=/';
  }
}
