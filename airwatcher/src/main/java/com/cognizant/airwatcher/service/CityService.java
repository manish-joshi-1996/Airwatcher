package com.cognizant.airwatcher.service;

import java.util.List;

import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.exception.CityAlreadyExistsException;
import com.cognizant.airwatcher.exception.CityNotFoundException;

public interface CityService {

	boolean saveCity(City city) throws CityAlreadyExistsException;
	boolean deleteCityById(int id) throws CityNotFoundException;
	
	List<City> getMyCities(String userId);
	City getCityByUserIdAndCity(String userId,String city);

}
