package com.example.demo.beans;

import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dao.HighscoreDAO;
import com.example.demo.model.City;
import com.example.demo.model.User;
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
	private int score = 5;
	private String motivatingMsg = "";
	private String motivatingQuote = "";
	private String resultweather = "is";
	
	
	
	private User newUser = new User();
	private ArrayList<User> highscoreList = new ArrayList<>();
	@Autowired
	HighscoreDAO highscoreDAO;
	
	
	@PostConstruct
	public void init() {
		newGame();
		loadHighscores();
	}
	
	public void newGame() {
		resultweather= "it is";
		score = 0;
		motivatingMsg = "";
		motivatingQuote = gameLogicService.getRandomQuote();
		city1 = cityService.getRandomCityOtherThan("");
		city2 = cityService.getRandomCityOtherThan(city1.getName());
		
	}
	
	public void newRound() {
		String[] nameAndSearchTerm2 = {city2.getName(), city2.getSearchterm()};
		city1 = cityService.createCity(nameAndSearchTerm2);
		city2 = cityService.getRandomCityOtherThan(city1.getName());
		
	}

		

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
			resultweather = city2.getTemperature() + "°C";
		}
	}
	
	public void showWeatherTwoColder() {

		double temp1 = city1.getTemperature();
		double temp2 = city2.getTemperature();
		if (temp2 <= temp1) {
			resultweather = "Right " + city2.getTemperature() + "°C";
		} else {
			resultweather = city2.getTemperature() + "°C";
			
		}
		
	}
	
		
	public void winRound() {
		resultweather= "it is";
		score += 1;
		motivatingMsg = gameLogicService.createMotivatingMessage(score);
		// here we can add animations for Right and show temperature etc. with delay
		newRound();
	}
	
	public void loseRound() {
		
		// here we can add animations for Wrong and show temperature etc. with delay
		// also we could fade the screen to gray and show a "play again?" button before we start a new game
		//newGame();
		motivatingQuote = gameLogicService.getRandomQuote();
		PrimeFaces.current().executeScript("PF('dlg').show()");
	}
	
	
	public void loadHighscores() {
		ArrayList<User> users = highscoreDAO.findAll();
		highscoreList = highscoreDAO.rankUsers(users);
		System.out.println(highscoreList);
	}

	public void saveNewUserScore(){

		User userToSave = new User();
		userToSave.setName(newUser.getName());
		userToSave.setRank(0);
		userToSave.setId(highscoreList.size()); //FIX-ME this is not a correct way to assign ids
		userToSave.setScore(score);
		
		highscoreList.add(userToSave);
		highscoreList = highscoreDAO.rankUsers(highscoreList);
		highscoreDAO.saveAll(highscoreList);
	}
	
	
	public User getNewUser() {
		return newUser;
	}


	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}


	public ArrayList<User> getHighscoreList() {
		return highscoreList;
	}


	public void setHighscoreList(ArrayList<User> highscoreList) {
		this.highscoreList = highscoreList;
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

	public String getMotivatingQuote() {
		return motivatingQuote;
	}

	public void setMotivatingQuote(String motivatingQuote) {
		this.motivatingQuote = motivatingQuote;
	}

	public String getResultweather() {
		return resultweather;
	}

	public void setResultweather(String resultweather) {
		this.resultweather = resultweather;
	}
	
	
	
	
	
	
	
}
