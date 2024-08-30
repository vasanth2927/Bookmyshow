package com.example.Bookmyshow.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bookmyshow.Entity.Cinema;
import com.example.Bookmyshow.Repsitory.CinemaRepository;

@Service
public class CinemaService {
	
	@Autowired
	CinemaRepository cinemarepository;

	public List<Cinema> getallCinemas() {
		return cinemarepository.findAll();
	}

	public Cinema addcinemas(Cinema cinema) {
		return  cinemarepository.save(cinema);
	}

	public Optional<Cinema> getcinema(int cinemaId) {
		return cinemarepository.findById(cinemaId);
	}

	
	
}
