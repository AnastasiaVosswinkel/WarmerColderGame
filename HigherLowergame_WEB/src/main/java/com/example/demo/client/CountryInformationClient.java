package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.countryinformation.CountryInformation;

@Service
public class CountryInformationClient{
	static Logger log = LoggerFactory.getLogger(CountryInformationClient.class);

	private String URL_CountryInformation;
	private RestTemplate template = new RestTemplate();
	
	public CountryInformation createCountryInformationURL(String country) {
		log.debug("Country " + country);
		URL_CountryInformation = "https://restcountries.eu/rest/v2/alpha/"+country;
		ResponseEntity<CountryInformation> re = template.getForEntity(URL_CountryInformation, CountryInformation.class);

		CountryInformation countryInformation = re.getBody();
		return countryInformation;
}
}
