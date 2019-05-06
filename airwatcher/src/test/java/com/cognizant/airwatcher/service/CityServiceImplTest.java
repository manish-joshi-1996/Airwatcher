package com.cognizant.airwatcher.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.exception.CityAlreadyExistsException;
import com.cognizant.airwatcher.exception.CityNotFoundException;
import com.cognizant.airwatcher.repository.CityRepository;



public class CityServiceImplTest {

	@Mock
	private transient CityRepository cityrepo;
	 
	private transient City city;
	
	@InjectMocks
	private transient CityServiceImpl cityServiceImpl;
	
	transient Optional<City> options; 
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		city=new City(1,"Gaya","Bihar","India","15","16","john123");
		options=Optional.of(city);
	}
	@Test
	public void testMockCreation() {
		assertNotNull(city);
		assertNotNull("JpaRepository creation failed: use @InjectMocks on movieServiceImpl", cityrepo);
	}
	@Test
	public void testSaveCitySuccess() throws CityAlreadyExistsException{
		when(cityrepo.save(city)).thenReturn(city);
		final boolean flag=cityServiceImpl.saveCity(city);
		assertTrue("saving movie failed", flag);
		verify(cityrepo,times(1)).save(city);
	}
//	@Test(expected=CityAlreadyExistsException.class)
//	public void testSaveCityFailure() throws CityAlreadyExistsException{
//		when(cityrepo.findById(1)).thenReturn(options);
//		when(cityrepo.save(city)).thenReturn(city);
//		final boolean flag = cityServiceImpl.saveCity(city);
//		assertFalse("saving movie failed", flag);
//		verify(cityrepo, times(1)).save(city);
//	}
	@Test
	public void testDeleteMCityById() throws CityNotFoundException{
		when(cityrepo.findById(1)).thenReturn(options);
		doNothing().when(cityrepo).delete(city);
		final boolean flag=cityServiceImpl.deleteCityById(1);
		assertTrue("deleting failed",flag);
		verify(cityrepo,times(1)).delete(city);
		verify(cityrepo,times(1)).findById(city.getId());
	}
	@Test
	public void testGetAllCities() throws CityNotFoundException{
		final List<City> cityList=new ArrayList<>(1);
		when(cityrepo.findByUserId("ashu")).thenReturn(cityList);
		final List<City> movies1=cityServiceImpl.getMyCities("ashu");
		assertEquals(cityList,movies1);
		verify(cityrepo,times(1)).findByUserId("ashu");
	}
	
}
