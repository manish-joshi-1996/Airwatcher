import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { AirwatchService } from './airwatch.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CitiesComponent } from './components/cities/cities.component';
import {MatDialogModule} from '@angular/material/dialog';
import { AirwatchRoutingModule } from './airwatch-router.module';
import { LoaderComponent } from './components/loader/loader.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { TokenInterceptor } from '../authentication/interceptor.service';
import { WatchlistComponent } from './components/watchlist/watchlist.component';
import { CountryComponent } from './components/country/country.component';
import { StateComponent } from './components/state/state.component';

@NgModule({
  declarations: [CountryComponent,StateComponent,CitiesComponent,LoaderComponent,WatchlistComponent],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    MatDialogModule,
    AirwatchRoutingModule,
    MatSnackBarModule
   
  ],
  exports:[CountryComponent,StateComponent,CitiesComponent,LoaderComponent,WatchlistComponent],
  providers:[AirwatchService,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }
  ]
})
export class AirwatchModule { }
