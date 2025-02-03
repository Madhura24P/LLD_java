package com.atm;

public class ATMSystem {
	
	private static volatile ATMSystem inst;
	
	public static ATMSystem getInst()
	{
		if(inst==null)
		{
			synchronized(ATMSystem.class)
			{
				if(inst==null)
				{
					
				inst =new ATMSystem();	
					
				}
				
			}
		}
		
		return inst;
	}
	
	
	
	public void withdrawCash(User u,Integer Amt ,int pin,Account a)
	{
		if(Authenticate.isValid(u.getuId(), pin))
		{
			int curr=a.withdrawAmt(Amt, u);
			System.out.println("Curr Balance:"+curr+":"+u.getuId());
			
		}else
		{
			throw new RuntimeException("Invalid pin");
		}
		
	}

}
