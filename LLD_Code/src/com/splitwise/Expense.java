package com.splitwise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Expense {

	private final String expenseId;
	private final double amount;
	private final String description;
	private final Group group;
	private final User paidBy;
	private final List<Split> splits;
	private final Date createdAt;

	public Expense(double amount, String description, User paidBy) {
		super();
		this.expenseId = UUID.randomUUID().toString();
		this.amount = amount;
		this.description = description;
		this.group = null;
		this.paidBy = paidBy;
		this.splits = new ArrayList<>();
		this.createdAt = new Date();
	}

	private Expense(Builder builder) {
		
		this.expenseId=UUID.randomUUID().toString();
		this.amount=builder.amount;
		this.description=builder.description;
		this.paidBy=builder.paidBy;
		this.group=builder.group;
		this.splits=builder.splits;
		this.createdAt=new Date();

	}

	public String getExpenseId() {
		return expenseId;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public Group getGroup() {
		return group;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public static class Builder {
		private double amount;
		private String description;
		private User paidBy;
		private Group group = null;
		private final List<Split> splits = new ArrayList();

		public Builder amount(double amount) {
			this.amount = amount;
			return this;
		}

		public Builder description(String desc) {
			this.description = desc;
			return this;
		}

		public Builder paidBy(User u) {
			this.paidBy = u;
			return this;
		}

		public Builder group(Group g)
		{
			this.group=g;
			return this;
			
		}
		
		public Builder addSplits(List<Split> s)
		{
			this.splits.addAll(s);
			return this;
			
		}
		
		public Expense build()
		{
			if(amount<0 ||paidBy==null || splits.isEmpty())
			{
				throw new IllegalArgumentException("Check input for expense report");
			}
			
			return new Expense(this);
		}
	}

}
