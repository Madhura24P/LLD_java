package com.Librarymanage;

public class Book {
	
	private final String isbn;
	private final String title;
	private final String author;
	private final int publicationYear;
	private boolean available;
	
	public Book(String isbn,String title,String author,int year)
	{
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.publicationYear=year;
	}
	
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	
	

}
