package com.example.Bookmyshow.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class movielist {
	private int movieid;
	private String moviename;
	private String time;
	private int available_ticket;

	private String status;

}
