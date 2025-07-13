package com.HotelManagement;

import java.time.LocalDate;

public class Reservation {
	private final String id;
	private final Guest guest;
	private final Room room;
	private final LocalDate checkInDate;
	private final LocalDate checkOutDate;
	private ReservationStatus status;
	public Reservation(String id, Guest guest, Room room, LocalDate checkInDate, 
			LocalDate checkOutDate) {
		super();
		this.id = id;
		this.guest = guest;
		this.room = room;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.status = ReservationStatus.CONFIRMED;
	}
	
	public synchronized void cancel()
	{
		if(status==ReservationStatus.CONFIRMED)
		{
			status=ReservationStatus.CANCELLED;
			room.checckOut();
		}else
		{
			throw new IllegalStateException("Reservation is not confirmed");
		}
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public Guest getGuest() {
		return guest;
	}

	public Room getRoom() {
		return room;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	
	
	
	
	

}
