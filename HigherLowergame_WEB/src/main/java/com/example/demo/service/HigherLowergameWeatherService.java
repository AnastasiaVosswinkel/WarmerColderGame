package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.PhotoClient;
import com.example.demo.client.WeatherClient;
import com.example.demo.model.weather.Weather;

@Service
public class HigherLowergameWeatherService {
	@Autowired
	private WeatherClient weatherClient;
	@Autowired
	private PhotoClient photoClient;
	
	private Weather weather1=new Weather();
	private Weather weather2=new Weather();
	private String photo1;
	private String photo2;
	
	
		

	
	public void nextRound() {
		weather1 = weather2;
		weather2 = weatherClient.createRandomWeather();
		photo1 = photoClient.createPhotoURL(weather1.getName());
		photo2 = photoClient.createPhotoURL(weather2.getName());			
		
	}
	

}
