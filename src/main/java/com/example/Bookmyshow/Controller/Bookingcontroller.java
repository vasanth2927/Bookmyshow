package com.example.Bookmyshow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookmyshow.Entity.Confirm;
import com.example.Bookmyshow.Service.Bookingservice;
import com.example.PVR.Entity.movielist;

@RestController
@RequestMapping("/Booking")
public class Bookingcontroller {

    @Autowired
    private Bookingservice bookingservice;
    
   

    @PostMapping("/getseatavailable/{cinema}")
    public movielist getseatavailable(@PathVariable String cinema, @RequestBody movielist movie) {
        return bookingservice.getseatavailable(cinema, movie);
    }

    @PostMapping("/seatbooking/{cinema}")
    public ResponseEntity<byte[]> seatbooking(@PathVariable String cinema, @RequestBody Confirm confirm) {
        return bookingservice.seatbooking(cinema, confirm);
    }
    
    
    @DeleteMapping("/cancelbooking/{cinema}/{BookingID}")
    public ResponseEntity<String> cancelbooking(@PathVariable String cinema, @PathVariable String BookingID) {
        String result = bookingservice.cancelbooking(cinema, BookingID);
        return ResponseEntity.ok(result);
    }
    
    
    
}
