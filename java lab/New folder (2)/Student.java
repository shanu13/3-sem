public class Student implements java.io.Serializable{
	String firstName;
	String lastName;
	int rollNumber;
	double cpi;
	
	Student() {
		firstName = lastName = "";
		rollNumber = 0;
		cpi = 0;
	}
	
	Student(String f, String l, int r, double c) {
		firstName = f;
		lastName = l;
		rollNumber = r;
		cpi = c;
	}
	
	void display() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("CPI: " + cpi);
		System.out.println();
	}
}
