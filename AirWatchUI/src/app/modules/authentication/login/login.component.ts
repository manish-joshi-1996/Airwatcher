import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { user } from '../User';
import { HttpErrorResponse } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:user = new user();
  constructor(private authService:AuthenticationService,private router:Router,private snackBar:MatSnackBar) {

   }

  ngOnInit() {
  }
  loginUser(){
    this.authService.loginUser(this.user).subscribe(data=>{
      if(data['token']){
        this.authService.setToken(data['token']);
        this.router.navigate(['/airwatch']);
      }},
      (error:HttpErrorResponse)=>{
        this.snackBar.open("Wrong Credentials",'',{
          duration:1000
  
        });

      })
    
    }
  }
  
