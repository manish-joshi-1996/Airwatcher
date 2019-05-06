import { Component } from '@angular/core';
import { AuthenticationService } from './modules/authentication/authentication.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AirWatchUI';
  loggedInState:Observable<boolean>;
  userName:any;
  constructor(private router:Router,private authService:AuthenticationService){}
  ngOnInit(){
    this.loggedInState=this.authService.isLoggedIn;
  //   if(localStorage.getItem("userId")){
  //     this.userName=localStorage.getItem("userId");
  //   }
   }

  logout() {
    this.authService.deleteToken();
    this.router.navigate(['/login']);
  }

}
