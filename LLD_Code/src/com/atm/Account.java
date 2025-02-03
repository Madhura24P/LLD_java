package com.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Account {
	
	private final Integer accNum;
	private Integer currBalance;
	
	static Map<Integer,Integer> accBalMap=new ConcurrentHashMap<>();
	
	static 
	{
		accBalMap.put(241991, 1000);
		accBalMap.put(040404, 2000);
	}
	

	
	public Account(Integer accNum)
	{
		this.accNum=accNum;
		//6accBalMap=new ConcurrentHashMap<>();
	}


	
	public synchronized Integer withdrawAmt(Integer amt,User u)
	{
		currBalance=accBalMap.get(u.getAccNum());
		
		if(currBalance>amt)
		{
			currBalance=currBalance-amt;
		}
		else
		{
			throw new RuntimeException("No Balance ");
		}
		
		accBalMap.put(u.getAccNum(), currBalance);
		
		return currBalance;
	}

}
