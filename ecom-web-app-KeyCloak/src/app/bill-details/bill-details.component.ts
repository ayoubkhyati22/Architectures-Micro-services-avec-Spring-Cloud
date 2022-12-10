import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-bill-details',
  templateUrl: './bill-details.component.html',
  styleUrls: ['./bill-details.component.css']
})
export class BillDetailsComponent implements OnInit {

  billDetails:any;
  billID!:any;

  constructor(private http:HttpClient, private router:Router, private route:ActivatedRoute) {
    this.billID=route.snapshot.params['billID'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8889/BILLING-SERVICE/fullBill/"+this.billID).subscribe({
      next: (data)=>{
        this.billDetails=data;
      },
      error: (err)=>{}
    });
  }

  getBillDetails(b: any){
    this.router.navigateByUrl("/bill-details/"+b.id);
  }

}
