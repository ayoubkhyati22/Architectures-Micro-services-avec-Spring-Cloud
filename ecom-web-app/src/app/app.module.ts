import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';

import {HttpClientModule} from '@angular/common/http';
import { CustomersComponent } from './customers/customers.component';
import { BillsComponent } from './bills/bills.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddbillComponent } from './addbill/addbill.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';



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
    ProductsComponent,
    CustomersComponent,
    BillsComponent,
    BillDetailsComponent,
    AddbillComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    KeycloakAngularModule,
  ],
  providers: [{provide : APP_INITIALIZER, deps : [KeycloakService], useFactory : kcFactory, multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
