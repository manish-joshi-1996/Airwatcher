package com.cognizant.airwatcher.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.exception.CityAlreadyExistsException;
import com.cognizant.airwatcher.exception.CityNotFoundException;
import com.cognizant.airwatcher.service.CityService;


import io.jsonwebtoken.Jwts;


@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/cityservice")
public class CityController {
@Autowired
public CityService cityService;
public CityController(final CityService cityService) {
	super();
	this.cityService = cityService;
}


@PostMapping("/city")
public ResponseEntity<?> saveNewCity(@RequestBody City city, HttpServletRequest request, HttpServletResponse response ){
	ResponseEntity<?> responseEntity;
	final String authHeader = request.getHeader("authorization");
	final String token = authHeader.substring(7);
	String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
	try {
		city.setUserId(userId);
		cityService.saveCity(city);
		responseEntity=new ResponseEntity<City>(city,HttpStatus.CREATED);
	}
	catch(CityAlreadyExistsException e){
		responseEntity=new ResponseEntity<String>("{ \"message\": \""+e.getMessage()+"\"}",HttpStatus.CONFLICT);
		
	}
	return responseEntity;
}
@DeleteMapping(path="/city/{id}")

	public ResponseEntity<?> deleteMovie(@PathVariable("id") final Integer id){
	ResponseEntity<?> responseEntity;
	try {
		cityService.deleteCityById(id);
		responseEntity=new ResponseEntity<String>("Removed City Successfully",HttpStatus.OK);
	}
	catch(CityNotFoundException e){
		responseEntity=new ResponseEntity<String>("{ \"message\": \""+e.getMessage()+"\"}",HttpStatus.CONFLICT);
		
	}
	return responseEntity;
		
	}

@GetMapping("/cities")
public @ResponseBody ResponseEntity<List<City>> fetchMyCities(final ServletRequest req,final ServletResponse res){
	final HttpServletRequest request = (HttpServletRequest) req;
	final String authHeader = request.getHeader("authorization");
	final String token = authHeader.substring(7);
	String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
	return new ResponseEntity<List<City>>(cityService.getMyCities(userId),HttpStatus.OK);
}

}
