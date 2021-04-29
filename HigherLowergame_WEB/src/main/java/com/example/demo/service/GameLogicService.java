package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.сonst.Const;

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
	
	public String getRandomQuote() {
		String quote = "";
		Random random = new Random();
		String[] quoteList = Const.MOTIVATING_QUOTES;
		int randomInt = random.nextInt(quoteList.length);
		quote = quoteList[randomInt];
		return quote;
		
	}
	

}
