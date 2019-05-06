package com.cognizant.airwatcher.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.exception.CityAlreadyExistsException;
import com.cognizant.airwatcher.exception.CityNotFoundException;
import com.cognizant.airwatcher.repository.CityRepository;


@Service
public class CityServiceImpl implements CityService {
	private final transient CityRepository cityRepo;
	@Autowired
	public CityServiceImpl(final CityRepository cityRepo) {
		super();
		this.cityRepo = cityRepo;
		}

	@Override
	public boolean saveCity(City city) throws CityAlreadyExistsException {
		final City object = cityRepo.findByUserIdAndCity(city.getUserId(),city.getCity());
		if(object !=null) {
			throw new CityAlreadyExistsException("City Already Exist");	
		}
		cityRepo.save(city);
		return true;
	}

	@Override
	public boolean deleteCityById(int id) throws CityNotFoundException {
		final City city=cityRepo.findById(id).orElse(null);
		if(city == null) {
			throw new CityNotFoundException("Movie Not Found");
		}
		cityRepo.delete(city);
		return true;
	}

	@Override
	public List<City> getMyCities(String userId) {
		return cityRepo.findByUserId(userId);
	}

	@Override
	public City getCityByUserIdAndCity(String userId, String city) {
		
		return cityRepo.findByUserIdAndCity(userId, city);
	}

}
