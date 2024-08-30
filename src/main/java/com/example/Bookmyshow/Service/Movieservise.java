package com.example.Bookmyshow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Bookmyshow.Entity.movielist;



@Service
public class Movieservise {
	
	
	
	@Autowired
    RestTemplate restemplate;

    private final String pathpvr = "http://localhost:9090";
    private final String pathinox = "http://localhost:9191";
    
    
    
    public List<movielist> getallmovies(String cinema){
    	
    	switch (cinema) {
    	case "PVR":
    		String urlPVR=pathpvr+"/PVR/getallmovies";
    	return	 restemplate.exchange(urlPVR, HttpMethod.GET, null,  
    				new ParameterizedTypeReference<List<movielist>>() {}).getBody();
    	
    	case "INOX":
    	String urlINOX=pathinox+"/INOX/getallmovies";
    	return	 restemplate.exchange(urlINOX, HttpMethod.GET, null,  
    				new ParameterizedTypeReference<List<movielist>>() {}).getBody();
    	
		default:
			throw new IllegalArgumentException("Unexpected value: " + cinema);
		}
    	
    }



	public ResponseEntity<movielist> getmovie(String cinema, int movieid) {
		switch (cinema) {
    	case "PVR":
    		String urlPVR=pathpvr+"/PVR"+"/getmovies"+"/"+movieid;
    	return	 restemplate.exchange(urlPVR, HttpMethod.GET, null,  
    				new ParameterizedTypeReference<movielist>() {});
    	
    	case "INOX":
    	String urlINOX=pathinox+"/INOX"+"/getmovies"+"/"+movieid;
    	return restemplate.exchange(urlINOX, HttpMethod.GET, null,  
    				new ParameterizedTypeReference<movielist>() {});
    	
		default:
			throw new IllegalArgumentException("Unexpected value: " + cinema);
		}
		
	}
    
    
    
    
    
    

}
