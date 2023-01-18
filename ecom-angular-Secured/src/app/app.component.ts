import { Component } from '@angular/core';
import { SecurityService } from './services/security.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularFront';
  constructor(public securityService:SecurityService){}
  onLogout() {
    this.securityService.kcService.logout( 
      window.location.origin
    )
 }

 async login(){
   await this.securityService.kcService.login({
     redirectUri:window.location.origin
   })
   
 }
}
