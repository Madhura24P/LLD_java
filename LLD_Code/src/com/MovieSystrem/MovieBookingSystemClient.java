package com.MovieSystrem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieBookingSystemClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u1=new User("Madhura","mp@gmail.com",123456789);
		
		//Add Movie
		Movie m1=new Movie("M1","Movie 1",120);
		Movie m2=new Movie("M2","Movie 2",135);
		
		//Add Theatres
		Theatre t1=new Theatre("T1","Theatre 1",new ArrayList<>());
		Theatre t2=new Theatre("T2","Theatre 2",new ArrayList<>());
		
		
		//Add show
		MovieShow s1=new MovieShow("s1",m1,t1,LocalDateTime.now(),LocalDateTime.now().plusMinutes(m1.getDuration()),createSeat(10,10));
		
	
	}
	
	private static Map<String,Seat> createSeat(int row,int col)
	{
		Map<String,Seat> seatMap=new HashMap<>();
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				String seatId=row+"-"+col;
				SeatType type=row<=2?SeatType.PREMIUM:SeatType.NORMAL;
				double price=(type==SeatType.PREMIUM)?150.0:100.0;
				Seat seat=new Seat(seatId,type,row,col,price,SeatStatus.AVAILABLE);
			}
		}
		
		return seatMap;
		
	}


}


