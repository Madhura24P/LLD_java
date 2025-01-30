package com.Stackoverflow;

public class Vote {
	
	private final User u;
	private final int val;
	
	public Vote(User u,int v)
	{
		this.u=u;
		this.val=v;
	}
	
	//
	
	public User getUser()
	{
		return u;
	}
	
	public int getVote()
	{
		return val;
	}

}
