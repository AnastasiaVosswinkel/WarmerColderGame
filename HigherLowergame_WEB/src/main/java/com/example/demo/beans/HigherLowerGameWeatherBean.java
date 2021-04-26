package com.example.demo.beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.client.PhotoClient;
import com.example.demo.client.WeatherClient;
import com.example.demo.model.weather.Weather;
import com.example.demo.service.HigherLowergameWeatherService;


@ViewScoped
@Named
public class HigherLowerGameWeatherBean {
	static Logger log = LoggerFactory.getLogger(HigherLowerGameWeatherBean.class);
	@Autowired
	private WeatherClient weatherClient;
	@Autowired
	private PhotoClient photoClient;
	@Autowired
	private HigherLowergameWeatherService service;
	
	private Weather weather1 = new Weather();
	private Weather weather2 = new Weather();
	private String photo1 = new String();
	private String photo2 = new String();
	private String nameCity2 = weather2.getName();
	
	
	


	@PostConstruct
	public void init() {
		weather1  = weatherClient.createWeather();
		weather2  = weatherClient.createWeather();	
		photo1 = photoClient.createPhotoURL(weather1.getName());
		photo2 = photoClient.createPhotoURL(weather2.getName());
	
		
		
	}
	
	public void warmer() {
		service.nextRound();
	}
	
	
	
	
	
	public HigherLowergameWeatherService getService() {
		return service;
	}

	public void setService(HigherLowergameWeatherService service) {
		this.service = service;
	}

	public WeatherClient getWeatherClient() {
		return weatherClient;
	}

	public void setWeatherClient(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}

	public Weather getWeather1() {
		return weather1;
	}

	public void setWeather1(Weather weather1) {
		this.weather1 = weather1;
	}

	public Weather getWeather2() {
		return weather2;
	}

	public void setWeather2(Weather weather2) {
		this.weather2 = weather2;
	}

	public PhotoClient getPhotoClient() {
		return photoClient;
	}



	public void setPhotoClient(PhotoClient photoClient) {
		this.photoClient = photoClient;
	}



	public String getPhoto1() {
		return photo1;
	}



	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}



	public String getPhoto2() {
		return photo2;
	}



	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}


}
