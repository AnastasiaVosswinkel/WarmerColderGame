package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GameLogicService {
	
	
	public String createMotivatingMessage(int score) {
		String motivatingMsg = "";
		
		if (score >= 7) { 
			motivatingMsg = "You are a mastermind!";	
		} else if (score >= 4){
			motivatingMsg = "Looking brilliant!";
		} else if (score >= 2) {
			motivatingMsg = "Keep on going!";
		} else if (score >=1) {
			motivatingMsg = "Nice, great start!";
		}
		
		
		
		return motivatingMsg;
	}
	

}
