package com.Flight.booking;

import com.Flight.Flight;
import com.Flight.User;
import com.Flight.Seat.Seat;
import com.Flight.Seat.SeatType;
import com.Flight.booking.BookingStatus;

public class Booking {
	
	private final String bookingNum;
	private final Flight fl;
	private final double price;
	private final User u;
	private BookingStatus status;
	//private SeatType typ_s;
	
	public Booking(String bookingNum, Flight fl,User u, Seat s,double price) {
		super();
		this.bookingNum = bookingNum;
		this.fl = fl;
		this.price = price;
		this.u = u;
		this.status = BookingStatus.CONFIRMED;
		//this.typ_s = typ_s;
	}
	
	public void cancel()
	{
		status=BookingStatus.CANCELLED;
	}
	
	public String getBookingNum()
	{
		return bookingNum;
	}
	

	
    
	

}
