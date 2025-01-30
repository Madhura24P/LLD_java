package com.DesignPatterns.Creational;

public class AbstractFactoryDemo {

	//Abstraction over factory 
	public static void main(String[] args) {
	     // Get Shape Factory
	     AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

	     // Get an object of Shape Circle
	     Shape_af shape1 = shapeFactory.createShape("CIRCLE");
	     shape1.draw();

	     // Get an object of Shape Square
	     Shape_af shape2 = shapeFactory.createShape("SQUARE");
	     shape2.draw();

	     // Get Color Factory
	     AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

	     // Get an object of Color Red
	     Color color1 = colorFactory.createColor("RED");
	     color1.fill();

	     // Get an object of Color Blue
	     Color color2 = colorFactory.createColor("BLUE");
	     color2.fill();
	 }

}
//Abstract product interfaces
interface Shape_af {
 void draw();
}

interface Color {
 void fill();
}

//Concrete product classes implementing Shape
class Circle_af implements Shape_af {
 @Override
 public void draw() {
     System.out.println("Drawing a Circle");
 }
}

class Square_af implements Shape_af {
 @Override
 public void draw() {
     System.out.println("Drawing a Square");
 }
}

//Concrete product classes implementing Color
class Red implements Color {
 @Override
 public void fill() {
     System.out.println("Filling with Red color");
 }
}

class Blue implements Color {
 @Override
 public void fill() {
     System.out.println("Filling with Blue color");
 }
}

//Abstract factory interface
interface AbstractFactory {
 Shape_af createShape(String shapeType);
 Color createColor(String colorType);
}

//Concrete factory classes implementing the abstract factory
class ShapeFactory_af implements AbstractFactory {
 @Override
 public Shape_af createShape(String shapeType) {
     if (shapeType == null) {
         return null;
     }
     if (shapeType.equalsIgnoreCase("CIRCLE")) {
         return new Circle_af();
     } else if (shapeType.equalsIgnoreCase("SQUARE")) {
         return new Square_af();
     }
     return null;
 }

 @Override
 public Color createColor(String colorType) {
     return null;
 }
}

class ColorFactory implements AbstractFactory {
 @Override
 public Color createColor(String colorType) {
     if (colorType == null) {
         return null;
     }
     if (colorType.equalsIgnoreCase("RED")) {
         return new Red();
     } else if (colorType.equalsIgnoreCase("BLUE")) {
         return new Blue();
     }
     return null;
 }

 @Override
 public Shape_af createShape(String shapeType) {
     return null;
 }
}

//Factory producer class to generate the factories
class FactoryProducer {
 public static AbstractFactory getFactory(String choice) {
     if (choice.equalsIgnoreCase("SHAPE")) {
         return new ShapeFactory_af();
     } else if (choice.equalsIgnoreCase("COLOR")) {
         return new ColorFactory();
     }
     return null;
 }
}

