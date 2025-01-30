package com.DesignPatterns.Structural;


import java.util.HashMap;
import java.util.Map;

public class Flyweight {
	
	// Use case: string pool 
	// reduce the memory usage by sharing as much data as possible with similar objects
	  private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

	    public static void main(String[] args) {
	        for (int i = 0; i < 20; i++) {
	            Circle_fly circle = (Circle_fly) ShapeFactory.getCircle(getRandomColor());
	            circle.setX(getRandomX());
	            circle.setY(getRandomY());
	            circle.setRadius(100);
	            circle.draw();
	        }
	    }

	    private static String getRandomColor() {
	        return colors[(int) (Math.random() * colors.length)];
	    }

	    private static int getRandomX() {
	        return (int) (Math.random() * 100);
	    }

	    private static int getRandomY() {
	        return (int) (Math.random() * 100);
	    }}

// Flyweight interface
interface Shape_fly {
    void draw();
}

// Concrete Flyweight class
class Circle_fly implements Shape_fly {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle_fly(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape_fly> circleMap = new HashMap<>();

    public static Shape_fly getCircle(String color) {
        Circle_fly circle = (Circle_fly) circleMap.get(color);

        if (circle == null) {
            circle = new Circle_fly(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
