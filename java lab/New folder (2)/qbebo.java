import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements java.io.Serializable
{
	String firstName;
	String lastName;
	int rollNo;
	double cpi;
	int age;

	Student()
	{
		firstName = lastName = "";
		rollNo = 0;
		age = 0;
		cpi = 0.0;

	}

	Student(String first, String last, int roll, int Age, double Cpi)
	{

		firstName = first;
		lastName = last;
		age = Age;
		rollNo = roll;
		cpi = Cpi;
	}

	void DisplayDetails()
	{
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Roll Number: " + rollNo);
		System.out.println("CPI: " + cpi);
		System.out.println("Age : " + age);
		System.out.println();
	}

}

classs q2 
{
	static void Age_18(ArrayList<Student> array)
	{
		for(int i = 0; i < 10; i++)
		{
			if(array.get(i).age <18)
				array.get(i).DisplayDetails();
		}
	}




	static void Student_M(ArrayList<Student>array)
	{
		for(int i=0; i<10; i++)
		{
			if(array.get(i).firstName.charAt(0) == 'M' || array.get(i).firstName.charAt(0) == 'm' )
				array.get(i).DisplayDetails();
		}
	}



	static ArrayList<Student> Deserialize() 
	{
		ArrayList<Student> array_new = new ArrayList<Student>();
		FileInputStream filein;
		ObjectInputStream objin;
		try
		{
			filein = new FileInputStream("Student.ser");
			objin = new ObjectInputStream(filein);

			while(true) {
				array_new.add((Student)objin.readObject());
			}

		} 
		catch(EOFException e) {
			System.out.println("Deserialization completed");
		}
		catch(IOException e) {
			System.out.println("Error occured while deserialization");
			System.out.println(e);
			System.out.println();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error occured while deserialization");
			System.out.println(e);
			System.out.println();
		}

		return array_new;
	}





	static void Serialize(ArrayList<Student> array) {

		try {
			FileOutputStream fileout = new FileOutputStream("Student.ser");
			ObjectOutputStream objout = new ObjectOutputStream(fout);

			for(int i=0; i<arr.size(); i++) {
				objout.writeObject(array.get(i));
			}
			objout.close();
			fileout.close();
			System.out.println("Serialization completed");
		}
		catch (IOException e) {
			System.out.println("Error occured while serialization");
			System.out.println(e);
			System.out.println();
		}
	}




	static void SetDetails(ArrayList<Strudent> array){
		Scanner scan = new Scanner.(System.in);
		String first,last;
		int roll,Age;
		double Cpi;

		System.out.println("Enter details of 10 Students");
		for(int i=0; i<10; i++){
			System.out.print("Enter First Name: ");
			first = scan.next();
			System.out.print("Enter Last Name: ");
			last = scan.next();
			System.out.print("Enter Roll Number: ");
			roll = scan.nextInt();
			System.out.print("Enter CPI: ");
			Cpi = scan.nextDouble();
			System.out.println("Ethe your age");
			Age = scan.nextInt();
			System.out.println();
			array.add(new Student(first, last, roll,Age,Cpi));
		}
		scan.close();
	}

	public static void main(String args[]){

		ArrayList<Student> array = new ArrayList<Student>();
		SetDetails(array);
		Serialize(array);
		array = Deserialize();
		Student_M(array);
	}



}