import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Student
{
	String name;
	int age;
	int roll;
	int semester;

	//COnstructor
	Student()
	{
		name = "";
		age = 0;
		roll = 0;
		semester = 0;
	}

	Student(String na, int a, int r, int sem)
	{
		name = na;
		age = a;
		roll =r;
		semester = sem;
	}

	void display()
	{
		System.out.println("Name : " + name);
		System.out.println(" Roll : " + roll);
		System.out.println("Age : " + age);
		System.out.println("Semester : " + semester);
	}
}

class AdminL1 extends Frame implements ActionListener
{
	Frame frame;
	String msg = "";
	Button AddDetails, DeleteDetails, ModifyDetails;

	AdminL1()
	{
		frame = new Frame();
		frame.setSize(new Dimension(1080, 720));
		frame.setTitle("Student Details");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());

		AddDetails = new Button("Add New Details");
		DeleteDetails = new Button("Delete Previous Details");
		ModifyDetails = new Button("Modify Previous Details");

		frame.add(AddDetails);
		frame.add(DeleteDetails);
		frame.add(ModifyDetails);

		AddDetails.addActionListener(this);
		DeleteDetails.addActionListener(this);
		ModifyDetails.addActionListener(this);

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

		if (pressed.equals("AddDetails"))
		{
			msg = "Option to add new Student selected";
		}

		repaint();
	}

	public void paint(Graphics g)
	{
		g.drawString(msg, 20, 100);
	}



}




class UserL1 extends Frame implements ActionListener
{
	Frame frame;
	String msg = "";
	Button ViewName, ViewRoll;

	UserL1()
	{
		frame = new Frame();
		frame.setSize(new Dimension(1080, 720));
		frame.setTitle("Student Details");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());

		ViewName = new Button("View Details by Name");
		ViewRoll = new Button("View Details by Roll No");

		frame.add(ViewName);
		frame.add(ViewRoll);

		ViewName.addActionListener(this);
		ViewName.addActionListener(this);



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

		if (pressed.equals("ViewName"))
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




public class Layout extends Frame implements ActionListener
{
	Frame frame;

	//Level 1 deatails
	String msg = "";
	Button User, Admin;

	//Constructor
	public Layout()
	{

		frame = new Frame();
		frame.setSize(new Dimension(1080, 720));
		frame.setTitle("Student Details");
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());

		//Creating Buttons
		User = new Button("User");
		Admin = new Button("Admin");

		//Adding Buttons to frame
		frame.add(Admin);
		frame.add(User);

		//Add action Listenera to buttons
		Admin.addActionListener(this);
		User.addActionListener(this);

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

		if (pressed.equals("Admin"))
		{
			msg = "Admin Selected";
			AdminL1 adL1 = new AdminL1();
			frame.setVisible(false);
		}
		else if (pressed.equals("User"))
		{
			msg = "User Pressed";
			UserL1 usL1 = new UserL1();
			frame.setVisible(false);
		}

		repaint();
	}

	public void paint(Graphics g)
	{
		g.drawString(msg, 20, 100);
	}



	public static void main(String[] args)
	{
		Layout User = new Layout();


	}
}
