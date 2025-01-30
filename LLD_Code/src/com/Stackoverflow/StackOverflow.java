package com.Stackoverflow;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
	
	private final Map<Integer,User> users;
	private final Map<Integer,Question> questions;
	private final Map<Integer,Answer> answers;
	private final Map<String,Tag> tags;
	
	public StackOverflow()
	{
		users=new ConcurrentHashMap<Integer, User>();
		questions=new ConcurrentHashMap<Integer, Question>();
		answers=new ConcurrentHashMap<Integer, Answer>();
		tags=new ConcurrentHashMap<String, Tag>();
		
		
	}
	
	public User createUser(String name,String email)
	{
		int id=users.size()+1;
		User user=new User(id,name,email);
		users.put(id, user);
		return user;
	}
	
	public Question askQuestion(User u,String title,String content,List<String> tags)
	{
		Question q=u.askQuestion(content, content, tags);
		questions.put(q.getId(),q);
		for(Tag t:q.getTags())
		{
			this.tags.putIfAbsent(t.getName(), t);
		}
		
		return q;
	}
	
	public Answer ansQuestion(User u,Question q,String c)
	{
		Answer a=null;
		
		
		return a;
	}
	
	public Comment addComment(User u,Commentable c,String content)
	{
		return u.addComment(c, content);
	}
	
	public void voteQuestion(User u,Question q,int val)
	{
		q.vote(u, val);
	}
	
	public void voteAnswer(User u,Answer a,int val)
	{
		a.vote(u, val);
	}
	
	public void acceptAnswer(Answer a)
	{
		a.markAsAccepted();
	}
	
	public List<Question> searchQuestions(String q)
	{
		return questions.values().stream().filter(q1->q1.getTitle().toLowerCase().contains(q.toLowerCase()) ||
				q1.getContent().toLowerCase().contains(q.toLowerCase()) ||
				q1.getTags().stream().anyMatch(t->t.getName().equalsIgnoreCase(q))).collect(Collectors.toList());
				
	}
	
	public List<Question> getQuestionsByUser(User u)
	{
		return u.getQuestions();
	}

	public Map<Integer, User> getUsers() {
		return users;
	}

	public Map<Integer, Question> getQuestions() {
		return questions;
	}

	public Map<Integer, Answer> getAnswers() {
		return answers;
	}

	public Map<String, Tag> getTags() {
		return tags;
	}
	
	
	
	
	

}
