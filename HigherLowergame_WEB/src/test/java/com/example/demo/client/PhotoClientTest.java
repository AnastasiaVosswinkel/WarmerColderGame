package com.example.demo.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.photoreference.PhotoReference;
import com.example.demo.model.weather.Weather;

@SpringBootTest
public class PhotoClientTest {
	static Logger log = LoggerFactory.getLogger(PhotoClientTest.class);
	@Autowired
	private PhotoClient client;
	
	
	

	@Test
	
	public void TestcreateCandidate () {
		
		
		String photoURL = client.createPhotoURL("berlin");
		log.debug(">>>>>>>PhotoReference:  "+ photoURL);
		
	
		
		assertNotNull(photoURL);
		
		
		
	}
}
