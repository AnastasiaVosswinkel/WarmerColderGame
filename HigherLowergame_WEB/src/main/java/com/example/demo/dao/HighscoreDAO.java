package com.example.demo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Service
public class HighscoreDAO {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public ArrayList<User> findAll() {
		try {
			BufferedReader jsonReader = new BufferedReader(new FileReader("highscores.json"));
			User[] users = gson.fromJson(jsonReader, User[].class);
			return new ArrayList<User>(Arrays.asList(users));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean saveAll(ArrayList<User> users) {
		User[] userArray = users.toArray(new User[users.size()]);
		
		try {
			Writer writer = new FileWriter("highscores.json");
			gson.toJson(userArray, writer);
			writer.flush();
			writer.close();
			return true;
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
