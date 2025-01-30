package com.DesignPatterns.Creational;

public class FactoryPattern {

	//Vehicle Interface 
	//Bike Impl class , Car Impl class 
	public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        ShapeFactory squareFactory = new SquareFactory();
        ShapeFactory rectangleFactory = new RectangleFactory();

        circleFactory.drawShape();
        squareFactory.drawShape();
        rectangleFactory.drawShape();
    }
}

	
//Product interface
	interface Shape {
	    void draw();
	}

	// Concrete product classes
	class Circle implements Shape {
	    @Override
	    public void draw() {
	        System.out.println("Drawing a Circle");
	    }
	}

	class Square implements Shape {
	    @Override
	    public void draw() {
	        System.out.println("Drawing a Square");
	    }
	}

	class Rectangle implements Shape {
	    @Override
	    public void draw() {
	        System.out.println("Drawing a Rectangle");
	    }
	}

	// Creator class with the factory method
	abstract class ShapeFactory {
	    abstract Shape createShape();

	    void drawShape() {
	        Shape shape = createShape();
	        shape.draw();
	    }
	}

	// Concrete creator classes
	class CircleFactory extends ShapeFactory {
	    @Override
	    Shape createShape() {
	        return new Circle();
	    }
	}

	class SquareFactory extends ShapeFactory {
	    @Override
	    Shape createShape() {
	        return new Square();
	    }
	}

	class RectangleFactory extends ShapeFactory {
	    @Override
	    Shape createShape() {
	        return new Rectangle();
	    }
	}

