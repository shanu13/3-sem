import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

	public class User{
	  String first_name;
	  String last_name;
	  String PAN;
	  String Email;
	  String address_PIN;

  	    User()
	    {
    	    first_name = last_name = PAN = Email = address_PIN = " ";
	    }
	    User( String first, String last ,String pan, String email, String pin)
	       {
	
	       first_name = first;
	       last_name = last;
	       PAN = pan;
	       Email  email;
	       address_PIN = pin ;	      
	      
	       }

	    void display ()
	   {

	   System.out.println("First Name : " + first_name);
	   System.out.println("Last Name : " + last_name);
	   System.out.println("PAN : " + PAN);
	   System.out.println("Email : " + Email);
           System.out.println(" Address PIN : " + adress_PIN);

	    }


	 }



	public class Student extends User
	 {

	 int roll_no;
  
             Student()
	     {
	       super();
	       roll_no = 0;
	     }

	  Student(String first , Striing last, String pan , String email, String pin , int Roll)
	   {
		super(first, last, pan, email, pin);
	        roll_no = Roll;
 	   }

	   void display()
	   {
	
	     super.display();
	     System.out.println("ROll NO : " + roll_no);
	    
	   } 

        }


	public class Faculty extends User
	 {

	 int employee_id;
	
	   Faculty()
	   {
	     super();
	    employee_id = 0;
	   }


	 Faculty(String first , Striing last, String pan , String email, String pin , int id)
	 {
	  super(first, last, pan, email, pin);
	   employee_id  = id;
	 }

	 void display()
	 {
           super.display();
           System.out.println("Employee ID : " + employee_id);
	 
         }


        }




	public class InvalidName extends Exception
	{
	  InvalidName(String str)
	  {
	   super(str);
	  }	

	}

	public class InvalidPAN extends Exception
	{
	   InvalidPAN(String str)
	    {
	    super(str);
	    }
	}

	public class InvalidEmail extends Exception
	{
	   InvalidEmail(String str)
	    {
	    super(str);
	    }
	}

	 public class InvalidPIN extends Exception
	{
	   InvalidPIN(String str)
	    {
	    super(str);
	    }
	}
	


    public class assignment {
	
	



	
	
	  public static void main(String args[]){



static String first,last,pan,email,pin;
	
	static void validate_Name(String str) throws InvalidName
	{
	   char ch;
	    for(int i=0; i<str.length(); i++)
	   {
	      ch  = str.charAt(i);
	     if((ch < 'A' || ch > 'Z') && (ch <'a' || ch > 'z'))
	     {
	       throw new InvalidName("Error ! NAme should contain only alphabets");
	     }   
	     
   	   }
        }



	static void validate_PAN(String str) throws InvalidPAN
	{
	   char ch;

	   if(str.charAt(0)<'A' || str.charAt(0)>'Z')
	     {
		throw new InvalidEmail("Error ! First Charter should be capital");
	     }
	      for(int i=0; i<str.length(); i++)
	      {
	      ch  = str.charAt(i);
	     if((ch < 'A' || ch > 'Z') && (ch <'a' || ch > 'z') && (ch >'9' && ch <'0'))
	     {
	       throw new InvalidName("Error ! Check your PAN ");
	     }   
	     
   	    }
        }
		


	static void validate_Email(String str) throws InvalidEmail
	{
	  
	   int a = s.indexOf('@');
		
		if(a == -1 || a != s.lastIndexOf('@') || a == 0 || a == s.length()-1)
			throw new InvalidEmail("Error! Invalid Email ID");
	
        }

	
   	static void validate_PIN(String str) throws InvalidPIN
	{
	  if(str.length()!=6)
	  {
	   throw new InvalidPIN ("Error! PIn should contain exactly 6 digits");
	  }
	 char ch;
	   for(int i=0; i<str.length(); i++)
	   {
	     ch = str.charAt(i);
	     if(ch < '0' || ch > '9')
 	     {
	       throw new InvalidPIN ("Error ! PIN should only contains numbers ");
	     }
	   }		
	   
        }


	 Scanner scan = new Scanner(System.in);

  	static void  getDetails()
	{
	boolean flag ;
	  do 
	  {
	   flag = false ;
  	  try{
	       System.out.println("Enter your first name");
		first = scan.next();
	        validate_Name(first);
	     }
	
	  catch(InvalidName e)
	   {
	   System.print.ln(e);
	   flag = true;
	   }
	  
	 }

	while(flag);
	
	  do 
	  {
	   flag = false ;
  	  try{
	       System.out.println("Enter your last name");
		last = scan.next();
	        validate_Name(last);
	     }
	
	  catch(InvalidName e)
	   {
	   System.print.ln(e);
	   flag = true;
	   }
	  
	 }
	 while(flag);


	  do 
	  {
	   flag = false ;
  	  try{
	       System.out.println("Enter your PAN ");
		pan = scan.next();
	        validate_PAN(pan);
	     }
	
	  catch(InvalidName e)
	   {
	   System.print.ln(e);
	   flag = true;
	   }
	  
	 }
	 while(flag);

	
	  do 
	  {
	   flag = false ;
  	  try{
	       System.out.println("Enter your EMAIL ");
		email = scan.next();
	        validate_Email(email);
	     }
	
	  catch(InvalidName e)
	   {
	   System.print.ln(e);
	   flag = true;
	   }
	  
	 }
	 while(flag);


	
	  do 
	  {
	   flag = false ;
  	  try{
	       System.out.println("Enter your Address PIN ");
		pin = scan.next();
	        validate_PIN(pin);
	     }
	
	  catch(InvalidName e)
	   {
	   System.print.ln(e);
	   flag = true;
	   }
	  
	 }
	 while(flag);

     }
	}





























	  ArrayList<User> array = new ArrayList<User>();
	  boolean flag = true, temp;
	  int choice;
	  int a;
	
	   first = last = email = pan = pin = " ";
	    int a = 0;
            int i=0;

	  while(flag)
	 {
	  System.out.println("Enter 1 to create Student ");
	  System.out.println("Enter 2 to create Faculty ");
	  System.out.println("Enter 3 to Display Details ");
	  System.out.println("Enter 4 to Exit ");
	  
	  choice = scan.nextInt();
 
	  switch(choice)
	  {
	      case 1 : 
			getDetails();
			do 
			{
			 f = false;
 			 try{
			    System.out.println("Enter your Rolll NO");
			     a = scan.nextInt();
			     
			    }
			 catch(InputMismatchException e)
			 {
			 System.out.println(e + "Error! Invalid Roll NO");
			 scan.nextLine();
			 f = true;
			 }
			} while(f);
		  array.add(new Student(first, last, pan, email, pin, a));
					break;


	    case 2 : 
		     getDetails();
		     do
			{
			    f = false;
					try {
						System.out.print("Enter Employee ID: ");
						  a = scan.nextInt();
					    }
						catch(InputMismatchException e)
						{
							System.out.println(e + ": Error! Invalid Employee ID");
							scan.nextLine();
							f = true;
						}
					}while(f);
					
					array.add(new Faculty(first, last, pan, email, pin, a));
					break;

	    case 3 :                     for(i=0; i<array.size(); i++)
						array.get(i).display();
					        break;

	    case 4:                 flag = false;
					break;
					 
		  
	       } 
	  System.out.println("");     	   

	 }
  	 
	scan.close();


	     }

	}