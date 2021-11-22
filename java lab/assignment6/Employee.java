package assignment_5_updated;


abstract  class Employee {
	String userId;
	String name;
	String designation;
	int salary;
	final int joiningYear;

	Employee(){
		userId = "";
		name = "";
		joiningYear = -1;
		salary = 0;
		
	}
	
	Employee(String id, String nam, int yr, int sal){
		userId = id;
		name= nam;
		salary = sal;
		joiningYear = yr;
		
	}
	
	final void salaryUpdate(int sal) {
		salary = sal;
	}
	
	abstract void setDesignation(String s);
	
	void display() {
		System.out.println("The user id is: "+userId);
		System.out.println("The name of the Employee is: "+name);
		System.out.println("The Year of joining is: "+joiningYear);
		System.out.println("Salary is: "+salary);
	}
	
	void display(int yr) {
		if(joiningYear == yr) {
			System.out.println("The user id is: "+userId);
			System.out.println("The name of the Employee is: "+name);
			System.out.println("The Year of joining is: "+joiningYear);
			System.out.println("Salary is: "+salary);
		}
	}
}
