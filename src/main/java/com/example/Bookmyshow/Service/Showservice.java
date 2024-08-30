package com.example.Bookmyshow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Bookmyshow.Entity.Confirm;
import com.example.Bookmyshow.Entity.movielist;

@Service
public class Showservice {

	@Autowired
	RestTemplate restemplate;

	private final String pathpvr = "http://localhost:9090";

	public movielist getavailabiltyresponse(movielist movie) {
		String url = pathpvr + "/getdata";
		HttpEntity<movielist> req = new HttpEntity<>(movie);

		return restemplate.exchange(url, HttpMethod.POST, req, new ParameterizedTypeReference<movielist>() {
		}).getBody();
	}

	public ResponseEntity<byte[]> Ticketconform(Confirm confirm) {
		String url = pathpvr + "/Ticketconform";
		HttpEntity<Confirm> req = new HttpEntity<>(confirm);

		ResponseEntity<byte[]> response = restemplate.exchange(url, HttpMethod.POST, req, byte[].class);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=report.pdf")
				.header("Content-Type", "application/pdf").body(response.getBody());
	}
}
