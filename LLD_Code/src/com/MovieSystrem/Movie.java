package com.MovieSystrem;

import java.util.Objects;

public class Movie {
	
	private final String name;
	private final String id;
	private final int duration;
	public Movie(String name, String id,int duration) {
		super();
		this.name = name;
		this.id=id;
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(name, other.name);
	}
	
	

}
