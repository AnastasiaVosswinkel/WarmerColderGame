package com.example.demo.service;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.client.WeatherClient;
import com.example.demo.model.weather.Weather;


@SpringBootTest
public class ServiceTest {
	
	static Logger log = LoggerFactory.getLogger(ServiceTest.class);
	
	
	
	@Autowired
	private WeatherClient weatherClient;
	
	@Autowired
	private HigherLowergameWeatherService service;
	
	
	
	
	@Test
	public void nextRoundTest() {
		Weather weather1 = weatherClient.createWeather();
		Weather weather2 = weatherClient.createWeather();
		
		log.debug(">>>>>>>name weather2:  " + weather2.getName());
		service.nextRound();
		log.debug(">>>>>>>name weather2:  " + weather2.getName());
		log.debug(">>>>>>>name weather1:  " + weather1.getName());
		
	
		
	
		
		
		
	}

}
