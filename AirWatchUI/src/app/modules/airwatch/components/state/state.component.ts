import { Component, OnInit, Input } from '@angular/core';
import { AirwatchService } from '../../airwatch.service';
import { Airwatch } from '../../airwatch';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-container',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.css']
})
export class StateComponent implements OnInit {
  country:string;
  states:Array<Airwatch>;

  constructor(private airwatchservice:AirwatchService ,private router:ActivatedRoute ) { }

  ngOnInit() {
    this.country=this.router.snapshot.params["cname"]
   
         this.airwatchservice.getStates(this.country).subscribe((res)=>{
          
               this.states=res;
             
             }
             )
       };
}
