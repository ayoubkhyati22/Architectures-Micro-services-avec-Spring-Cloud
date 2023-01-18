import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  private baseUrl = 'http://localhost:8889/BILLING-SERVICE/';

  constructor(private http:HttpClient) { }

  createBill(bill: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'addbill', bill);
  }
}
