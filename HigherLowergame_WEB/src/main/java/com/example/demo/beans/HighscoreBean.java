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
	
	

	
	public void loadHighscores() {
		ArrayList<User> users = highscoreDAO.findAll();
		highscoreList = highscoreDAO.rankUsers(users);
		System.out.println(highscoreList);
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
