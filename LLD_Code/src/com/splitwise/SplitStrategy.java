package com.splitwise;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
	
	List<Split> calculateSplits(Map<User,Double> splitData,double totalAmount);

}
