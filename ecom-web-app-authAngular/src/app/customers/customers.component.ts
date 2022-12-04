import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers:any;

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8889/CUSTOMER-SERVICE/customers").subscribe({
      next: (data)=>{
        this.customers=data;
      },
      error: (err)=>{}
    });
  }

  getBills(c: any){
    this.router.navigateByUrl("/bills/"+c.id);
  }

}
