import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MatFormFieldModule, MatError } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { AuthenticationRoutingModule } from './authentication-router.module';
import { FormsModule } from '@angular/forms';
import { AuthenticationService } from './authentication.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    AuthenticationRoutingModule,
    FormsModule
  ],
    providers:[AuthenticationService],
    exports:[RegisterComponent,LoginComponent,AuthenticationRoutingModule]
})
export class AuthenticationModule { }
