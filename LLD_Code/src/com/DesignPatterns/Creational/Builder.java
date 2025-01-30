package com.DesignPatterns.Creational;

public class Builder {
	
	//Use case: set optional params.(using set methods)//
	//It separates the construction of a complex object from its representation, 
	//allowing the same construction process to create different representations.

	public static void main(String[] args) {
	     HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
	     ConstructionEngineer engineer = new ConstructionEngineer(concreteHouseBuilder);

	     House house = engineer.constructHouse();
	     System.out.println("House is: " + house);
	 }

}

//Product class
class House {
 private String foundation;
 private String structure;
 private String roof;
 private String interior;

 public void setFoundation(String foundation) {
     this.foundation = foundation;
 }

 public void setStructure(String structure) {
     this.structure = structure;
 }

 public void setRoof(String roof) {
     this.roof = roof;
 }

 public void setInterior(String interior) {
     this.interior = interior;
 }

 @Override
 public String toString() {
     return "House with foundation: " + foundation + ", structure: " + structure + ", roof: " + roof + ", interior: " + interior;
 }
}

//Builder interface
interface HouseBuilder {
 void buildFoundation();
 void buildStructure();
 void buildRoof();
 void buildInterior();
 House getHouse();
}

//Concrete Builder class
class ConcreteHouseBuilder implements HouseBuilder {
 private House house;

 public ConcreteHouseBuilder() {
     this.house = new House();
 }

 @Override
 public void buildFoundation() {
     house.setFoundation("Concrete, brick, and stone");
     System.out.println("ConcreteHouseBuilder: Foundation complete...");
 }

 @Override
 public void buildStructure() {
     house.setStructure("Concrete walls");
     System.out.println("ConcreteHouseBuilder: Structure complete...");
 }

 @Override
 public void buildRoof() {
     house.setRoof("Concrete slab");
     System.out.println("ConcreteHouseBuilder: Roof complete...");
 }

 @Override
 public void buildInterior() {
     house.setInterior("Painting and fixtures");
     System.out.println("ConcreteHouseBuilder: Interior complete...");
 }

 @Override
 public House getHouse() {
     return this.house;
 }
}

//Director class
class ConstructionEngineer {
 private HouseBuilder houseBuilder;

 public ConstructionEngineer(HouseBuilder houseBuilder) {
     this.houseBuilder = houseBuilder;
 }

 public House constructHouse() {
     this.houseBuilder.buildFoundation();
     this.houseBuilder.buildStructure();
     this.houseBuilder.buildRoof();
     this.houseBuilder.buildInterior();
     return this.houseBuilder.getHouse();
 }
}


