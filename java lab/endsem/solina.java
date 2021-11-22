import javax.swing.*;  
import java.util.*;
import java.awt.event.*;  

public class solina
{  
	public static void main(String[] args)
	{  
		JFrame f=new JFrame();
				  
		JButton Ba=new JButton("Admin");  
		Ba.setBounds(130,100,100, 40);
				  
		f.add(Ba);
				  
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		
		JButton Bu=new JButton("User");  
		Bu.setBounds(130,160,100, 40);
			  
		f.add(Bu);
		
		JButton EX=new JButton("EXIT");  
		EX.setBounds(380,480,50, 50);
			  f.add(EX);
			  EX.setVisible(true);
		f.add(Bu);
		
		
 
		JButton addDetail=new JButton("Add Details");  
		addDetail.setBounds(130,100,150,40);
		JButton deltDetail=new JButton("Delete Details");  
		deltDetail.setBounds(130,160,150,40);	

		f.add(addDetail);
		addDetail.setVisible(false);
		deltDetail.setVisible(false);
		f.add(deltDetail);	
		
				JLabel l1;  
				l1=new JLabel("Name :");  
				l1.setBounds(50,50, 100,30);
			    f.add(l1);
				l1.setVisible(false);
	            final JTextField tf1=new JTextField();  
				tf1.setBounds(50,90,150,20);  
				f.add(tf1);
				tf1.setVisible(false);
				JLabel l2;  
				l2=new JLabel("Roll Number :");  
				l2.setBounds(50,120, 100,30);
				f.add(l2);
				l2.setVisible(false);
				final JTextField tf2=new JTextField();  
				tf2.setBounds(50,150,150,20);
				f.add(tf2);
				tf2.setVisible(false);
				JLabel l3;  
				l3=new JLabel("Date Of Birth");  
				l3.setBounds(50,180, 100,30);
				f.add(l3);
				l3.setVisible(false);
				final JTextField tf3=new JTextField();  
				tf3.setBounds(50,210,150,20);
				f.add(tf3);
				tf3.setVisible(false);
			    JLabel l4;  
				l4=new JLabel("Mobile Number");  
				l4.setBounds(50,240, 100,30);
				f.add(l4);
				l4.setVisible(false);
				final JTextField tf4=new JTextField();  
				tf4.setBounds(50,270,150,20);
				f.add(tf4);
				tf4.setVisible(false);
				
				
					
		
    Ba.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	        Ba.setVisible(false);
			Bu.setVisible(false);
            addDetail.setVisible(true);
			deltDetail.setVisible(true);
			
      addDetail.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	         addDetail.setVisible(false);
			 deltDetail.setVisible(false);
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
	// Admin part over
/*	
		JButton viewRoll=new JButton("View Details by Roll no.");  
		viewRoll.setBounds(130,100,150,40);
		JButton viewName=new JButton("View Detail by Name");  
		viewName.setBounds(130,160,150,40);	

		f.add(viewRoll);
		viewName.setVisible(false);
		viewRoll.setVisible(false);
		f.add(viewName);	
	
	    Bu.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
	  {  
	        Bu.setVisible(false);
			Ba.setVisible(false);
            viewName.setVisible(true);
			viewRoll.setVisible(true);
			
			
      deltDetail.addActionListener(new ActionListener(){  
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
	
 

*/	
	


				  
	
     
		
	}  
}