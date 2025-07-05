package com.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SplitwiseService {
	
	private static SplitwiseService instance;
	private final Map<String ,User> users;
	private final Map<String,Group> groups;
	private final Map<String,Expense> expenses;
	private final BalanceSheet balanceSheet;
	
	private SplitwiseService()
	{
		users=new ConcurrentHashMap<String, User>();
		groups=new ConcurrentHashMap<String, Group>();
		expenses=new ConcurrentHashMap<String, Expense>();
		balanceSheet=new BalanceSheet();
	}
	
	public static synchronized SplitwiseService getInstance()
	{
		if(instance==null)
		{
			instance=new SplitwiseService();
		}
		
		return instance;
	}
	
	public User createUser(String name,String email)
	{
		User user=new User(name,email);
		users.put(user.getUserId(), user);
		return user;
	}
	
	public Group createGroup(String name,List<String> userIds)
	{
		List<User> members=userIds.stream().map(users::get).collect(Collectors.toList());
		
		Group group=new Group(name,members);
		groups.put(group.getGroupId(), group);
		return group;
		
	}
	
	public Expense addExpense(String description,double amount,String paidByUserId,String groupId
			,SplitType type,Map<String,Double> splitData)
	{
		Expense expense=null;
		User paidBy=users.get(paidByUserId);
		Group group=groups.get(groupId);
		Map<User,Double> userSplitData =new HashMap();
		
		for(Map.Entry<String,Double> entry:splitData.entrySet())
		{
			userSplitData.put(users.get(entry.getKey()), entry.getValue());
		}
		
		SplitStrategy strategy =SplitStrategyFactory.getStrategy(type);
		List<Split> splits=strategy.calculateSplits(userSplitData, amount);
		
		expense=new Expense.Builder().description(description).amount(amount).paidBy(paidBy).group(group).addSplits(splits).build();
		
		expenses.put(expense.getExpenseId(),expense);
		balanceSheet.updateBalance(paidBy, splits);
		
	
		return expense;
	}
	
	public void settle(String fromUserId,String toUserId,double amount)
	{
		User fromUser=users.get(fromUserId);
		User toUser=users.get(toUserId);
		
		balanceSheet.settleBalance(fromUser, toUser, amount);
	
	}
	
	public void printBalances()
	{
		balanceSheet.printBalance();
	}
	

}
