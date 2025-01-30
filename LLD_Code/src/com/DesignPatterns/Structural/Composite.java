package com.DesignPatterns.Structural;



import java.util.ArrayList;
import java.util.List;


public class Composite {
	//simplifies client code by allowing it to treat individual objects and compositions of objects uniformly

	 public static void main(String[] args) {
	        Developer dev1 = new Developer(100, "John Doe", "Senior Developer");
	        Developer dev2 = new Developer(101, "Jane Doe", "Junior Developer");
	        Manager manager1 = new Manager(200, "Mike Manager", "Project Manager");

	        CompanyDirectory engineeringDirectory = new CompanyDirectory();
	        engineeringDirectory.addEmployee(dev1);
	        engineeringDirectory.addEmployee(dev2);

	        CompanyDirectory managerDirectory = new CompanyDirectory();
	        managerDirectory.addEmployee(manager1);

	        CompanyDirectory companyDirectory = new CompanyDirectory();
	        companyDirectory.addEmployee(engineeringDirectory);
	        companyDirectory.addEmployee(managerDirectory);

	        companyDirectory.showEmployeeDetails();
	    }

	
}	

// Component interface
interface Employee {
    void showEmployeeDetails();
}

// Leaf class
class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

// Leaf class
class Manager implements Employee {
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

// Composite class
class CompanyDirectory implements Employee {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        for (Employee emp : employeeList) {
            emp.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}
