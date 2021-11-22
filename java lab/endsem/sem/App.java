import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


   class Student {
	  
          String name,Dob;
	  int sem;	
	}

 public class App {




   

public static void main (String[] args){    
  JFrame frame = new JFrame("Shantanu Panel");
  frame.setVisible(true);
  frame.setSize(700,500);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
 


  
  JButton admin = new JButton("Admin");
  admin.setBounds(130,100,100, 40);
  frame.add(admin);
  
JButton user=new JButton("User");  
		user.setBounds(130,160,100, 40);
			  
		frame.add(user);
		
		JButton EX=new JButton("EXIT");  
		EX.setBounds(380,480,50, 50);
			  frame.add(EX);
			  EX.setVisible(true);
		frame.add(user);
		

  JButton add=new JButton("Add Details");  
		add.setBounds(130,100,150,40);
		JButton delete=new JButton("Delete Details");  
		delete.setBounds(130,160,150,40);	

		frame.add(add);
		add.setVisible(false);
		delete.setVisible(false);
		frame.add(delete);	
		
				JLabel l1;  
				l1=new JLabel("Name :");  
				l1.setBounds(50,50, 100,30);
			       frame.add(l1);
				l1.setVisible(false);
	            final JTextField tf1=new JTextField();  
				tf1.setBounds(50,90,150,20);  
				frame.add(tf1);
				tf1.setVisible(false);
				JLabel l2;  
				l2=new JLabel("Roll Number :");  
				l2.setBounds(50,120, 100,30);
				frame.add(l2);
				l2.setVisible(false);
				final JTextField tf2=new JTextField();  
				tf2.setBounds(50,150,150,20);
				frame.add(tf2);
				tf2.setVisible(false);
				JLabel l3;  
				l3=new JLabel("Date OF Birth");  
				l3.setBounds(50,180, 100,30);
				frame.add(l3);
				l3.setVisible(false);
				final JTextField tf3=new JTextField();  
				tf3.setBounds(50,210,150,20);
				frame.add(tf3);
				tf3.setVisible(false);
			    JLabel l4;  
				l4=new JLabel("Semester");  
				l4.setBounds(50,240, 100,30);
				frame.add(l4);
				l4.setVisible(false);
				final JTextField tf4=new JTextField();  
				tf4.setBounds(50,270,150,20);
				frame.add(tf4);
				tf4.setVisible(false);
				
				
					
		
    admin.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	        admin.setVisible(false);
			user.setVisible(false);
            add.setVisible(true);
			delete.setVisible(true);
			
      add.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	         add.setVisible(false);
			 delete.setVisible(false);
			 l1.setVisible(true);
             l2.setVisible(true);	
             tf1.setVisible(true);
             String TF1=tf1.getText();			 
             tf2.setVisible(true);
			 String TF2=tf2.getText();
			 l3.setVisible(true);
             l4.setVisible(true);	
             tf3.setVisible(true);		
             String TF3=tf3.getText();			 
             tf4.setVisible(true);
			 String TF4=tf4.getText(); 
        }  
    });
	
	       }  
    });
    

	JButton viewRoll=new JButton("View Details by Roll no.");  
		viewRoll.setBounds(130,100,150,40);
		JButton viewName=new JButton("View Detail by Name");  
		viewName.setBounds(130,160,150,40);	

		frame.add(viewRoll);
		viewName.setVisible(false);
		viewRoll.setVisible(false);
		frame.add(viewName);	
	
	    user.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	        user.setVisible(false);
			admin.setVisible(false);
            viewName.setVisible(true);
			viewRoll.setVisible(true);
			
			
      delete.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	         viewName.setVisible(false);
			 viewRoll.setVisible(false);
			 l1.setVisible(true);
             l2.setVisible(true);	
             tf1.setVisible(true);
             String TF1=tf1.getText();			 
             tf2.setVisible(true);
			 String TF2=tf2.getText();
			 l3.setVisible(true);
             l4.setVisible(true);	
             tf3.setVisible(true);		
             String TF3=tf3.getText();			 
             tf4.setVisible(true);
			 String TF4=tf4.getText(); 
        }  
    });
	
        }  
    });
	
 
  





}




}