import { Component, OnInit, Input } from '@angular/core';
import { Airwatch } from '../../airwatch';
import { AirwatchService } from '../../airwatch.service';
import { ActivatedRoute } from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit {
  @Input()
  cities:Array<Airwatch>;
 @Input()
 useWatchlistApi:boolean;
 
 Data:Array<any>;
 city:Array<any>;
  
 state:Airwatch;
  constructor(private airwtchservice:AirwatchService,private router:ActivatedRoute,private snackBar:MatSnackBar)  {
    this.state=new Airwatch(),
     this.cities=[],
     this.Data=[]
   }

  ngOnInit() {
    this.state.country = this.router.snapshot.params["cname"];
    this.state.state = this.router.snapshot.params["sname"];
   this.getCityInfo(this.state);
    }
    getCityInfo(state){
      this.airwtchservice.getCities(state).subscribe((res)=>{
        res.forEach(element => {
          element.country=state.country;
          element.state=state.state;
          this.cities.push(element);
          this.airwtchservice.getCityData(element).subscribe(data=>{
          
            this.Data.push(data);
                    })
        })
        
      });
  }
  
  addCityToWatchList(city){
    this.airwtchservice.saveWatchlistCity(city).subscribe(city=>{
         this.snackBar.open("City added to watchlist",'',{
           duration:1000

  });
})
  }
 
}
