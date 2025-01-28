package com.VendingMachine;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
	
	private final Map<Product,Integer> products;
	
	public Inventory()
	{
		products=new ConcurrentHashMap<>();
	}
	
	public void addProduct(Product p,int qty)
	{
	   products.put(p, qty);	
	}
	
	public void removeProduct(Product p)
	{
		products.remove(p);
	}
	
	public void updateQty(Product p,int q)
	{
		products.put(p, q);
	}
	
	public int getQty(Product p)
	{
		return products.getOrDefault(p, 0);
	}
	
	public boolean isAvailable(Product p)
	{
		return products.containsKey(p) && products.get(p)>0;
	}

}
