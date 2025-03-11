package com.DesignPatterns.Behavioural;

public class CommandDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light light = new Light();
	     Command lightOn = new LightOnCommand(light);
	     Command lightOff = new LightOffCommand(light);

	     RemoteControl remote = new RemoteControl();

	     remote.setCommand(lightOn);
	     remote.pressButton(); // The light is on

	     remote.setCommand(lightOff);
	     remote.pressButton(); // The light is off

	}

}

//Command interface
interface Command {
 void execute();
}

//Concrete Command classes
class LightOnCommand implements Command {
 private Light light;

 public LightOnCommand(Light light) {
     this.light = light;
 }

 public void execute() {
     light.on();
 }
}

class LightOffCommand implements Command {
 private Light light;

 public LightOffCommand(Light light) {
     this.light = light;
 }

 public void execute() {
     light.off();
 }
}

//Receiver class
class Light {
 public void on() {
     System.out.println("The light is on");
 }

 public void off() {
     System.out.println("The light is off");
 }
}

//Invoker class
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

