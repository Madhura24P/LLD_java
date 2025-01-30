package com.Stackoverflow;

import java.util.*;

public class Answer implements Votable,Commentable{
	private final int id;
	private final String content;
	private final User author;
	private final Question q;
	private boolean isAccepted;
	
	private final Date creationDate;
	private final List<Comment> comments;
	private final List<Vote> v;
	
	public Answer(User u,String content,Question q)
	{
		this.id=generateId();
		this.author=u;
		this.q=q;
		this.content=content;
		this.creationDate=new Date();
		this.v=new ArrayList<>();
		this.comments=new ArrayList<>();
		this.isAccepted=false;
	}
	
	private int generateId()
	{
		return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
	}

	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		comments.add(c);
		
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return new ArrayList<>(comments);
	}

	@Override
	public void vote(User u, int val) {
		// TODO Auto-generated method stub
		if(val!=1 && val!=-1)
		{
			throw new IllegalArgumentException("Vote val must be 1 or -1");
		}
		v.removeIf(v->v.getUser().equals(u));
		v.add(new Vote(u,val));
		author.updateRep(val*10);
		
	}

	@Override
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return v.stream().mapToInt(Vote::getVote).sum() ;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void markAsAccepted() {
		
		if(isAccepted)
		{
			throw new IllegalStateException("this answe+r already accepted");
		}
		isAccepted=true;
		author.updateRep(15);
		this.isAccepted = isAccepted;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public Question getQ() {
		return q;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public List<Vote> getV() {
		return v;
	}
	
	
	 
	
	
	
	
	

}
