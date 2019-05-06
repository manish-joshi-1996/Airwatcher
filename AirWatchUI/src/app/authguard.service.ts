import { Injectable } from "@angular/core";
import { CanActivate } from '@angular/router';
import { Router } from '@angular/router';
import { AuthenticationService } from './modules/authentication/authentication.service';

@Injectable()
export class AuthGuardService implements CanActivate{
    constructor(private route:Router,private authservice:AuthenticationService){

    }
    canActivate(){
        if(!this.authservice.isTokenExpired()){
            return true;
        }
        this.route.navigate(['/login']);
        return false;
    }
}

