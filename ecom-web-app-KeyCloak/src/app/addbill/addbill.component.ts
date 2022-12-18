import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Bill } from '../model/bill';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-addbill',
  templateUrl: './addbill.component.html',
  styleUrls: ['./addbill.component.css']
})
export class AddbillComponent implements OnInit {

  products:any;
  customers:any;

  bill: Bill = new Bill();

  billFormGroup!: FormGroup;

  constructor(private http:HttpClient, private productService: ProductService, private fb: FormBuilder,) { }

  ngOnInit(): void {
     // GET PRODUCTS
     this.http.get("http://localhost:8889/INVENTORY-SERVICE/products").subscribe({
      next: (data)=>{
        this.products=data;
      },
      error: (err)=>{}
    });
    //END GET PRODUCTS

    this.http.get("http://localhost:8889/CUSTOMER-SERVICE/customers").subscribe({
      next: (data)=>{
        this.customers=data;
      },
      error: (err)=>{}
    });

  }

  saveBill(){

  }

}
