package com.atm;

import java.util.*;

public class Authenticate {
	
	static Map<String,Integer> authenticUserMap=new HashMap<>();
	
	static {
		authenticUserMap.put("Madh2404", 1991);
		authenticUserMap.put("Anu11", 2001);
	}
	
	public  static boolean isValid(String u ,int pin)
	{
		return authenticUserMap.get(u)==pin;
	}
	
	
	

}
