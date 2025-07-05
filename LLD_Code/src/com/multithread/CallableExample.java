package com.multithread;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newFixedThreadPool(1);
		
		Callable<String> c=()->{
			return "Hi";
		};
		
		Future<String> f=es.submit(c);
		try {
			f.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Java program to find the longest substring without repeating characters eg. Input - "abcabcbb" Output - "abc"
		
		String s="abcabcbb";
		
		int apt=0;
		int n=s.length();
		int bpt=apt+1;
		List<String> listSubStrings=new ArrayList<>();
		Set<Character> set=new HashSet<>();
				
			while(apt<n)
				{ 
				
				set.add(s.charAt(apt));
				
		     while(bpt<n)
				 {
		    	 
		    	 if(set.contains(s.charAt(bpt)))
		    	 {
		    		 break;
		    	 }
		    	 bpt++;
					 
				 }
				
				String sub=s.substring(apt, bpt);//0,3--abc
				listSubStrings.add(sub);
				apt++; //1 
				bpt=apt+1; 
				
					
				}
			
			String subString=listSubStrings.stream().max(Comparator.comparing(String::length)).get();
			
			int lengMax=listSubStrings.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst().get().length();
			

	}

}
