package com.example.demo.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.weather.Weather;

@SpringBootTest
public class WeatherClientTest {
	static Logger log = LoggerFactory.getLogger(WeatherClientTest.class);
	@Autowired
	private WeatherClient client;
	
	@Test
	public void crieateWeatherTest() {
		Weather weather = client.createWeather();
		assertNotNull(weather);
		log.debug(">>>>>>>>Weather:" + Double.toString(weather.getMain().getTemp()));
		log.debug(">>>>>>>>Name:" + weather.getName());
		
	}
	
	
	

}
