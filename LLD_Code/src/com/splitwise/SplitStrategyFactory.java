package com.splitwise;

public class SplitStrategyFactory {
	
	public static SplitStrategy getStrategy(SplitType type)
	{
		return switch(type) {
		case EQUAL -> new EqualSplitStrategy();
		default -> throw new IllegalArgumentException("Unsupported split type");
		};
	}

}
