package com.example.Bookmyshow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookmyshow.Entity.movielist;
import com.example.Bookmyshow.Service.Movieservise;

@RestController
@RequestMapping("/movieapi")
public class Moviecontroller {
	
	
	@Autowired
	Movieservise movieservise;

    @GetMapping("/getallmovies/{cinema}")
    public List<movielist>  getallmovies(@PathVariable("cinema") String cinema) {
    	
		return movieservise.getallmovies(cinema);
    	
    }
    
    
    
    @GetMapping("/getmovies/{cinema}/{movieid}")
    public ResponseEntity<movielist>  getmovie(@PathVariable String cinema,@PathVariable int movieid) {
    	
		return movieservise.getmovie(cinema,movieid);
    	
    }
    
    
    
    

}
