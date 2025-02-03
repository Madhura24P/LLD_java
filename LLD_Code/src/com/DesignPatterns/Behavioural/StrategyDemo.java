package com.DesignPatterns.Behavioural;

public class StrategyDemo {
	
	//use case: collection sorting uses compatrators based on diff strategy
	public static void main(String[] args) {
	     Context context = new Context(new OperationAdd());
	     System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

	     context = new Context(new OperationSubtract());
	     System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

	     context = new Context(new OperationMultiply());
	     System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	 }
}
//Strategy interface
interface Strategy {
 int doOperation(int num1, int num2);
}

//Concrete Strategy classes
class OperationAdd implements Strategy {
 public int doOperation(int num1, int num2) {
     return num1 + num2;
 }
}
class OperationSubtract implements Strategy {
 public int doOperation(int num1, int num2) {
     return num1 - num2;
 }
}

class OperationMultiply implements Strategy {
 public int doOperation(int num1, int num2) {
     return num1 * num2;
 }
}

//Context class
class Context {
 private Strategy strategy;

 public Context(Strategy strategy) {
     this.strategy = strategy;
 }

 public int executeStrategy(int num1, int num2) {
     return strategy.doOperation(num1, num2);
 }
}


