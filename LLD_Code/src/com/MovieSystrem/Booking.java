package com.MovieSystrem;

import java.util.List;

public class Booking {
	
	private final String id;
	private final User user;
	private final MovieShow show;
	private final List<Seat> seats;
	private final double totalprice;
	private BookingStatus status;
	public Booking(String id, User user, MovieShow show, List<Seat> seats, double totalprice, BookingStatus status) {
		super();
		this.id = id;
		this.user = user;
		this.show = show;
		this.seats = seats;
		this.totalprice = totalprice;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public MovieShow getShow() {
		return show;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public double getTotalprice() {
		return totalprice;
	}
	
	
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public BookingStatus getStatus() {
		return status;
	}
	
	

}
