import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule} from "@angular/forms";
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';
import { HomeComponent } from './home/home.component';
import { BillsComponent } from './bills/bills.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import { AddbillComponent } from './add-bill/add-bill.component';



export function kcFactory(kcSecService : KeycloakService){
  return ()=>{
  kcSecService.init({
  config : {
  url : "http://localhost:8080",
  realm : "ecom-realm",
  clientId : "ecom-client"
  },
  loadUserProfileAtStartUp : true,
  initOptions : {
  onLoad : 'check-sso',
  checkLoginIframe : true
  }
  });
  }
  }
@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    ProductsComponent,

    HomeComponent,
    BillsComponent,
    BillDetailsComponent,
    AddbillComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [{provide : APP_INITIALIZER, deps : [KeycloakService], useFactory : kcFactory, multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
