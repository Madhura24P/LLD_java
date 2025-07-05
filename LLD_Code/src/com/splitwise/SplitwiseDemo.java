package com.splitwise;

import java.util.List;
import java.util.Map;

public class SplitwiseDemo {
	
	public static void main(String[] args) {
		SplitwiseService service=SplitwiseService.getInstance();
		
		//create user
		User u1=service.createUser("Alice", "alice@ex.com");
		User u2=service.createUser("Bob", "b.b@gmail.com");
		User u3=service.createUser("Raj", "r.r@yahoo.co.in");
		
		//create group
		Group gr=service.createGroup("Apartment", List.of(u1.getUserId(),u2.getUserId(),u3.getUserId()));
		
		//add expense1
		Expense rentExpense=service.addExpense("rent", 9000.0, u1.getUserId(), gr.getGroupId(), SplitType.EQUAL,
				Map.of(
						u1.getUserId(),3000.0,
						u2.getUserId(),3000.0,
						u3.getUserId(),3000.0
						));
		
		
		 Expense dinnerExpense=service.addExpense("Dinner", 1000.0, u2.getUserId(),
		  gr.getGroupId(), SplitType.EQUAL, Map.of( u2.getUserId(),500.0,
		  u3.getUserId(),500.0 ));
		 
				
				
		service.printBalances();
		
		
	}
}
