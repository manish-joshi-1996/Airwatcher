import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Airwatch } from './airwatch';
@Injectable({
    providedIn: 'root'
})

export class AirwatchService {
    airvisualEndPoint: string;
    apikey: string;
    springEndpoint: string;
    constructor(private httpClient: HttpClient) {
        this.airvisualEndPoint = 'https://api.airvisual.com/v2/';
        this.apikey = 'key=SvGacyX6BtX86z2BG';
        this.springEndpoint = 'http://localhost:8080/api/v1/cityservice/'

    }
    getCountries(): Observable<Array<Airwatch>> {
        const countries = this.airvisualEndPoint + "countries?" + this.apikey;
        return this.httpClient.get(countries).pipe(
            map(this.pickResults));
    }

    getStates(country: string): Observable<Array<Airwatch>> {
        const states = this.airvisualEndPoint + "states?country=" + country + "&" + this.apikey;
        console.log(states);
        return this.httpClient.get(states).pipe(
            map(this.pickResults));
    }
    getCities(state: Airwatch): Observable<Array<Airwatch>> {
        const cities = this.airvisualEndPoint + "cities?state=" + state.state + "&country=" + state.country + "&" + this.apikey;
        return this.httpClient.get(cities).pipe(
            map(this.pickResults));
    }
    getCityData(city: Airwatch): Observable<any> {
        const cityDataUrl = this.airvisualEndPoint + "city?city=" + city.city + "&state=" + city.state + "&country=" + city.country + "&" + this.apikey;
        return this.httpClient.get(cityDataUrl).pipe(
            map(this.pickResults));
    }
    pickResults(response) {
        return response['data'];
    }
    saveWatchlistCity(city: Airwatch) {
        return this.httpClient.post<Airwatch>(this.springEndpoint + 'city', city);
    }
    getWatchlistedCity(): Observable<Array<Airwatch>> {
        console.log("in watchlisted service")
        return this.httpClient.get<Array<Airwatch>>(this.springEndpoint + 'cities');

    }
    deleteCityFromWatchlist(city: Airwatch) {
        const delUrl = `${this.springEndpoint}city/${city.id}`;
        return this.httpClient.delete(delUrl, { responseType: 'text' });
    }
}