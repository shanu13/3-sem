package assignment_5_updated;

public class TemporaryEmployee extends Employee {
	
	final String department;
	
	 TemporaryEmployee()
	 {
		 super();
		 department = "";
		 
	 }
	 
	 TemporaryEmployee(String id, String nam, int yr, int sal,String d)
	 {
		 super(id,nam,yr,sal);
		 department = d;
		 
	 }
	 
	 final void setDesignation(String s)
	 {
		 designation = s;
		 
	 }
	 
	 void display()
	 {
		 super.display();
	    System.out.println("Department: "+ department);
	    
	 }
	 
	 void display(int year)
	 {
		 if(yearofJoining == year)
		 {
			 super.display();
			    System.out.println("Department: "+ department); 
		 }
	 }
}