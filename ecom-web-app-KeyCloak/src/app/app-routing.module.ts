import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddbillComponent } from './addbill/addbill.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import { BillsComponent } from './bills/bills.component';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [
  {
    path:"products", component : ProductsComponent
  },
  {
    path:"customers", component : CustomersComponent
  },
  {
    path:"bills/:customerID", component : BillsComponent
  },
  {
    path:"bill-details/:billID", component : BillDetailsComponent
  },
  {
    path:"addbill" , component : AddbillComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
