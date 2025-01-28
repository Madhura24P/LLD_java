package com.VendingMachine;

public enum Notes {
	
	ONE(1),
	FIVE(5),
	TEN(10);
	
	private final int value;
	
	Notes(int val)
	{
		this.value=val;
	}
	
	public int getValue()
	{
		return value;
	}

}
