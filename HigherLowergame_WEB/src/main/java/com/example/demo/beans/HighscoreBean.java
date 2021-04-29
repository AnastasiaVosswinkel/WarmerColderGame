package com.example.demo.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HighscoreDAO;
import com.example.demo.model.User;

@ViewScoped
@Named
public class HighscoreBean {
	
	private User newUser = new User();
	private ArrayList<User> highscoreList = new ArrayList<>();
	
	@Autowired
	HighscoreDAO highscoreDAO;
	

	
	@PostConstruct
	public void init() {
		loadHighscores();
	}
	
	
	public ArrayList<User> rankUsers (ArrayList<User> users){
		users.sort(Collections.reverseOrder());
		
		users.get(0).setRank(1);
		for (int i = 1; i < users.size(); i++) {
			if (users.get(i).getScore() == users.get(i-1).getScore()) {
				users.get(i).setRank(users.get(i-1).getRank());
			} else {
				users.get(i).setRank(i+1);
			}
			
		}
		return users;
	}
	
	public void loadHighscores() {
		ArrayList<User> users = highscoreDAO.findAll();
		highscoreList = rankUsers(users);
		System.out.println(highscoreList);
	}

	public void saveNewUserScore(){
		newUser.setRank(0);
		newUser.setId(highscoreList.size()); //FIX-ME this is not a correct way to assign ids
		newUser.setScore(5); // TODO change to current score after losing a game
		
		highscoreList.add(newUser);
		highscoreList = rankUsers(highscoreList);
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



	
	
}
