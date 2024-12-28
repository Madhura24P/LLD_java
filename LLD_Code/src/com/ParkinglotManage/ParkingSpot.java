package com.ParkinglotManage;

import com.ParkinglotManage.Vehicle.*;

public class ParkingSpot {
	
	private final int spotNumber;
	private final VehicleType type;
	private Vehicle parkedVehicle;
	
	public ParkingSpot(int spotNum,VehicleType type)
	{
		this.spotNumber=spotNum;
		this.type=type;
	}
	
	public synchronized boolean isAvailable()
	{
		return parkedVehicle==null;
	}
	
	public synchronized void parkVehicle(Vehicle veh)
	{
		if(isAvailable() && veh.getype()==type)
		{
			parkedVehicle=veh;
		}else
		{
			throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
		}
	}
	
	public synchronized void unparkedVehicle()
	{
		parkedVehicle=null;
	}
	
	public VehicleType getVehicleType()
	{
		return type;
	}
	
	public Vehicle getParkedVehicle()
	{
		return parkedVehicle;
	}
	
	public int getSpotNumber()
	{
		return spotNumber;
	}

}
