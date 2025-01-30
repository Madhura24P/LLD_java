package com.DesignPatterns.Creational;

//Singleton class
public class Singleton {
 // Static variable to hold the single instance of the class
 private static volatile Singleton instance;

 // Private constructor to prevent instantiation from other classes
 private Singleton() {
 }

 // Static method to provide access to the single instance
 public static Singleton getInstance() {
     if (instance == null) {
         synchronized (Singleton.class) {
             if (instance == null) {
                 instance = new Singleton();
             }
         }
     }
     return instance;
 }

 // Method to demonstrate the Singleton behavior
 public void showMessage() {
     System.out.println("Hello from Singleton!");
 }
 
 public static void main(String[] args) {
     // Get the single instance of the Singleton class
     Singleton singleton = Singleton.getInstance();

     // Call the method to demonstrate Singleton behavior
     singleton.showMessage();
 }
}



