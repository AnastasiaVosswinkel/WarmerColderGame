package com.example.demo.model;

public class City {

	String name;
	String searchterm;
	double temperature;
	String photo;
	String country;
	String fullCountryName;
	String countryPopulation;
	String countrySubregion;
	String currencies;
	String countryFlag;
	
	
	
	

	

	public City(String name, String searchterm, double temperature, String photo, String country,
			String fullCountNyname, String countrypopulation, String countrySubregion, String currencies,
			String countryFlag) {
		super();
		this.name = name;
		this.searchterm = searchterm;
		this.temperature = temperature;
		this.photo = photo;
		this.country = country;
		this.fullCountryName = fullCountNyname;
		this.countryPopulation = countrypopulation;
		this.countrySubregion = countrySubregion;
		this.currencies = currencies;
		this.countryFlag = countryFlag;
	}
	public City(String name, String searchterm, double temperature, String photo, String country,
			String countrypopulation) {
		super();
		this.name = name;
		this.searchterm = searchterm;
		this.temperature = temperature;
		this.photo = photo;
		this.country = country;
		this.countryPopulation = countrypopulation;
	}
	public City(String name, String searchterm, double temperature, String photo, String country) {
		super();
		this.name = name;
		this.searchterm = searchterm;
		this.temperature = temperature;
		this.photo = photo;
		this.country = country;
	}
	public City() {
		super();
	}
	public City(String name, String searchterm) {
		super();
		this.name = name;
		this.searchterm = searchterm;
	}
	public City(String name, String searchterm, double temperature, String photo_url) {
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

	
	
	
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo_url) {
		this.photo = photo_url;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(String countrypopulation) {
		this.countryPopulation = countrypopulation;
	}
	public String getFullCountryName() {
		return fullCountryName;
	}
	public void setFullCountryName(String fullCountNyname) {
		this.fullCountryName = fullCountNyname;
	}
	public String getCountrySubregion() {
		return countrySubregion;
	}
	public void setCountrySubregion(String countrySubregion) {
		this.countrySubregion = countrySubregion;
	}
	public String getCurrencies() {
		return currencies;
	}
	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}
	public String getCountryFlag() {
		return countryFlag;
	}
	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}
	
}
