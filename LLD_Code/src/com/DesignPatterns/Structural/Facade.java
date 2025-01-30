package com.DesignPatterns.Structural;

public class Facade {
  //reduce the complexity of the subsystem by providing a simpler, high-level interface that is easier to use and understand
	public static void main(String[] args) {
	     ComputerFacade computer = new ComputerFacade();
	     computer.start();
	     computer.shutDown();
	 }
}

//Subsystem class 1
class CPU {
 public void start() {
     System.out.println("CPU started");
 }

 public void execute() {
     System.out.println("CPU executing instructions");
 }

 public void shutDown() {
     System.out.println("CPU shutting down");
 }
}

//Subsystem class 2
class Memory {
 public void load() {
     System.out.println("Memory loaded");
 }

 public void clear() {
     System.out.println("Memory cleared");
 }
 
}

//Subsystem class 3
class HardDrive {
 public void readData() {
     System.out.println("HardDrive reading data");
 }

 public void writeData() {
     System.out.println("HardDrive writing data");
 }
}

//Facade class
class ComputerFacade {
 private CPU cpu;
 private Memory memory;
 private HardDrive hardDrive;

 public ComputerFacade() {
     this.cpu = new CPU();
     this.memory = new Memory();
     this.hardDrive = new HardDrive();
 }

 public void start() {
     cpu.start();
     memory.load();
     hardDrive.readData();
     cpu.execute();
 }

 public void shutDown() {
     cpu.shutDown();
     memory.clear();
     hardDrive.writeData();
 }
}
