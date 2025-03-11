package com.DesignPatterns.Behavioural;

public class ChainRespnsibility {

	
	// Pass reposnibility
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Handler handler1 = new ConcreteHandler1();
	     Handler handler2 = new ConcreteHandler2();

	     handler1.setSuccessor(handler2);

	     handler1.handleRequest("Request1");  // ConcreteHandler1 handled the request
	     handler1.handleRequest("Request2");  // ConcreteHandler2 handled the request
	     handler1.handleRequest("Request3");  // No handler available for the request

	}
	

}

//Handler interface
abstract class Handler {
 protected Handler successor;

 public void setSuccessor(Handler successor) {
     this.successor = successor;
 }

 public abstract void handleRequest(String request);
}

//Concrete Handlers
class ConcreteHandler1 extends Handler {
 public void handleRequest(String request) {
     if ("Request1".equals(request)) {
         System.out.println("ConcreteHandler1 handled the request");
     } else if (successor != null) {
         successor.handleRequest(request);
     }
 }
}

class ConcreteHandler2 extends Handler {
 public void handleRequest(String request) {
     if ("Request2".equals(request)) {
         System.out.println("ConcreteHandler2 handled the request");
     } else if (successor != null) {
         successor.handleRequest(request);
     }
 }
}



