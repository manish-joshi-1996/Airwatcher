import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from '../authentication.service';
import { user } from '../User';
import { HttpErrorResponse } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
newUser:user;
  constructor(private authService:AuthenticationService,  private router:Router,private snackBar:MatSnackBar) {
    this.newUser=new user();
   }

  ngOnInit() {

  }
  registerUser(){
    this.authService.registerUser(this.newUser).subscribe(
      (data) =>{
      this.router.navigate(['/login']);
    },
    (error:HttpErrorResponse)=>{
      this.snackBar.open("UserId Already Exists",'',{
        duration:1000

});
      if(error instanceof Error){
      }
      // this.snackBar.open("UserId already Exists");
      else
      {
          console.log("Server Side Error"+JSON.stringify(error));
      }
  });

  }

}
