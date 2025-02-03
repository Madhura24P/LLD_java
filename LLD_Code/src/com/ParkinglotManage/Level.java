  package com.ParkinglotManage;

import java.util.ArrayList;
import java.util.List;

import com.ParkinglotManage.Vehicle.Vehicle;
import com.ParkinglotManage.Vehicle.VehicleType;

public class Level {
	
	private final int floor;
	private final List<ParkingSpot> parkingSpots;
	private int counter;
	
	public Level(int level,int numSpots)
	{
		this.floor=level;
		parkingSpots=new ArrayList<>(numSpots);
		
		double spotsBike=0.50;
		double spotsCar=0.40;
		
		int numBike=(int) (numSpots*spotsBike);
		int numCar=(int) (numSpots*spotsCar);
		
		for(int i=1;i<=numBike;i++)
		{
			parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
		}
		
		for(int i=numBike+1;i<=numBike+numCar;i++)
		{
			parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
	
		}
		
		for(int i=numBike+numCar+1;i<=numSpots;i++)
		{
			parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));

		}
	}
	
	public synchronized boolean parkVehicle(Vehicle veh)
	{
		for(ParkingSpot spot:parkingSpots)
		{
			if(spot.isAvailable() && spot.getVehicleType()==veh.getype())
			{
				spot.parkVehicle(veh);
				counter++;
				return true;
			}
		}
		
		return false;
	}
	
	public synchronized boolean unparkVehicle(Vehicle veh)
	{
		for(ParkingSpot spot:parkingSpots)
		{
			if(!spot.isAvailable() && spot.getParkedVehicle().equals(veh))
			{
				spot.unparkedVehicle();
				return true;
			}
		}
		
		return false;
	}
	
	
	public void displayAvaialbility()
	{
		System.out.println("Level "+floor +" Occupied:"+counter+" Avaialble:"+(parkingSpots.size()-counter));
		/*
		 * for(ParkingSpot sp:parkingSpots) {
		 * System.out.println("spot "+":"+(sp.isAvailable()?
		 * "Avaialble for":"Occupied by"+" "+sp.getVehicleType()));
		 * 
		 * 
		 * }
		 */
	}
	

}
