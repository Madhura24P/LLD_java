package com.Stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable,Commentable{

	private final int id;
	private final String title;
	private final String content;
	private final User author;
	private final List<Answer> ans;
	private final List<Comment> com;
	private final List<Tag> tags;
	private final List<Vote> votes;
	private final Date creationDate;
	
	
	public Question( User author,String title, String content, List<String> tagnames) {
		this.id = generateId();
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate=new Date();
		this.ans=new ArrayList<>();
		this.tags=new ArrayList<>();
		this.com=new ArrayList<>();
		this.votes=new ArrayList<Vote>();
		for(String t:tagnames)
		{
			this.tags.add(new Tag(t));
		}
	}
	

	
	
	
	private int generateId()
	{
		return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
	}
	
	
	public void addAnswer(Answer a)
	{
		if(!ans.contains(a))
		{
			ans.add(a);
		}
	}





	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		com.add(c);
		
	}





	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return new ArrayList<>(com);
	}





	@Override
	public void vote(User u, int val) {
		// TODO Auto-generated method stub
		if(val!=1 && val!=-1)
		{
			throw new IllegalArgumentException("Vote val must be 1 or -1");
		}
		votes.removeIf(v->v.getUser().equals(u));
		votes.add(new Vote(u,val));
		author.updateRep(val*5);
		
	}





	@Override
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return votes.stream().mapToInt(Vote::getVote).sum();
	}





	public int getId() {
		return id;
	}





	public String getTitle() {
		return title;
	}





	public String getContent() {
		return content;
	}





	public User getAuthor() {
		return author;
	}





	public List<Answer> getAns() {
		return ans;
	}





	public List<Tag> getTags() {
		return tags;
	}





	public Date getCreationDate() {
		return creationDate;
	}
	
	
	
}
