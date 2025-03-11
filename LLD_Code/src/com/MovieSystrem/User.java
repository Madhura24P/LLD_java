package com.MovieSystrem;

import java.util.Objects;

public class User {
	
	private final String name;
	private final String email;
	private final int mobileNum;
	public User(String name, String email, int mobileNum) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNum = mobileNum;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getMobileNum() {
		return mobileNum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
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
		return Objects.equals(email, other.email);
	}
	
	

}
