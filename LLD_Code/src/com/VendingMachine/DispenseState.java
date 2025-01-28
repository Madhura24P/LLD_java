package com.VendingMachine;

public class DispenseState implements VendingMachineState {
private final VendingMachine v;
	
	public DispenseState(VendingMachine v)
	{
		this.v=v;
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
	public void dispenseProduct() {
		// TODO Auto-generated method stub
		v.setState(v.getReadyState());
		
		Product p=v.getProduct();
		v.invt.updateQty(p, v.invt.getQty(p)-1);
		System.out.println("Product dispensed");
		v.setState(v.getReturnChangeState());
	}

	@Override
	public void returnChange() {
		// TODO Auto-generated method stub
		System.out.println("Please collect change");

	}

	@Override
	public void insertNote(Notes n) {
		// TODO Auto-generated method stub
		
	}

}
