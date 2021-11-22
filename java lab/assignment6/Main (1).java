package assignment_5_updated;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Employee> e = new ArrayList<Employee>();
		boolean flag = true;
		String id, n;
		int s, y;
		int ch;
		char c;
		String temp;

		while(flag)
		{
			System.out.println("Enter 1 to display Admin options");
			System.out.println("Enter 2 to display Non-Admin options");
			System.out.println("Enter 3 to Exit");
			ch = scan.nextInt();
			
			switch(ch)
			{
				case 1:
					System.out.println("Enter a to create new Object");
					System.out.println("Enter b to delete Existing Object");
					c = scan.next().charAt(0);
					
					switch(c)
					{
						case 'a':
							System.out.println("Enter  1 to create Faculty Object");
							System.out.println("Enter 2 to create Staff Object");
							System.out.println("Enter 3 to create Temporary Employee Object");
							ch = scan.nextInt();
							temp = scan.nextLine();
							
							switch(ch)
							{
								case 1:
									int nop;
									String sp;
									System.out.print("Enter User Id: ");
									id = scan.nextLine();
									System.out.print("Enter Name: ");
									n = scan.nextLine();
									System.out.print("Enter Salary: ");
									s = scan.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = scan.nextInt();
									System.out.print("Enter No of Publication: ");
									nop = scan.nextInt();
									temp = scan.nextLine();
									System.out.print("Enter Specialization: ");
									sp = scan.nextLine();
									e.add(new Faculty(id, n, y, s, nop, sp));
									break;
									
								case 2:
									String w;
									System.out.print("Enter User Id: ");
									id = scan.nextLine();
									System.out.print("Enter Name: ");
									n = scan.nextLine();
									System.out.print("Enter Salary: ");
									s = scan.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = scan.nextInt();
									temp = scan.nextLine();
									System.out.print("Enter Work Assigned: ");
									w = scan.nextLine();
									e.add(new Staff(id, n, y, s, w));
									break;
									
								case 3:
									String d;
									System.out.print("Enter User Id: ");
									id = scan.nextLine();
									System.out.print("Enter Name: ");
									n = scan.nextLine();
									System.out.print("Enter Salary: ");
									s = scan.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = scan.nextInt();
									temp = scan.nextLine();
									System.out.print("Enter Department: ");
									d = scan.nextLine();
									e.add(new TemporaryEmployee(id, n, y, s, d));
									break;
							}
							break;
							
						case 'b':
							System.out.println("Press 1 to delete object using Name");
							System.out.println("Press 2 to delete object using User Id");
							ch = scan.nextInt();
							temp = scan.nextLine();
							
							switch(ch)
							{
								case 1:
									System.out.print("Enter Name: ");
									n = scan.nextLine();
									for(int i=0; i<e.size(); i++)
									{
										if(n.equals(e.get(i).name))
											e.remove(i);
									}
									break;
									
								case 2:
									System.out.print("Enter User Id: ");
									id = scan.nextLine();
									for(int i=0; i<e.size(); i++)
									{
										if(id.equals(e.get(i).userId))
										{
											e.remove(i);
										}
									}
									break;
							}
							break;
					}
					break;
				
				case 2:
					System.out.println("Enter a to display info using Name");
					System.out.println("Enter b to display info using User Id");
					System.out.println("Enter c to display info using Year Of Joining");
					c = scan.next().charAt(0);
					temp = scan.nextLine();
					
					switch(c)
					{
						case 'a':
							System.out.print("Enter Name: ");
							n = scan.nextLine();
							for(int i=0; i<e.size(); i++)
							{
								if(n.equals(e.get(i).name))
								{
									e.get(i).display();
								}
							}
							break;
							
						case 'b':
							System.out.print("Enter User Id: ");
							id = scan.nextLine();
							for(int i=0; i<e.size(); i++)
							{
								if(id.equals(e.get(i).userId))
								{
									e.get(i).display();
								}
							}
							break;
						
						case 'c':
							System.out.print("Enter Year of Joining: ");
							y = scan.nextInt();
							temp = scan.nextLine();
							
							for(int i=0; i<e.size(); i++)
							{
								e.get(i).display(y);
							}
							break;
					}
					break;
				
				case 3:
					System.out.println("Program has been Terminated");
					flag = false;
					break;
					
				default:
					System.out.println("Invalid Command");
			}
			System.out.println();
		}
		scan.close();
	}

}