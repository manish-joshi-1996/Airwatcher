import { Routes, RouterModule } from "@angular/router";
import { NgModule } from '@angular/core';
import { LoaderComponent } from './components/loader/loader.component';
import { AuthGuardService } from '../../authguard.service';
import { WatchlistComponent } from './components/watchlist/watchlist.component';
import { CountryComponent } from './components/country/country.component';
import { StateComponent } from './components/state/state.component';

const airwatchRoutes:Routes=[
    {
            path:'airwatch',
            children:[
                {
                path:'',
              component:CountryComponent,
             canActivate:[AuthGuardService]
                },
                {
                    path:'watchlist',
                    component:WatchlistComponent,
                    canActivate:[AuthGuardService]
                },                
                {
                    path:':cname',
                    component:StateComponent,
                    canActivate:[AuthGuardService]
                },
                {
                    path:':cname/:sname',
                    component:LoaderComponent,
                    canActivate:[AuthGuardService]
                }
            ]
           
        }
    ];
    @NgModule({
        imports: [RouterModule.forChild(airwatchRoutes)],
        exports: [RouterModule]
      })
      export class AirwatchRoutingModule { }
      