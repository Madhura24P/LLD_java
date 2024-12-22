package com.Librarymanage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LibManager {
	
	private static LibManager inst;
	private final Map<String,Book> catalog;
	private final Map<String,Member> members;
	private final int MAX_BOOKS_PER_MEMBER=5;
	private final int LOAN_DURATION=14;
	
	private LibManager()
	{
		catalog=new ConcurrentHashMap<String, Book>();
		members=new ConcurrentHashMap<String,Member>();
	}
	
	public static synchronized LibManager getInst()
	{
		if(inst==null)
		{
			inst=new LibManager();
		}
		return inst;
	}
	
	public void addBook(Book b)
	{
		b.setAvailable(true);
		catalog.put(b.getIsbn(), b);
	}
	
	public void removeBook(String isbn)
	{
		catalog.remove(isbn);
	}
	
	public Book getBook(String s)
	{
		return catalog.get(s);
	}
	
	public void regMember(Member m)
	{
		members.put(m.getMemberId(), m);
	}
	
	public void unRegMemeber(String id)
	{
		members.remove(id);
	}
	
	public Member getMember(String id)
	{
		return members.get(id);
	}
	
	
	public synchronized void borrowBook(String mId,String bId)
	{
		Member m=getMember(mId);
		Book b=getBook(bId);
		
		if(m!=null && b!=null && b.isAvailable())
		{
			if(m.getBorowedBooks().size()<MAX_BOOKS_PER_MEMBER)
			{
				m.borrowBook(b);
				b.setAvailable(false);
				System.out.println("Book borrowed by :"+b.getTitle()+"by "+m.getName());
			}else
			{
				System.out.println("Max books limit over");
			}
		}else
		{
			System.out.println("member or book not found");
		}
	}
	
	public synchronized void returnbook(String mId,String bId)
	{
		Member m=getMember(mId);
		Book b=getBook(bId);
		
		if(m!=null && b!=null)
		{
		
				m.returnBook(b);
				b.setAvailable(true);
				System.out.println("Book returned");
			
		}else
		{
			System.out.println("member or book not found");
		}
	}
	
	public List<Book> searchBooks(String keyword)
	{
		List<Book> matchBooks=new ArrayList<>();
		for(Book b:catalog.values())
		{
			if(b.getTitle().contains(keyword))
			{
				matchBooks.add(b);
			}
		}
		
		return matchBooks;
	}
	
	

}
