package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.photoreference.PhotoReference;

@Service
public class PhotoClient {

	static Logger log = LoggerFactory.getLogger(PhotoClient.class);
	private String URL_PhotoReference;
	private String URL_PhotoGoogle;

	private RestTemplate template = new RestTemplate();

	public String createPhotoURL(String place) {

		log.debug("Place " + place);
		URL_PhotoReference = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=" + place
				+ "&key=AIzaSyAhGoyjCIPVdTiLfVuseEeh2wPUjAVnyAw&inputtype=textquery&fields=name,photos";

		// getForEntity -> HTTP GET verwendet
		// Apod.class Struktur passend zum json-Text
		// Apod Objekte werden generiert
		ResponseEntity<PhotoReference> re = template.getForEntity(URL_PhotoReference, PhotoReference.class);

		PhotoReference photoReference = re.getBody();
		
		URL_PhotoGoogle = "https://maps.googleapis.com/maps/api/place/photo?photoreference="+photoReference.getCandidates().get(0).getPhotos().get(0).getPhoto_reference()+"&key=AIzaSyAhGoyjCIPVdTiLfVuseEeh2wPUjAVnyAw&maxwidth=400&maxheight=400";

		return URL_PhotoGoogle;
	}

	public String getURL_PhotoReference() {
		return URL_PhotoReference;
	}

	public void setURL_PhotoReference(String uRL_PhotoReference) {
		URL_PhotoReference = uRL_PhotoReference;
	}

}
