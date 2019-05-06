import { Component, OnInit } from '@angular/core';
import { Airwatch } from '../../airwatch';
import { AirwatchService } from '../../airwatch.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-thumbnail',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {
  
countries:Array<Airwatch>;
  constructor(private airwatchService:AirwatchService,private routes:Router) { 
    this.countries=[];
  }
  ngOnInit() {
    this.airwatchService.getCountries().subscribe((countries)=>{
      
    this.countries.push(...countries);
 

    }
    )};
    

}
