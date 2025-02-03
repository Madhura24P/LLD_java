package com.Flight.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.Flight.Flight;
import com.Flight.User;
import com.Flight.Seat.Seat;

public class BookingManager {
	
	private static volatile BookingManager inst;
	private final Map<String,Booking> bookings;
	private final AtomicInteger bookingCounter=new AtomicInteger(0);
	
	private BookingManager()
	{
		bookings=new ConcurrentHashMap<>();
	}
	
	public static BookingManager getInst()
	{
		if(inst==null)
		{
			
			synchronized(BookingManager.class)
			{
				if(inst==null)
				{
					inst=new BookingManager();
				}
			}
			
		}
		
		return inst;
	}
	
	
	public Booking createBooking(Flight f,User u,Seat s,double price)
	{String bookingNum=generateBookingNum();
	Booking booking=new Booking(bookingNum,f,u,s,price);
	bookings.put(bookingNum, booking);
	
	return booking;
	
		
	}
	
	public Booking cancelBooking(String bookingNum)
	{
	
	Booking booking=bookings.get(bookingNum);
	if(booking!=null)
	booking.cancel();
	
	return booking;
	
		
	}
	
	private String generateBookingNum()
	{
		int bookingId=bookingCounter.incrementAndGet();
		String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return "BKG"+timestamp+String.format("%06d", bookingId);
	}

}
