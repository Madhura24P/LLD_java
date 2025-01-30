package com.DesignPatterns.Creational;

import java.util.HashMap;
import java.util.Map;


public class Prototype {
	
	public static void main(String[] args) {
        BookRegistry bookRegistry = new BookRegistry();

        Book clonedFictionBook = bookRegistry.getBook("Fiction");
        clonedFictionBook.showDetails();

        Book clonedNonFictionBook = bookRegistry.getBook("NonFiction");
        clonedNonFictionBook.showDetails();
    }

}

// Prototype interface
interface Book extends Cloneable {
    Book clone();
    void showDetails();
}

// Concrete prototype class
class FictionBook implements Book {
    private String title;
    private String author;
    private String genre;

    public FictionBook(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public Book clone() {
        Book clone = null;
        try {
            clone = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public void showDetails() {
        System.out.println("Fiction Book: " + title + " by " + author + " (" + genre + ")");
    }
}

// Concrete prototype class
class NonFictionBook implements Book {
    private String title;
    private String author;
    private String subject;

    public NonFictionBook(String title, String author, String subject) {
        this.title = title;
        this.author = author;
        this.subject = subject;
    }

    @Override
    public Book clone() {
        Book clone = null;
        try {
            clone = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public void showDetails() {
        System.out.println("Non-Fiction Book: " + title + " by " + author + " (Subject: " + subject + ")");
    }
}

// Prototype registry
class BookRegistry {
    private Map<String, Book> bookMap = new HashMap<>();

    public BookRegistry() {
        loadBooks();
    }

    public Book getBook(String bookType) {
        Book cachedBook = bookMap.get(bookType);
        return (cachedBook != null) ? cachedBook.clone() : null;
    }

    private void loadBooks() {
        FictionBook fictionBook = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        NonFictionBook nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", "History");

        bookMap.put("Fiction", fictionBook);
        bookMap.put("NonFiction", nonFictionBook);
    }
}
