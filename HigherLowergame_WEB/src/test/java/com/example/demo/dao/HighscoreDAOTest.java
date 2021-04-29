package com.example.demo.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.HighscoreBean;
import com.example.demo.client.PhotoClientTest;
import com.example.demo.model.User;

@SpringBootTest
public class HighscoreDAOTest {
	
	static Logger log = LoggerFactory.getLogger(HighscoreDAOTest.class);

	@Autowired
	private HighscoreDAO highscoreDAO;
	
	// OVERWRITES DATA IN highscores.json !!! BE CAREFUL !!!
	@Test
	public void testWrite() {
		User sebastian = new User(0, 3, "Sebastian", 0);
		User test = new User(1, 2, "Manfred", 0);
		User best = new User(2, 10, "Luisa", 0);
		User anso = new User(3, 2, "Annamarie-Sophie", 0);
		User georg = new User(4, 10, "Georg", 0);
		User anton = new User(5, 0, "Anton", 0);
		
		ArrayList<User> users = new ArrayList<>();
		users.add(sebastian);
		users.add(best);
		users.add(test);
		users.add(anso);
		users.add(georg);
		users.add(anton);
		HighscoreBean bean = new HighscoreBean();
		users = bean.rankUsers(users);
		
		System.out.println(users);
		
		Assertions.assertTrue(highscoreDAO.saveAll(users));
		

		
	}
	
	@Test
	public void testRead() {
		ArrayList<User> loadedUsers = highscoreDAO.findAll();
		System.out.println(loadedUsers);
		
		Assertions.assertNotNull(loadedUsers);
	}
	
	
}
