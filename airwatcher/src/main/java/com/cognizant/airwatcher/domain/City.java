package com.cognizant.airwatcher.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	@Column(name="aqius") 
	private String aqius;
	@Column(name="aqicn")
	private String aqicn;
	@Column(name="user_id")
	private String userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAqius() {
		return aqius;
	}
	public void setAqius(String aqius) {
		this.aqius = aqius;
	}
	public String getAqicn() {
		return aqicn;
	}
	public void setAqicn(String aqicn) {
		this.aqicn = aqicn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", aqius=" + aqius
				+ ", aqicn=" + aqicn + ", userId=" + userId + "]";
	}
	public City(int id, String city, String state, String country, String aqius, String aqicn, String userId) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.aqius = aqius;
		this.aqicn = aqicn;
		this.userId = userId;
	}
	public City() {
		super();
	}
	
	

	

}
