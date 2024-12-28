package com.ParkinglotManage;

import java.util.*;

import com.ParkinglotManage.Vehicle.Vehicle;

public class ParkingLot {
	
	private static ParkingLot inst;
	private final List<Level> levels;
	
	private ParkingLot()
	{
		levels=new ArrayList<>();
	}
	
	public static synchronized ParkingLot getInst()
	{
		if(inst==null)
		{
			inst=new ParkingLot();
		}
		return inst;
	}
	
	
	public void addLevel(Level l)
	{
		levels.add(l);
	}
	
	public boolean parkVehicle(Vehicle veh)
	{
		for(Level l:levels)
		{
			if(l.parkVehicle(veh)) {
				System.out.println("Vehicle parked");
				return true;
			}
		}
		
		System.out.println("Parking full");
		return false;
	}
	
	public boolean unparkVehicle(Vehicle veh)
	{
		for(Level l:levels)
		{
			if(l.unparkVehicle(veh))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void display()
	{
		for(Level l:levels)
		{
			l.displayAvaialbility();
		}
	}

}
