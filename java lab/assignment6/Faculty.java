package assignment_5_updated;


public class Faculty extends Employee {
	
	final String specialization;
	int publicationsNo;
	
	Faculty(){
		super();
		specialization = "";
		publicationsNo = 0;
	}
	
	Faculty(String id, String nam,  int yr, int sal, int pN, String sp){
		super(id, nam, yr, sal);
		publicationsNo = pN;
		specialization = sp;
	}
	
	final void setDesignation(String s) {
		designation s;
	} 
	
	void display() {
		super.display();
		System.out.println("The Specialization is: "+specialization);
		System.out.println("Number of Publications is: "+publicationsNo);
	}
	
	void display(int yr) {
		if(joiningYear == yr) {
			super.display();
			System.out.println("The Specialization is: "+specialization);
			System.out.println("Number of Publications is: "+publicationsNo);
		}
	}
}
