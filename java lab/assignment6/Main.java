import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> e = new ArrayList<Employee>();
		boolean flag = true;
		int ch;
		char c;
		String temp;
		String id, n;
		int s, y;
		
		while(flag)
		{
			System.out.println("Press 1 to display Admin options");
			System.out.println("Press 2 to display Non-Admin options");
			System.out.println("Press 3 to Exit");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
					System.out.println("Press a to create new Object");
					System.out.println("Press b to delete Existing Object");
					c = sc.next().charAt(0);
					
					switch(c)
					{
						case 'a':
							System.out.println("Press 1 to create Faculty Object");
							System.out.println("Press 2 to create Staff Object");
							System.out.println("Press 3 to create Temporary Employee Object");
							ch = sc.nextInt();
							temp = sc.nextLine();
							
							switch(ch)
							{
								case 1:
									int nop;
									String sp;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									System.out.print("Enter No of Publication: ");
									nop = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Specialization: ");
									sp = sc.nextLine();
									e.add(new Faculty(id, n, y, s, nop, sp));
									break;
									
								case 2:
									String w;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Work Assigned: ");
									w = sc.nextLine();
									e.add(new Staff(id, n, y, s, w));
									break;
									
								case 3:
									String d;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Department: ");
									d = sc.nextLine();
									e.add(new TemporaryEmployee(id, n, y, s, d));
									break;
							}
							break;
							
						case 'b':
							System.out.println("Press 1 to delete object using Name");
							System.out.println("Press 2 to delete object using User Id");
							ch = sc.nextInt();
							temp = sc.nextLine();
							
							switch(ch)
							{
								case 1:
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									for(int i=0; i<e.size(); i++)
									{
										if(n.equals(e.get(i).name))
											e.remove(i);
									}
									break;
									
								case 2:
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									for(int i=0; i<e.size(); i++)
									{
										if(id.equals(e.get(i).userId))
											e.remove(i);
									}
									break;
							}
							break;
					}
					break;
				
				case 2:
					System.out.println("Press a to display info using Name");
					System.out.println("Press b to display info using User Id");
					System.out.println("Press c to display info using Year Of Joining");
					c = sc.next().charAt(0);
					temp = sc.nextLine();
					
					switch(c)
					{
						case 'a':
							System.out.print("Enter Name: ");
							n = sc.nextLine();
							for(int i=0; i<e.size(); i++)
							{
								if(n.equals(e.get(i).name))
									e.get(i).display();
							}
							break;
							
						case 'b':
							System.out.print("Enter User Id: ");
							id = sc.nextLine();
							for(int i=0; i<e.size(); i++)
							{
								if(id.equals(e.get(i).userId))
									e.get(i).display();
							}
							break;
						
						case 'c':
							System.out.print("Enter Year of Joining: ");
							y = sc.nextInt();
							temp = sc.nextLine();
							
							for(int i=0; i<e.size(); i++)
								e.get(i).display(y);
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
		sc.close();
	}
}
