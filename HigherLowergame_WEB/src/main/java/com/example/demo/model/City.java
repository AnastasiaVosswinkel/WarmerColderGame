package com.example.demo.model;

public class City {

	String name;
	String searchterm;
	String temperature;
	String photo;
	

	
	public City() {
		super();
	}
	public City(String name, String searchterm) {
		super();
		this.name = name;
		this.searchterm = searchterm;
	}
	public City(String name, String searchterm, String temperature, String photo_url) {
		super();
		this.name = name;
		this.searchterm = searchterm;
		this.temperature = temperature;
		this.photo = photo_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearchterm() {
		return searchterm;
	}
	public void setSearchterm(String searchterm) {
		this.searchterm = searchterm;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo_url) {
		this.photo = photo_url;
	}
	
	
	
}
