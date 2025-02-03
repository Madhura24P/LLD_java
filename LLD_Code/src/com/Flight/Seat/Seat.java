package com.Flight.Seat;

public class Seat {
	
	private final String seatNum;
	private final SeatType type;
	private SeatStatus status;
	public Seat(String seatNum, SeatType type, SeatStatus status) {
		super();
		this.seatNum = seatNum;
		this.type = type;
		this.status = SeatStatus.AVAILABLE;
	}
	public void reserved()
	{
		status=SeatStatus.RESERVED;
	}
	
	public void released()
	{
		status=SeatStatus.AVAILABLE;
	}
	
	

}
