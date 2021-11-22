	import java.util.Scanner;
 	import java.util.ArrayList; 
   

    public abstract class User{
	
	    String name;
	    String password;
	    int UserId;
	    int YearOfJoining;

	User(){
	 this.name = "";
	 this.password = "";
	 this.UserId = -1;	
	}

	User (String name){

	 this.name = name;
	 this.password = "";
	 this.UserId = -1;
	   }

	User(String name, int id){
 	
	 this.name = name;
	 this.UserId = id;
	 this.password = "";

	   }

	User(String name, int id, String password){

	 this.name = name;
	 this.password = password;
	 this.UserId = id;
	 }
	abstract void setYearOfJoining(int year);
 

	void SetDetails(){
          Scanner scan = new Scanner(System.in);
	  System.out.println("Enter Your name");
	  name = scan.next();
  	  System.out.println("Enter Your password");
	  password = scan.next();
	  System.out.println("Enter Your User Id");
	  UserId = scan.nextInt();
	  scan.close();
	  
	   }


	String GetName(){
	  return this.name;
	 }

	String GetPassword(){
	  return this.password;
	 }

   	int GetUserId(){
	  return this.UserId;
	 }

	voi GetDetails(){
          System.out.println("Name : " + this.name);
	  System.out.println("Password : " + this.password);
	  System.out.println("Id : " + this.UserId);
         }

	final boolean Admin(){
	   Scanner input = new Scanner(System.in);
	   System.out.prinln("Enter the admin name");
	   String admin_name = input.next();
	   System.out.prinln("Enter the admin password");
	   String admin_pass = input.next();
	   input.close();
	  
	   if(admin_name == this.name && admin_pass == this.password){
	       System.out.println("Login succeed");
		return true;
		}
	   else
	    return false;

   	  }
  	
	
	   
	  

	}





	public class Student extends User{
	
	final char Grade;
		
	Student()
	{
		super();
		grade = 0;
	}

	Student(int Grade)
	{
		super();
		this.Grade = Grade;
	}

	Student(String name, int ID, String passcode, int Grade)
	{
		super(name, ID, passcode);
		this.Grade = Grade;
	}

	void SetGrade(){
	  {
		super.SetDetails();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the GRADE : ");
		this.Grade = scan.nextInt();

		scan.close();
	}

	 final void setYearOfJoinng(int year) {
		YearOfJoining =  year;
	} 

	  void GetDetails(int ID){
		if (ID == this.getUserID())
		{
			System.out.println("Name : " + this.getName());
			System.out.println("Position : Student");
			System.out.println("Grade : " + this.Grade);
		}
	}
	
	    
	}






	
	public class Faculty extends User{

	final int NoOfPublishers;

	Faculty()
	{
		super();
		NoOfPublishers;
	}

	Faculty(int publisher)
	{
		super();
		this.NoOfPublishers = publisher;
	}

	Faculty(String name, int ID, String passcode, int NoOfPublishers)
	{
		super(name, ID, passcode);
		this.NoOfPublishers = publisher;
	}

	void setDetails()
	{
		super.SetDetails();
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the number of publishments of the faculty : ");
		this.NoOfPublishers  = scan.next();

		scan.close();


	}

        final void setYearOfJoinng(int year) {
		YearOfJoining =  year;
	} 
	
	

	void GetDetails(int ID)
	{
		if (ID == this.GetUserID())
		{
			System.out.println("Name : " + this.getName());
			System.out.println("Position : Faculty");
			System.out.println("Number of publishments : " + this.NoOfPublishers);
		}
	}

	  
	}






	public class Staff extends User{

	final private String Work;

	Staff()
	{
		super();
		Work = "";
	}

	Staff(String pos)
	{
		super();
		Work = pos;
	}

	Staff(String name, int ID, String passcode, String work)
	{
		super(name, ID, code);
		this.Work = work;
	}

	void setDetails()
	{
		super.SetDetails();
         	Scanner scan = new Scanner(System.in);

		System.out.print("Enter the position of the staff : ");
		this.work = scan.next();

		scan.close();


		
	}
 	 
	 final void setYearOfJoinng(int year) {
		YearOfJoining =  year;
	} 

	void GetDetails(int ID)
	{
		if (ID == this.GetUserID())
		{
			System.out.println("Name : " + this.getName());
			System.out.println("Position : Staff");
			System.out.println("Working As a : " + work);
		}
	}

	}







  public class assignment6{

    ArrayList<User> user = new ArrayList<User>();
 	public static void main(String args[]){
	  
	  Scanner input = new Scanner(System.in);
	  
          System.out.print("Select whether user is admin or non-admin.\n 1. Admin\n 2. Non-Admin.\n");
	  int choice = scan.nextInt();

	  switch(choice){

	   case 1:  
   	          if(User.admin()){
		   
	          System.out.println("1. Create Objects\n2. Delete Objects.\n3. Exit");
				int admin_choice = input.nextInt();
	      		switch(admin_choice){
			
			case 1:System.out.println("Select the object to create.");
					System.out.println("1. Student\n2. Faculty\n3. Staff");
					int option = input.nextInt();
					
				switch(option){

				                case 1 : 	
						         user.add(new Student());
							user.get(user.size()-1).SetDetails();
							 break;
						case 2 :
							 user.add(new Faculty());
							user.get(user.size()-1).SetDetails();
							 break;
						case 3 : user.add(new Staff());
							user.get(user.size()-1).SetDetails();
							 break;
				  }
				
	


					case 2:   
					               System.out.println("Press 1 to delete object using Name");
							System.out.println("Press 2 to delete object using User Id");
							ch = scan.nextInt();
							
							switch(ch)
							{
								case 1:
									System.out.print("Enter Name: ");
									name = input.nextLine();
									for(int i=0; i<user.size(); i++)
									{
										if(n==(user.get(i).GetName()))
											user.remove(i);
									}
									break;
									
								case 2:
									System.out.print("Enter User Id: ");
									id = input.nextInt();
									for(int i=0; i<e.size(); i++)
									{
										if(id == (user.get(i).GetUserId()))
										{
											user.remove(i);
										}
									}
									break;
							}
							break;
					}
					break;
				

		       case 3:

			 return ;

			    }


		  }


	        case 2: 	
					System.out.println("Enter 1 to display info using Name");
					System.out.println("Enter 2 to display info using User Id");
					System.out.println("Enter 3 to display info using Year Of Joining");
					c = input.nextInt();
					
					switch(c)
					{
						case '1':
							System.out.print("Enter Name: ");
							n = scan.nextLine();
							for(int i=0; i<user.size(); i++)
							{
								if(n==(user.get(i).GetName()))
								{
									user.get(i).GetDetails();
								}
							}
							break;
							
						case '2':
							System.out.print("Enter User Id: ");
							id = scan.nextLine();
							for(int i=0; i<user.size(); i++)
							{
								if(id==(user.get(i).GetUserId()))
								{
									user.get(i).GetDetails();
								}
							}
							break;
						
						case '3':
							System.out.print("Enter Year of Joining: ");
							y = scan.nextInt();
							
							
							for(int i=0; i<e.size(); i++)
							{
								user.get(i).GetDetails();
							}
							break;
					} 
	   }




	



    	
	}
}