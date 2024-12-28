package com.ParkinglotManage.Vehicle;

public abstract class Vehicle {
	
	protected String licensePlate;
	protected VehicleType type;
	
	public Vehicle(String plateNum,VehicleType type)
	{
		this.licensePlate=plateNum;
		this.type=type;
	}
	
	public VehicleType getype()
	{
		return type;
	}

}
