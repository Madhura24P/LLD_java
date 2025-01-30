package com.Stackoverflow;

import java.util.Date;

public class Comment {
	
	private final int id;
	private final String content;
	private final User author;
	private final Date creationDate;
	
	public Comment(User u,String c)
	{
		this.id=generatedId();
		this.author=u;
		this.content=c;
		this.creationDate=new Date();
	}
	
	private int generatedId()
	{
		return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
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

	public Date getCreationDate() {
		return creationDate;
	}
	
	//getters
	

}
