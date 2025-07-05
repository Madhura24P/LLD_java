package com.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

	@Override
	public List<Split> calculateSplits(Map<User, Double> splitData, double totalAmount) {
		// TODO Auto-generated method stub
		
		int numberOfUsers=splitData.size();
		double equalAmt=totalAmount/numberOfUsers;
		
		List<Split> splits = new ArrayList<>();
		for(User u:splitData.keySet())
		{
			splits.add(new Split(u,equalAmt));
		}
		
		return splits;
	}

}
