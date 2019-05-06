import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {  AirwatchModule } from './modules/airwatch/airwatch.module';
import {MatToolbarModule,MatToolbar} from '@angular/material/toolbar';
import {MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { AirwatchRoutingModule } from './modules/airwatch/airwatch-router.module';
import { WatchlistComponent } from './modules/airwatch/components/watchlist/watchlist.component';
import { LoaderComponent } from './modules/airwatch/components/loader/loader.component';;
import { RegisterComponent } from './modules/authentication/register/register.component';
import { LoginComponent } from './modules/authentication/login/login.component'
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { AuthGuardService } from './authguard.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AirwatchRoutingModule,
    AuthenticationModule,
    AirwatchModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
