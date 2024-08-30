package com.example.Bookmyshow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookmyshow.Entity.Confirm;
import com.example.Bookmyshow.Entity.movielist;
import com.example.Bookmyshow.Service.Showservice;

@RestController
@RequestMapping("/Showcontroller")
public class Showcontroller {
	@Autowired
	Showservice service;

	@PostMapping("/getavailability")
	public movielist getavailabiltyresponse(@RequestBody movielist movie) {
		return service.getavailabiltyresponse(movie);
	}

	@PostMapping("/Ticketconfirm")
	public ResponseEntity<byte[]> Ticketconform(@RequestBody Confirm confirm) {

		return service.Ticketconform(confirm);

	}
}
