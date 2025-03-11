package com.MovieSystrem;

public class Seat {
	
	private final String id;
	private final  SeatType type;
	private SeatStatus status;
	private final int row;
	private final int column;
	private final double price;
	public Seat(String id, SeatType type, int row, int column, double price,SeatStatus s) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
		this.row = row;
		this.column = column;
		this.price = price;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public SeatType getType() {
		return type;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public double getPrice() {
		return price;
	}
	
	
	
	

}
