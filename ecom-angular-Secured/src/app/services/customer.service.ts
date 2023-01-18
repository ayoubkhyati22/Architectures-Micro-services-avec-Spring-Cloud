import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8889/CUSTOMER-SERVICE/';

  constructor(private http:HttpClient) { }

  createCustomer(customer: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'addcustomer', customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deletecustomer/${id}`, { responseType: 'text' });
  }
}
