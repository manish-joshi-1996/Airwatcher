package com.cognizant.airwatcher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.airwatcher.domain.City;


public interface CityRepository extends JpaRepository<City, Integer> {
	List<City> findByUserId(String userId);
	City findByUserIdAndCity(String userId, String city);
}
