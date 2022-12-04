import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import { BillsComponent } from './bills/bills.component';
import { CustomersComponent } from './customers/customers.component';
import { AuthenticationGuard } from './guards/authentication.guard';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [
  {
    path:"login", component : LoginComponent
  },
  {
    path:"", component : LoginComponent
  },

  {
    path:"admin", component : AdminTemplateComponent, canActivate : [AuthenticationGuard],
     children : [
      {
        path:"products", component : ProductsComponent
      },
      {
        path:"customers", component : CustomersComponent
      },

    ]
  },

  {
    path:"bills/:customerID", component : BillsComponent
  },
  {
    path:"bill-details/:billID", component : BillDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
