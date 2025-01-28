package com.VendingMachine;

public class VendingMachine {
	
	private static volatile VendingMachine instance;
	
	Inventory invt;
	private final VendingMachineState idleState;
	private final VendingMachineState readyState;
	private final VendingMachineState dispenseState;
	private final VendingMachineState returnChangeState;
	private  VendingMachineState currState;
	private Product p;
	private double payment;
	
	private VendingMachine()
	{
		invt=new Inventory();
		idleState=new IdleState(this);
		readyState=new ReadyState(this);
		dispenseState=new DispenseState(this);
		returnChangeState=new ReturnChangeState(this);
		currState=idleState;
		p=null;
		payment=0.0;
		
	}
	
	public static VendingMachine getInst()
	{
		if(instance==null)
		{
			synchronized(VendingMachine.class)
			{
				if(instance==null)
				{
					instance=new VendingMachine();
				}
				
			}
			
		}
		
		return instance;
	}
	
	
	
	public void selectProduct(Product p)
	{
		currState.selectProduct(p);
	}
	
	public void insertCoins(Coins c)
	{
	  currState.insertCoin(c);	
	}
	
	public void insertNote(Notes n)
	{
		currState.insertNote(n);
	}
	
	
	public void dispenseProduct()
	{
		currState.dispenseProduct();
	}
	
	public void returnChange()
	{
		currState.returnChange();
	}
	
	
	
	void setState(VendingMachineState st)
	{
		currState=st;
	}
	
	void setProduct(Product p)
	{
		this.p=p;
	}
	
	VendingMachineState getIdleState()
	{
		return idleState;
	}

	
	VendingMachineState getReadyState()
	{
		return readyState;
	}
	
	VendingMachineState getDispenseState()
	{
		return dispenseState;
	}
	
	VendingMachineState getReturnChangeState()
	{
		return returnChangeState;
	}
	
	Product getProduct()
	{
		return p;
	}
	
	void addCoin(Coins c)
	{
		payment+=c.getValue();
	}
	
	void addNote(Notes n)
	{
		payment+=n.getValue();
	}
	
	double getPayment()
	{
		return payment;
	}
	
	void resetPayment()
	{
		payment=0.0;
	}
	
	void resetProduct()
	{
		p=null;
	}


	
	
	
}
