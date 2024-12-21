package com.Librarymanage;

import java.util.*;

public class Member {
	
	private final String memberId;
	private final String name;
	private final String contactInfo;
	private final List<Book> borowedBooks;
	
	public Member(String memberId,String name,String info)
	{
		this.memberId=memberId;
		this.name=name;
		this.contactInfo=info;
		this.borowedBooks=new ArrayList<>();
	}
	
	
	public String getMemberId()
	{
		return memberId;
	}
	

	
	public String getName() {
		return name;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", contactInfo=" + contactInfo + ", borowedBooks="
				+ borowedBooks + "]";
	}


	public List<Book> getBorowedBooks() {
		return borowedBooks;
	}


	public void borrowBook(Book b)
	{
		borowedBooks.add(b);
	}
	
	public void returnBook(Book b)
	{
		borowedBooks.remove(b);
	}

}
