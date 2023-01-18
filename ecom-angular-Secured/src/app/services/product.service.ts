import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8889/INVENTORY-SERVICE/';

  constructor(private http:HttpClient) { }

  createProduct(product: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'addproduct', product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteproduct/${id}`, { responseType: 'text' });
  }

}
