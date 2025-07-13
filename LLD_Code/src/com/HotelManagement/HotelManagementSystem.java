package com.HotelManagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
	
	private static HotelManagementSystem instance;
	private final Map<String,Guest> guests;
	private final Map<String,Room> rooms;
	private final Map<String,Reservation> reservations;
	
	private HotelManagementSystem()
	{
		guests=new ConcurrentHashMap<String, Guest>();
		rooms=new ConcurrentHashMap<String, Room>();
		reservations=new ConcurrentHashMap<String, Reservation>();
	}
	
	public void addGuest(Guest g)
	{
		guests.put(g.getId(), g);
	}
	
	public Guest getGuest(String gId)
	{
		return guests.get(gId);
	}
	
	public void addRoom(Room r)
	{
		rooms.put(r.getId(), r);
	}
	
	public Room getRoom(String rId)
	{
	    return rooms.get(rId)	;
	}
	
	public synchronized Reservation bookRoom(Guest g,Room r,LocalDate checkIn,LocalDate checkOut)
	{ 
		if(r.getStatus()==RoomStatus.AVAILABLE)
		{
			r.book();
			String reservationId=generateReservationId();
			Reservation res=new Reservation(reservationId, g, r, checkIn, checkOut);
			reservations.put(reservationId, res);
			return res;
		}
		
		return null;
		
	}
	
	public synchronized void cancelReservation(String reservationId)
	{
		Reservation res=reservations.get(reservationId);
		if(res!=null)
		{
			res.cancel();
			reservations.remove(reservationId);
		}
	}
	
	public synchronized void checkIn(String reservationId)
	{
		Reservation res = reservations.get(reservationId);
		if(res!=null && res.getStatus()==ReservationStatus.CONFIRMED)
		{
			res.getRoom().checckIn();
		}else
		{
			throw new IllegalStateException("Invalid reservation");
		}
	}
	
	public synchronized void checkOut(String resId,Payment p)
	{
		Reservation res=reservations.get(resId);
		if(res!=null && res.getStatus()==ReservationStatus.CONFIRMED)
		{
			Room room=res.getRoom();
			double amt=room.getPrice()*ChronoUnit.DAYS.between(res.getCheckInDate(), res.getCheckOutDate());
			if(p.processPayment(amt))
			{
				room.checckOut();
				reservations.remove(resId);
			}else
			{
				throw new IllegalStateException("Payment failes");
			}
		}else
		{
			throw new IllegalStateException("Invalid reservation");
		}
		
	}
	
	
	
	private String generateReservationId()
	{
		return "RES"+UUID.randomUUID().toString().substring(0, 8).toUpperCase();	}

}
