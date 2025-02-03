package com.Flight;

public class AirIndiaFactory extends FactoryFlight {

	@Override
	public Flights createFlight() {
		// TODO Auto-generated method stub
		
		return new AirIndiaFlight();
	}

}
