package com.MovieSystrem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MovieBookingSystem {
	
	private static MovieBookingSystem inst;
	private final List<Movie> movies;
	private final List<Theatre> theatres;
	private final Map<String,MovieShow> shows;
	private final Map<String,Booking> bookings;
	
	private static final String Booking_ID_PREFIX="BKG";
	private static final AtomicLong bookingCounter=new AtomicLong(0);
	

	
	
	public MovieBookingSystem(List<Movie> movies, List<Theatre> theatres, Map<String, MovieShow> shows,
			Map<String, Booking> bookings) {
		super();
		this.movies = movies;
		this.theatres = theatres;
		this.shows = shows;
		this.bookings = bookings;
	}




	public void bookMovie(User u,Seat s,Theatre t)
	{
		
	}
   
	
	
	
	
	
	
	
}
