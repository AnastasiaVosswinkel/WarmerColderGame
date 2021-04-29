package com.example.demo.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.PhotoClient;
import com.example.demo.client.WeatherClient;
import com.example.demo.model.City;
import com.example.demo.model.weather.Weather;
import com.example.demo.сonst.Const;

@Service
public class CityService {
	
	static Logger log = LoggerFactory.getLogger(CityService.class);
	private String[][] cityList = Const.CITY_SEARCHTERM_LIST;
	@Autowired
	private WeatherClient weatherClient;
	@Autowired
	private PhotoClient photoClient;
	
	public City createCity(String[] nameandsearchterm) {
		String name = nameandsearchterm[0];
		String searchterm = nameandsearchterm[1];
		
		
		City city = new City(name, searchterm);
		Weather weather = weatherClient.createWeather(name);
		double temperature = Math.round(weather.getMain().getTemp()*10) /10.0;
		city.setTemperature(temperature);
		
		String photo_url = photoClient.createPhotoURL(name + " " + searchterm);
		city.setPhoto(photo_url);
		
		return city;
	}
	
	public City getRandomCityOtherThan(String notThisCity) {
		City city = new City();
		Random random = new Random();
		int randomInt = random.nextInt(cityList.length);
		String[] nameAndSearchTerm = cityList[randomInt]; 
		while (notThisCity.equals(nameAndSearchTerm[0])) {
			randomInt = random.nextInt(cityList.length);
			nameAndSearchTerm = cityList[randomInt]; 
		}
		
		try {city = createCity(nameAndSearchTerm);
		} catch (Exception e) {
			log.error("Place " + nameAndSearchTerm[0] + " has no photo. Trying new random city.");
			city = getRandomCityOtherThan(notThisCity);
		}
		
		return city;
		
		
	}
	
	
}
