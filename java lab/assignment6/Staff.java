package assignment_5_updated;
public class Staff extends Employee {
	
	final String workAssigned;
	
	 Staff()
	 {
		 super();
		 workAssigned = "";
		 
	 }
	 
	 Staff(String id, String nam, int yr, int sal, String w)
	 {
		 super(id,nam ,yr,sal);
		 workAssigned = w;
		 
	 }
	 
	 final void setDesignation(String s)
	 {
		 designation = s;
		 
	 }
	 
	 void display()
	 {
		 super.display();
	    System.out.println("Work Assigned is : "+  workAssigned);
	    
	 }
	 
	 void display(int year)
	 {
		 if(yearofJoining == year)
		 {
			 super.display();
			    System.out.println("Work Assigned is : "+ workAssigned); 
		 }
	 }
}