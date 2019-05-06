import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AirwatchService } from '../../airwatch.service';
import { ActivatedRoute } from '@angular/router';
import { Airwatch } from '../../airwatch';

@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})

export class CitiesComponent implements OnInit {


@Input()
 useWatchlistApi:boolean;
 @Output()
 addCity=new EventEmitter();

  newCity:Airwatch;

  @Input()
  cities:Array<Airwatch>;
  @Output()
  deleteCity=new EventEmitter();

  constructor() {
    this.newCity = new Airwatch();
    }

  ngOnInit() {
  
    }
    addToWatchList(data){
      this.newCity.city = data.city;
      this.newCity.country = data.country;
      this.newCity.state = data.state;
      this.newCity.aqicn = data.current.pollution.aqicn
      this.newCity.aqius= data.current.pollution.aqius
      this.addCity.emit(this.newCity);
    
    }

    deletefromWatchList(data){
      this.deleteCity.emit(data)
  
  }
    
    
  }

  