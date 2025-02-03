package com.Flight;

public abstract class FactoryFlight {
	
	public abstract Flights createFlight();
	
	public void addFlight(Flight f)
	{
		Flights fl=createFlight();
		fl.registerFlight(f.getModelNum(), f);
		
		
	}

}
