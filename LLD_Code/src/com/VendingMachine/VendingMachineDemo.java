package com.VendingMachine;

public class VendingMachineDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VendingMachine v=VendingMachine.getInst();
		
		Product p1=new Product("coke", 2);
		
		v.invt.addProduct(p1, 10);
		  
		v.selectProduct(p1);
		
		v.insertCoins(Coins.PENNY);
		v.insertCoins(Coins.PENNY);
		
		v.dispenseProduct();
		
		v.returnChange();
		
		

	}

}
