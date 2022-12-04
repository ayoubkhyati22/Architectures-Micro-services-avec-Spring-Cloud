import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {

  bills:any;
  customerID!:any;

  constructor(private http:HttpClient, private router:Router, private route:ActivatedRoute) {
    this.customerID=route.snapshot.params['customerID'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8889/BILLING-SERVICE/bills/search/byCustomerID?projection=fullBill&customerID="+this.customerID).subscribe({
      next: (data)=>{
        this.bills=data;
      },
      error: (err)=>{}
    });
  }

  getBillDetails(b: any){
    this.router.navigateByUrl("/bill-details/"+b.id);
  }
}
