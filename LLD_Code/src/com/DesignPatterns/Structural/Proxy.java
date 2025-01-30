package com.DesignPatterns.Structural;

public class Proxy {
	
	//use case: place holder for cotrolled access Lazy loading
	public static void main(String[] args) {
	     Image image = new ProxyImage("test_image.jpg");

	     // Image will be loaded from disk
	     image.display();
	     System.out.println("");

	     // Image will not be loaded from disk, because it's already loaded
	     image.display();
	 }
}
//Interface
interface Image {
 void display();
}

//Real subject class
class RealImage implements Image {
 private String fileName;

 public RealImage(String fileName) {
     this.fileName = fileName;
     loadFromDisk(fileName);
 }

 private void loadFromDisk(String fileName) {
     System.out.println("Loading " + fileName);
 }

 @Override
 public void display() {
     System.out.println("Displaying " + fileName);
 }
}

//Proxy class
class ProxyImage implements Image {
 private RealImage realImage;
 private String fileName;

 public ProxyImage(String fileName) {
     this.fileName = fileName;
 }

 @Override
 public void display() {
     if (realImage == null) {
         realImage = new RealImage(fileName);
     }
     realImage.display();
 }
}
