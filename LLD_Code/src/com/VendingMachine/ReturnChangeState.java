package com.VendingMachine;

public class ReturnChangeState implements VendingMachineState{
	
private final VendingMachine v;
	
	public ReturnChangeState(VendingMachine v)
	{
		this.v=v;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCoin(Coins c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertNote(Notes n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispenseProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnChange() {
		// TODO Auto-generated method stub
		double change=v.getPayment()-v.getProduct().getPrice();
		if(change>0)
		{
			System.out.println("change returned "+change);
			v.resetPayment();
			v.resetProduct();
			v.setState(v.getIdleState());
		}
		else
		{
			System.out.println("no chnage");
		}
		
	
	}

}
