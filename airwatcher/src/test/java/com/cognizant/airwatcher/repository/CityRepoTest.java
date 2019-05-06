package com.cognizant.airwatcher.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.repository.CityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class CityRepoTest {
	
	/**
	 * 
	 */
	@Autowired
	private transient CityRepository repository;
	
	/**
	 * @param repository
	 */
	public void setRepo(final CityRepository repository){
		this.repository = repository;
	}
	/**
	 * 
	 */
	public CityRepoTest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testSaveCity() throws Exception{
		City savedCity = repository.save(new City(1, "Gaya","Bihar","India","15","16", "john123"));
		final City city = repository.getOne(savedCity.getId());
		assertThat(city.getId()).isEqualTo(savedCity.getId());
	
	}
	
	/**
	 * @throws Exception
	 */

	
	@Test
	public void testDeleteCity() throws Exception{
		City savedCity=repository.save(new City(1, "Gaya","Bihar","India","15","16", "john123"));
		final City city=repository.getOne(savedCity.getId());
		assertEquals(city.getCity(),"Gaya");
		
		repository.delete(city);
		
		assertEquals(Optional.empty(),repository.findById(savedCity.getId()));
		
	}
	
	

	/**
	 * @throws Exception
	 */
	@Test
	public void testGetMyCities() throws Exception{
		repository.save(new City(1, "Gaya","Bihar","India","15","16", "john123"));
		repository.save(new City(2,"Chandigarh", "Punjab", "India","15","16","john123"));
		
		final List<City> cities = repository.findByUserId("John123");
		assertEquals(cities.get(0).getCity(),"Gaya");
		

	}	

}

