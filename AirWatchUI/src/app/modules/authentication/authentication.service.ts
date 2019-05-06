import { HttpClient } from '@angular/common/http'
export const TOKEN_NAME:string = "jwt_token";
import * as jwt_decode from 'jwt-decode';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';


@Injectable({
    providedIn:'root'
  })
export class AuthenticationService{
    springEndPoint: string;
    token:string;
    private loggedInState: BehaviorSubject<boolean>=new BehaviorSubject<boolean>(false);
    get isLoggedIn(){
        if(localStorage.getItem(TOKEN_NAME)!=null){
            this.loggedInState.next(true);
        }
        return this.loggedInState.asObservable();
        }
    constructor(private httpClient:HttpClient){
this.springEndPoint="http://localhost:8089/api/v1/userservice";
    }
    registerUser(newuser){
        const url=this.springEndPoint+"/register";
        console.log('newuser',newuser);
        return this.httpClient.post(url,newuser,{responseType:'text'});
    }
    loginUser(newuser){
        const url=this.springEndPoint+"/login";
        this.loggedInState.next(true);
        return this.httpClient.post(url,newuser);
        
    }
    setToken(token:string)
    {
        return localStorage.setItem(TOKEN_NAME,token);
    }
    getToken()
    {
        return localStorage.getItem(TOKEN_NAME);
    }
    deleteToken()
    {
        this.loggedInState.next(false);
        return localStorage.removeItem(TOKEN_NAME);
    }
    getTokenExpirationDate(token: string) {
        const decoded = jwt_decode(token);
        if(decoded.exp === undefined) {
          return null;
        }
        const date = new Date(0);
        date.setUTCSeconds(decoded.exp);
        return date;
      }
      isTokenExpired(token?: string): boolean {
        if(!token) {
          token = this.getToken();
        }
        if(!token) {
          return true;
        }
        const date = this.getTokenExpirationDate(token);
        if(date === undefined || date === null) {
          return false;
        }
        return !(date.valueOf() > new Date().valueOf());
      }
    
}
