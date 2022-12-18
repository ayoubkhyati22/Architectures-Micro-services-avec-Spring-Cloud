import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import Swal from 'sweetalert2'



@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {


  products: any;

  product: Product = new Product();

  productFormGroup!: FormGroup;

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

    this.productFormGroup=this.fb.group({
      name     : this.fb.control(""),
      price    : this.fb.control(""),
      quantity : this.fb.control("")
    });

  }



  // SAVE PRODUCT
  saveProduct(){
    this.product=new Product();
    this.product.name    =this.productFormGroup.value.name    ;
    this.product.price   =this.productFormGroup.value.price   ;
    this.product.quantity=this.productFormGroup.value.quantity;
    this.save();
  }

  save() {
    this.productService.createProduct(this.product)
      .subscribe({
        next: (data)=>{
          Swal.fire(
            'Product Added Successfully!',
            'You clicked the button!',
            'success'
          )
          this.ngOnInit();
        },
        error: (err)=>{
          console.log(err)
        }
      });
    this.product = new Product();
  }
  //END SAVE PRODUCT

  // DELETE PRODUCT BY ID
  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
    .subscribe({
      next: (data)=>{
        Swal.fire(
          'Product Removed !',
          'You clicked the button!',
          'success'
        )
        this.ngOnInit();
      },
      error: (err)=>{
        console.log(err)
      }
    });
  }
  //END DELETE PRODUCT BY ID

}
