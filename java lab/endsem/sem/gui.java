import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

  class Student	{
	
	String firstname,lastname;
	int roll,sgpa,sem;

	
	Student()
	{
		firstname = "";
		lastname = "";
		sgpa = 0;
		roll = 0;
		sem = 0;
	}

	Student(String first, String last , int cp, int no, int sm)
	{
		firstname = first;
		lastname = last;
		sgpa = cp;
		roll = no;
		sem = sm;
	}

	void display()
	{
		System.out.println("Name : " + firstname + " " + lastname);
		System.out.println(" Roll : " + roll);
		System.out.println("SGPA : " + sgpa);
		System.out.println("Semester : " + sem);
	}


	
  }





  
class USER extends Frame implements ActionListener
{
	Frame frame;
	String msg = "";
	Button name, roll;

	USER()
	{
		frame = new Frame();
		frame.setSize(new Dimension(1080, 720));
		frame.setTitle("User Panel");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());

		name = new Button("View Details by Name");
		roll = new Button("View Details by Roll No");

		frame.add(name);
		frame.add(roll);

		name.addActionListener(this);
		roll.addActionListener(this);



		frame.addWindowListener (new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});

	}

	public void actionPerformed(ActionEvent ae)
	{
		String pressed = ae.getActionCommand();

		if (pressed.equals("name"))
		{
			msg = "Option to view Students by name has been selected";
		}

		repaint();
	}

	public void paint(Graphics g)
	{
		g.drawString(msg, 20, 100);
	}



}


  class ADMIN extends Frame implements ActionListener {

	Frame frame;
	Button add,delete,modify;
	String msg ="";

	ADMIN()
	{
		frame = new Frame();
		frame.setSize(new Dimension(1080, 720));
		frame.setTitle("Admin Section");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());

		add = new Button("Add Details");
		delete = new Button("Delete Details");
		modify = new Button("Modify  Details");

		frame.add(add);
		frame.add(delete);
		frame.add(modify);

		add.addActionListener(this);
		delete.addActionListener(this);
		modify.addActionListener(this);

		frame.addWindowListener (new WindowAdapter()
		    {
			public void windowClosing(WindowEvent e)
			{
			    System.exit(0);
			}
		});
    	
	 }


	public void actionPerformed(ActionEvent ae)
	{
		String pressed = ae.getActionCommand();

		if (pressed.equals("add"))
		{
			msg = "Option to add new Student selected";
		}

		repaint();
	}



	

		


	
  }
 	






  class gui extends Frame implements ActionListener {
		
		
	Frame frame;
        String msg = "";
	Button admin,user;

	public gui (){
		
	          setLayout(new FlowLayout());
		  setSize(new Dimension(1080, 720));
	          setTitle("Shantanu Panel");
	          setVisible(true);
		
		   user = new Button("USER");
		   admin = new Button("ADMIN");

		  this.add(user);
		  this.add(admin);
		 
		  admin.addActionListener(this);
		  user.addActionListener(this);



  		  addWindowListener (new WindowAdapter(){
		    public void windowClosing(WindowEvent event)
			{
				System.exit(0);
			}
		});
	
	}



		
	public void actionPerformed(ActionEvent ae){


		String click = ae.getActionCommand();

		if (click.equals("Admin"))
		{
		    ADMIN Admin = new ADMIN();
		    frame.setVisible(false);
			
		}
		else if (click.equals("User"))
		{
			USER User = new USER();
			frame.setVisible(false);
		}
		

		
	}




		
		
        public static void main(String[] args){
 	           
	       gui USER = new gui();
		   
	      
		
	       }





	}