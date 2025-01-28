package com.VendingMachine;

public class ReadyState implements VendingMachineState {
private final VendingMachine v;
	
	public ReadyState(VendingMachine v)
	{
		this.v=v;
	}

	@Override
	public void selectProduct(Product p) {
		// TODO Auto-generated method stub
		System.out.println("Product selected");

	}

	@Override
	public void insertCoin(Coins c) {
		// TODO Auto-generated method stub
		v.addCoin(c);
		System.out.println("coin inserted");
		checkPayment();
		

	}

	@Override
	public void dispenseProduct() {
		// TODO Auto-generated method stub
		System.out.println("Make payment");

	}

	@Override
	public void returnChange() {
		// TODO Auto-generated method stub
		System.out.println("Make payment");

	}

	@Override
	public void insertNote(Notes n) {
		// TODO Auto-generated method stub
		v.addNote(n);
		System.out.println("note inseryted");
		checkPayment();
		
	}
	
	
	private void checkPayment()
	{
		if(v.getPayment()>=v.getProduct().getPrice())
		{
			v.setState(v.getDispenseState());
		}
	}

}
