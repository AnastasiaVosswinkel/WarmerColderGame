package com.example.demo.beans;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import com.example.demo.service.GameLogicService;

@ViewScoped
@Named
public class WeatherGameBean {
	
	static Logger log = LoggerFactory.getLogger(WeatherGameBean.class);
	@Autowired
	private CityService cityService;
	@Autowired
	private GameLogicService gameLogicService;
	
	private City city1 = new City();
	private City city2 = new City();
	private int score = 0;
	private String motivatingMsg = "";
	private String resultweather = "?";
	
	@PostConstruct
	public void init() {
		newGame();
	}
	
	public void newGame() {
		score = 0;
		motivatingMsg = "";
		city1 = cityService.getRandomCityOtherThan("");
		city2 = cityService.getRandomCityOtherThan(city1.getName());
		
	}
	
	public void newRound() {
		String[] nameAndSearchTerm2 = {city2.getName(), city2.getSearchterm()};
		city1 = cityService.createCity(nameAndSearchTerm2);
		city2 = cityService.getRandomCityOtherThan(city1.getName());
		
	}
	

	
		
		
		double temp1 = Double.valueOf(city1.getTemperature());
		
		double temp2 = Double.valueOf(city2.getTemperature());
		

	public void warmer() {
		
		double temp1 = city1.getTemperature();
		double temp2 = city2.getTemperature();

		if (temp2 >= temp1) {
			winRound();
		} else {
			loseRound();
		}
		
	}
	
	public void colder() {
		double temp1 = city1.getTemperature();
		double temp2 = city2.getTemperature();
		if (temp2 <= temp1) {
			winRound();
		} else {
			loseRound();
		}
		
	}
	
	public void showWeatherTwoWarmer() {

		// resultweather = "Right! " + city2.getTemperature() + "°C";

		double temp1 = city1.getTemperature();
		double temp2 = city2.getTemperature();

		if (temp2 >= temp1) {
			resultweather = "Right " + city2.getTemperature() + "°C";
		} else {

		}
	}
	
	public void showWeatherTwoColder() {

		double temp1 = city1.getTemperature();
		double temp2 = city2.getTemperature();
		if (temp2 <= temp1) {
			resultweather = "Right " + city2.getTemperature() + "°C";
		} else {
			
		}
		
	}
	
		
		
	
	
	
	
	public void winRound() {
		resultweather= "?";
		score += 1;
		motivatingMsg = gameLogicService.createMotivatingMessage(score);
		// here we can add animations for Right and show temperature etc. with delay
		newRound();
	}
	
	public void loseRound() {
		// here we can add animations for Wrong and show temperature etc. with delay
		// also we could fade the screen to gray and show a "play again?" button before we start a new game
		newGame();
	}

	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMotivatingMsg() {
		return motivatingMsg;
	}

	public void setMotivatingMsg(String motivatingMsg) {
		this.motivatingMsg = motivatingMsg;
	}

	public String getresultweather() {
		return resultweather;
	}

	public void setresultweather(String weathert) {
		this.resultweather = weathert;
	}
	
	
	
	
	
	
	
}
