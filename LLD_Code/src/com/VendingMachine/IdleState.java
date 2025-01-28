package com.VendingMachine;

public class IdleState implements VendingMachineState {
	
	private final VendingMachine v;
	
	public IdleState(VendingMachine v)
	{
		this.v=v;
	}

	@Override
	public void selectProduct(Product p) {
		// TODO Auto-generated method stub
		if(v.invt.isAvailable(p))
		{
			v.setProduct(p);
			v.setState(v.getReadyState());
			System.out.println("Product selected:"+p.getName());
		}else
		{
			System.out.println("Producr not avaialable");
		}

	}

	@Override
	public void insertCoin(Coins c) {
		// TODO Auto-generated method stub
		System.out.println("Please select product");

	}

	@Override
	public void dispenseProduct() {
		// TODO Auto-generated method stub
		System.out.println("Please select product");

	}

	@Override
	public void returnChange() {
		// TODO Auto-generated method stub
		System.out.println("No change to return");

	}

	@Override
	public void insertNote(Notes n) {
		// TODO Auto-generated method stub
		System.out.println("Please select propduct");
		
	}

}
