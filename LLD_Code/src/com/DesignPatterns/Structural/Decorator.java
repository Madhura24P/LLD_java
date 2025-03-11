package com.DesignPatterns.Structural;

public class Decorator {
	//Additional 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		     Coffee coffee = new SimpleCoffee();
		     System.out.println(coffee.getDescription() + " $ " + coffee.getCost());

		     coffee = new MilkDecorator(coffee);
		     System.out.println(coffee.getDescription() + " $ " + coffee.getCost());

		     coffee = new SugarDecorator(coffee);
		     System.out.println(coffee.getDescription() + " $ " + coffee.getCost());
		 }

	}



//Component interface
interface Coffee {
 String getDescription();
 double getCost();
}

//Concrete Component
class SimpleCoffee implements Coffee {
 public String getDescription() {
     return "Simple Coffee";
 }

 public double getCost() {
     return 5.0;
 }
}

//Decorator class
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee coffee) {
     this.decoratedCoffee = coffee;
 }

 public String getDescription() {
     return decoratedCoffee.getDescription();
 }

 public double getCost() {
     return decoratedCoffee.getCost();
 }
}

//Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee coffee) {
     super(coffee);
 }

 public String getDescription() {
     return decoratedCoffee.getDescription() + ", Milk";
 }

 public double getCost() {
     return decoratedCoffee.getCost() + 1.5;
 }
}

class SugarDecorator extends CoffeeDecorator {
 public SugarDecorator(Coffee coffee) {
     super(coffee);
 }

 public String getDescription() {
     return decoratedCoffee.getDescription() + ", Sugar";
 }

 public double getCost() {
     return decoratedCoffee.getCost() + 0.5;
 }
}


