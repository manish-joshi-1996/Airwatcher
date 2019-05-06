import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AirwatchService } from '../../airwatch.service';
import { Airwatch } from '../../airwatch';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  useWatchlistApi=true;
  cities:Array<Airwatch>;
 

  constructor(private airwatchservice:AirwatchService,private snackbar:MatSnackBar) { 
    this.cities = [];
  }

  ngOnInit() {
    this.airwatchservice.getWatchlistedCity().subscribe(cities=>{
    this.cities.push(...cities);
    });

  }
  deletefromWatchList(city){
    let message = ` deleted from WatchList`;
  
    for(var i=0;i<this.cities.length;i++){
      if(this.cities[i].city===city.city)
      {
        this.cities.splice(i,1);
      }
    }

    this.airwatchservice.deleteCityFromWatchlist(city).subscribe(city=>{
      this.snackbar.open("city deleted from watchlist",'',{
        duration:1000

});
});

  }
}

