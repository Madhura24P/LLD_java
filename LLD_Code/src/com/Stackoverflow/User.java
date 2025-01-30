package com.Stackoverflow;

import java.util.*;

public class User {
	private final int id;
	private final String username;
	private final String email;
	private int reputation;
	private final List<Question> questions;
	private final List<Answer> answers;
	private final List<Comment> comments;
	
	private static final int Q_rep=5;
	private static final int A_rep=10;
	private static final int C_rep=2;
	
	public User(int id,String username,String email)
	{
		this.id=id;
		this.username=username;
		this.email=email;
		this.reputation=0;
		this.questions=new ArrayList<>();
		this.answers=new ArrayList<>();
		this.comments=new ArrayList<>();
	}
	
	public synchronized void updateRep(int val)
	{
		this.reputation+=val;
		if(this.reputation<0)
		{
			this.reputation=0;
		}
	}
	
	
	public Question askQuestion(String title,String content,List<String> tags)
	{
		Question q=new Question(this,title,content,tags);
		questions.add(q);
		updateRep(Q_rep);
		
		return q;
	}
	
	public Answer answerQuestion(Question q,String c)
	{
		Answer a=new Answer(this,c,q);
		answers.add(a);
		q.addAnswer(a);
		updateRep(A_rep);
		
		return a;
		
	}
	
	public Comment addComment(Commentable c,String content)
	{
		Comment com=new Comment(this,content);
		comments.add(com);
		c.addComment(com);
		updateRep(C_rep);
		return com;
	}



	public int getReputation() {
		return reputation;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<Question> getQuestions() {
		return new ArrayList<>(questions);
	}

	public List<Answer> getAnswers() {
		return new ArrayList<>(answers);
	}

	public List<Comment> getComments() {
		return new ArrayList<>(comments);
	}
	
}
