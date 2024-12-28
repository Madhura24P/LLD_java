package com.ParkinglotManage;

import com.ParkinglotManage.Vehicle.*;

public class ParkingLotDemo {
	
	public static void main(String[] args) {
		ParkingLot p=ParkingLot.getInst();
	p.addLevel(new Level(1,100));
	p.addLevel(new Level(2,100));

	Vehicle car=new Car("MH124348");
	
	p.parkVehicle(car);
	
	p.display();
	
	//p.unparkVehicle(car);
	
	//p.display();
	
	
	
	
	}

}
