package com.cognizant.airwatcher.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.airwatcher.controller.CityController;
import com.cognizant.airwatcher.domain.City;
import com.cognizant.airwatcher.service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {
	@Autowired
	private transient MockMvc mvc;
	@MockBean
	private transient CityService service;
	
	private transient City city;
	@InjectMocks
	private CityController controller;
	
	static List<City> cities;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mvc=MockMvcBuilders.standaloneSetup(controller).build();
		cities=new ArrayList<>();
		city = new City(1, "Gaya","Bihar","India","15","16", "john123");
		cities.add(city);
		city = new City(2,"Chandigarh", "Punjab", "India","15","16","john123");
		cities.add(city);

	}
	@Test
	public void testSaveNewCitySuccess() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huMTIzIiwiaWF0IjoxNTUzNTQyODYyfQ.ZgHiu2lRsXYeUDrKPkplLhFOXG1v1tZViWu6uYFfPec";
		
		when(service.saveCity(city)).thenReturn(true);
		mvc.perform(post("/api/v1/cityservice/city").header("authorization", "Bearer " + token).
				contentType(MediaType.APPLICATION_JSON).content(jsonToString(city)))
		.andExpect(status().isCreated());
		verify(service, times(1)).saveCity(Mockito.any(City.class));
		verifyNoMoreInteractions(service);
	}
	@Test
	public void testDeleteCityById() throws Exception{
		when(service.deleteCityById(1)).thenReturn(true);
		mvc.perform(delete("/api/v1/cityservice/city/{id}", 1)).andExpect(status().isOk());
		verify(service, times(1)).deleteCityById(1);
		verifyNoMoreInteractions(service);

	}
	@Test
	public void testGetMyMovies() throws Exception {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huMTIzIiwiaWF0IjoxNTUzNTQyODYyfQ.ZgHiu2lRsXYeUDrKPkplLhFOXG1v1tZViWu6uYFfPec";
		when(service.getMyCities("john123")).thenReturn(null);
		mvc.perform(get("/api/v1/cityservice/cities").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(service, times(1)).getMyCities("john123");
		verifyNoMoreInteractions(service);
	}

	
	
	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}

}
