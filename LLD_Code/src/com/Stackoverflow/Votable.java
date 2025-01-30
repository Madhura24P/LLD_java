package com.Stackoverflow;

public interface Votable {
	
	void vote(User u,int val);
	int getVoteCount();

}
