import { Injectable } from '@angular/core';
import { HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
 } from '@angular/common/http';
import {  AuthenticationService } from '../authentication/authentication.service';
import { Observable } from 'rxjs';


@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private auth: AuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // console.log('In token interceptor');
     if(request.url.includes("api/v1")){
    request = request.clone({
      setHeaders: {
        Authorization: `Bearer ${this.auth.getToken()}`
      }
    });
   }
    return next.handle(request);
  }
}
