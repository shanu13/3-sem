import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class Layout extends Frame implements ActionListener
{
	String msg = "";
	Button User, Admin;

	//Constructor
	public Layout()
	{
		setLayout(new FlowLayout());

		//Creating Buttons
		User = new Button("User");
		Admin = new Button("Admin");

		//Adding Buttons to frame
		add(Admin);
		add(User);

		//Add action Listenera to buttons
		Admin.addActionListener(this);
		User.addActionListener(this);




		addWindowListener (new WindowAdapter()
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
		}
		else if (pressed.equals("User"))
		{
			msg = "User Pressed";
		}

		
	}

	public void paint(Graphics g)
	{
		g.drawString(msg, 20, 100);
	}



	public static void main(String[] args)
	{
		Layout User = new Layout();
		User.setSize(new Dimension(1080, 720));
		User.setTitle("College");
		User.setVisible(true);
		
	}
}
