package com.atm;
public class ATMDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATMSystem at=new ATMSystem();
		
		User u=new User("Madhura", "Patil", "24041991", 1991, "Madh2404", 241991);
		Account a=new Account(241991);
		

		User u1=new User("Anu", "Patil", "11041991", 2001, "Anu11", 040404);
		Account a1=new Account(040404);
		
				
		Thread t1=new Thread(()->at.withdrawCash(u, 100, 1991, a));
		Thread t2=new Thread(()->at.withdrawCash(u1, 500, 2001, a1));
		
		t1.start();
		t2.start();
		
		System.out.println("End");
		
		
	}

}
