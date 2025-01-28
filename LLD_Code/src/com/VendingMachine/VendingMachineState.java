package com.VendingMachine;

public interface VendingMachineState {
	
	void selectProduct(Product p);
	
	void insertCoin(Coins c);
	
	void insertNote(Notes n);
	
	void dispenseProduct();
	
	void returnChange();
	

}
