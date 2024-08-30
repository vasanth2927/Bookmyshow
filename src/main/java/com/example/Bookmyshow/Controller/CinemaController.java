package com.example.Bookmyshow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookmyshow.Entity.Cinema;
import com.example.Bookmyshow.Service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

	@Autowired
	CinemaService cinemaservice;

	@GetMapping("/getallcinemas")
	public List<Cinema> getallCinemas() {

		return cinemaservice.getallCinemas();

	}

	@PostMapping("/addcinemas")
	public Cinema addcinemas(@RequestBody Cinema cinema) {

		return cinemaservice.addcinemas(cinema);

	}

	@GetMapping("/getcinemaId/{cinemaId}")

	public Optional<Cinema> getcinema(@PathVariable(value = "cinemaId") int cinemaId) {

		return cinemaservice.getcinema(cinemaId);

	}

}
