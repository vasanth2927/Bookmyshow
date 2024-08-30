package com.example.Bookmyshow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Bookmyshow.Entity.Confirm;
import com.example.PVR.Entity.movielist;

@Service
public class Bookingservice {

	@Autowired
	private RestTemplate restTemplate;

	private final String pathpvr = "http://localhost:9090";
	private final String pathinox = "http://localhost:9191";

	public movielist getseatavailable(String cinema, movielist movie) {
		String url = "";
		HttpEntity<movielist> request = new HttpEntity<>(movie);

		switch (cinema.toUpperCase()) {
		case "PVR":
			url = pathpvr + "/PVR/getseatavailable";
			break;
		case "INOX":
			url = pathinox + "/INOX/getseatavailable";
			break;
		default:
			throw new IllegalArgumentException("Unexpected cinema: " + cinema);
		}

		return restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<movielist>() {
		}).getBody();
	}

	public ResponseEntity<byte[]> seatbooking(String cinema, Confirm confirm) {
		// Log the request body
		System.out.println("Request Body: " + confirm);

		switch (cinema) {
		case "PVR":
			String pvrurl = pathpvr + "/PVR/seatbooking";
			HttpEntity<Confirm> req1 = new HttpEntity<>(confirm);
			return restTemplate.exchange(pvrurl, HttpMethod.POST, req1, byte[].class);

		case "INOX":
			String inoxurl = pathinox + "/INOX/seatbooking";
			HttpEntity<Confirm> req2 = new HttpEntity<>(confirm);
			return restTemplate.exchange(inoxurl, HttpMethod.POST, req2, byte[].class);

		default:
			throw new IllegalArgumentException("Unexpected value: " + cinema);
		}
	}

	public String cancelbooking(String cinema, String BookingID) {
		String url = "";

		switch (cinema.toUpperCase()) {
		case "PVR":
			url = pathpvr + "/PVR/cancelbooking/" + BookingID;
			break;
		case "INOX":
			url = pathinox + "/INOX/cancelbooking/" + BookingID;
			break;
		default:
			throw new IllegalArgumentException("Unexpected cinema: " + cinema);
		}

		return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
	}

	
	}
	
	
	
	
	
	
	
	
