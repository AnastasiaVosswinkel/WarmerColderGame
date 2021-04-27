package com.example.demo.client;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.weather.Weather;

@Service
public class WeatherClient {

	static Logger log = LoggerFactory.getLogger(WeatherClient.class);
	private String urlOpenWeather;

	private RestTemplate template = new RestTemplate();
	

	
	public Weather createWeather(String cityname) { 
		urlOpenWeather = "http://api.openweathermap.org/data/2.5/weather?q=" + cityname
				+ "&appid=10f38280437ab8df65454df7de2244ba&units=metric&lang=en";

		ResponseEntity<Weather> re = template.getForEntity(urlOpenWeather, Weather.class);

		Weather weather = re.getBody();
		
		return weather;
		
	}
	
	

	public Weather createRandomWeather() {
		
		String[] cities = {"Hamburg", "Milan", "Portu", "Rom", "Yakutsk", "Bern",
				"Oslo", "Kingston", "Budapest", "Riyadh", "Hanoi",
			 "Munich", "Mexico City", "Cairo", "Berlin", "Moscow", "Tirana", "Algiers", "Kabul", "Luanda", "Vienna",
				 "Canberra", "Dhaka", "Bridgetown", "Brussels",
				"Beijing", "Paris", "London", "Thimphu", "Tokyo" };
				
		

		Random random = new Random();
		String place = cities[random.nextInt((cities.length - 1))];	

		log.debug("Place " + place);
		urlOpenWeather = "http://api.openweathermap.org/data/2.5/weather?q=" + place
				+ "&appid=10f38280437ab8df65454df7de2244ba&units=metric&lang=en";

		ResponseEntity<Weather> re = template.getForEntity(urlOpenWeather, Weather.class);

		Weather weather = re.getBody();
		return weather;
	
		
		
	
	}
	
	public Weather createNextWeather1(String place) { 
		urlOpenWeather = "http://api.openweathermap.org/data/2.5/weather?q=" + place
				+ "&appid=10f38280437ab8df65454df7de2244ba&units=metric&lang=en";

		ResponseEntity<Weather> re = template.getForEntity(urlOpenWeather, Weather.class);

		Weather weather = re.getBody();
		
		return weather;
		
	}
	
	
}
