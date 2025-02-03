package com.Flight;

import java.util.Arrays;
import java.util.List;

public class TripDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> freq=Arrays.asList("2","8","22");
		Flight f=null;
		//Flight f=new Flight(1234,45,"Pune","Mumbai","2",freq,"AirIndia");
		FactoryFlight ff=new AirIndiaFactory();
		ff.addFlight(f);
		
		
		
		

	}

}
