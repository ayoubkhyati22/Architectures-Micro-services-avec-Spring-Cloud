import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';
import { Bill } from '../model/bill';
import { BillService } from '../services/bill.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']
})
export class AddbillComponent implements OnInit {

  products:any;
  customers:any;

  bill: Bill = new Bill();

  billFormGroup!: FormGroup;

  constructor(private http:HttpClient, private productService: ProductService, private fb: FormBuilder, private billService: BillService) { }

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

    // Form
    this.billFormGroup=this.fb.group({
      customerID  : this.fb.control(""),
      productIDs  : this.fb.control("")
    });

  }

  pids:number[]=[];

  test(obj:any,product:any){
    if ( obj.target.checked ) {
      if(!this.pids.includes(product.id))
      this.pids.push(product.id)
      console.log(this.pids)
 }
  }

  saveBill(){
    this.bill=new Bill();
    this.bill.customerID=this.billFormGroup.value.customerID;
    this.bill.billingDate="2022-12-18T11:21:42.404+00:00";
    this.bill.productIDs=this.pids;

    console.log(this.bill);
    this.save();
  }

  save() {
    this.billService.createBill(this.bill)
      .subscribe({
        next: (data)=>{
          Swal.fire(
            'Bill Added Successfully!',
            'You clicked the button!',
            'success'
          )
          this.ngOnInit();
        },
        error: (err)=>{
          console.log(err)
        }
      });
    this.bill = new Bill();
  }

}
