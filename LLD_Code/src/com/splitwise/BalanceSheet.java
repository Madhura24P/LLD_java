package com.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {

	private final Map<User,Map<User,Double>> balances;

	public BalanceSheet() {
		super();
		this.balances=new ConcurrentHashMap<User, Map<User,Double>>();
	}
	
	public void updateBalance(User paidBy,List<Split> splits)
	{
		for(Split s:splits)
		{
			User owedBy =s.getUser();
			double amount=s.getAmount();
			
			if(owedBy.equals(paidBy)) continue;
			
			balances.computeIfAbsent(paidBy, k->new HashMap());
			balances.computeIfAbsent(owedBy, k->new HashMap());
			
			balances.get(paidBy).put(owedBy, balances.get(paidBy).getOrDefault(owedBy,0.0)+amount);
			
			balances.get(owedBy).put(paidBy, balances.get(owedBy).getOrDefault(paidBy,0.0)-amount);
			
			
			
			
		}
	}
	
	
	public void settleBalance(User payer,User payee,double amount)
	{
		balances.computeIfAbsent(payee, k->new HashMap());
		balances.computeIfAbsent(payer, k->new HashMap());
		
		double currOwed=balances.get(payee).getOrDefault(payer, 0.0);
		
		if(currOwed<amount)
		{
			throw new IllegalArgumentException("Trying to settle more than owed");
		}
		
		balances.get(payee).put(payer, currOwed-amount);
		balances.get(payer).put(payee, balances.get(payee).getOrDefault(payer, 0.0)+amount);
		
		if(Math.abs(balances.get(payee).get(payer))<1e-6)
		{
			balances.get(payee).remove(payer);
			balances.get(payer).remove(payee);
		}
	}
	
	
	public void printBalance()
	{
		for(User u1:balances.keySet())
		{
			for(User u2: balances.get(u1).keySet())
			{
				double amt=balances.get(u1).get(u2);
				if(amt>0)
				{
					System.out.println(u2.getName()+" owes "+u1.getName()+": "+amt);
				}
			}
		}
	}
	


}
