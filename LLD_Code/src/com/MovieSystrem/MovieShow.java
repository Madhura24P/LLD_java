package com.MovieSystrem;

import java.time.LocalDateTime;
import java.util.Map;

public class MovieShow {
	
	private final String id;
	private final Movie m;
	private final Theatre t;
	private final LocalDateTime startTime;
	private final LocalDateTime endTime;
	private final Map<String,Seat> seats;
	public MovieShow(String id, Movie m, Theatre t, LocalDateTime startTime, LocalDateTime endTime,
			Map<String, Seat> seats) {
		super();
		this.id = id;
		this.m = m;
		this.t = t;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seats = seats;
	}
	public String getId() {
		return id;
	}
	public Movie getM() {
		return m;
	}
	public Theatre getT() {
		return t;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public Map<String, Seat> getSeats() {
		return seats;
	}
	
	
	

}
