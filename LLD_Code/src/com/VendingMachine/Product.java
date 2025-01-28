package com.VendingMachine;

import java.util.Objects;

public class Product {
	
	private  final String name;
	private final double price;
	
	public Product(String name,double price)
	{
		this.name=name;
		this.price=price;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	/*
	 * @Override public int hashCode() { return Objects.hashCode(name); }
	 * 
	 * @Override public boolean equals(Object o) { if(o==null) { return false; }
	 * if(this==o) { return true; }
	 * 
	 * if(getClass()!=o.getClass()) { return false; }
	 * 
	 * Product p=(Product) o;
	 * 
	 * return this.getName().equals(p.getName());
	 * 
	 * }
	 */

}
