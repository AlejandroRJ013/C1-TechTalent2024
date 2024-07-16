import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { IProductos } from '../interfaces/productos';

@Injectable({
  providedIn: 'root',
})
export class ProductosService implements OnInit {
  private _dataUrl: string =
    'https://tarracomerce-default-rtdb.europe-west1.firebasedatabase.app/productos.json';
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  getProductos(): Observable<IProductos[]> {
    return this.http.get<IProductos[]>(this._dataUrl);
  }
}
