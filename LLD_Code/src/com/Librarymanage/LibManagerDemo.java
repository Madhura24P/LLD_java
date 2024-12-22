package com.Librarymanage;

import java.util.List;

public class LibManagerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibManager lInst=LibManager.getInst();
		lInst.addBook(new Book("b1","Book1","Auth1",2020));
		
		lInst.regMember(new Member("m1","Raj","r.j@gmail.com"));
		
		lInst.borrowBook("m1", "b1");
		
		lInst.returnbook("m1","b1");
		
		List<Book> bList=lInst.searchBooks("Book");
		
		for(Book b:bList)
		{
			System.out.println(b.getTitle());
		}
		
		
		

	}

}
