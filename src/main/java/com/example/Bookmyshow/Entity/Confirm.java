package com.example.Bookmyshow.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component     
public class Confirm {
	private int Movieid;
	private String userId;
	private String BookingID;
    private String moviename;
    private String time;
    private int available_ticket; 
    private String paymenttype;
    private int amount;
    private String status;
    
    
    
	
}
