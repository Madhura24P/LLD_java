package com.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.Flight.Seat.Seat;

public class Flight{
	
	private final String modelNum;
	private final int seats;
    private final String source;
    private final String destination;
    private final LocalDateTime departTime;
    private final LocalDateTime arrivalTime;
    private final String company;
    private final List<Seat> avaialbleSeats;
    
	public Flight(String modelNum, int seats, String source, String destination, LocalDateTime departTime,
			LocalDateTime arrivalTime, String company, List<Seat> avaialbleSeats) {
		super();
		this.modelNum = modelNum;
		this.seats = seats;
		this.source = source;
		this.destination = destination;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.company = company;
		this.avaialbleSeats = new ArrayList<>();
	}

	public String getModelNum() {
		return modelNum;
	}

	public int getSeats() {
		return seats;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDateTime getDepartTime() {
		return departTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public String getCompany() {
		return company;
	}

	public List<Seat> getAvaialbleSeats() {
		return avaialbleSeats;
	}
	
	
    
    
   
}
