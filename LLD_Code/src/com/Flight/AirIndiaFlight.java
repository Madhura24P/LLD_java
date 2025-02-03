package com.Flight;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AirIndiaFlight implements Flights {
	
Map<String,Flight> flightMap;

public AirIndiaFlight()
{
	flightMap=new ConcurrentHashMap<>();
}
	
	public void registerFlight(String ModelNum, Flight f) {
		// TODO Auto-generated method stub
		
           this.flightMap.put(ModelNum, f);
           System.out.println(ModelNum);
	}



	public Map<String, Flight> getFlightMap() {
		return flightMap;
	}
	
	
	
	

}
