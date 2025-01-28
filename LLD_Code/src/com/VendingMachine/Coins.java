package com.VendingMachine;

public enum Coins {
	
	PENNY(1),
	QUARTER(0.25);
	
	
	
	private final double value;
	
	Coins(double val)
	{
		this.value=val;
	}
	
	public double getValue()
	{
		return value;
	}

}
