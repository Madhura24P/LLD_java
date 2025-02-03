package com.atm;

import java.util.Objects;

public class User {
	
	private  final String FirstName;
	
	private  final String LastName;
	
	private final String DOB;
	
	private final int pin;
	
	private final String uId;
	
	private final Integer accNum;
	
	public User(String fName,String lName,String DOB,int pin,String uId,Integer accNum)
	{
		this.FirstName=fName;
		this.LastName=lName;
		this.DOB=DOB;
		this.uId=uId;
		this.pin=pin;
		this.accNum=accNum;
		
	}

	public Integer getAccNum() {
		return accNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DOB, FirstName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(DOB, other.DOB) && Objects.equals(FirstName, other.FirstName);
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getDOB() {
		return DOB;
	}

	public int getPin() {
		return pin;
	}

	public String getuId() {
		return uId;
	}
	

	
	
	
	
	
	
	

}
