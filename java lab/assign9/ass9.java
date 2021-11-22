import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   



class ass9
{
	public static void main(String[] args)
	{
	  String s1,s2;
	  s1 = args[0];
	  s2 = args[1];
	  A obj1 = new A(s1,s2);
	  obj1.start();
	}
}


class A extends Thread
{   String s1,s2;

    A(String s1,String s2)
	{
	  this.s1=  s1;
      this.s2 = s2;
	}	  
	public void run()
 	{
       Scanner myFile1= null;
		try {
			Scanner file1= new Scanner (new File(s1)) ;
			myFile1= file1;
		} catch(FileNotFoundException e) {
			System.out.println("Please check First file not found !!!");
		}
		
		Scanner myFile2= null;
		try {
			Scanner file2= new Scanner (new File(s2)) ;
			myFile2= file2;
		} catch(FileNotFoundException e) {
			System.out.println("Please check Second file not found !!!");
		}
		
		String[] words1= new String[1000];
		String[] words2= new String[1000];
		int i=0;
		while(myFile1.hasNext()) {
			words1[i]= myFile1.nextLine();
			i++;
		}
		int j=0;
		while(myFile2.hasNext()) {
			words2[j]= myFile2.nextLine();
            j++;
        }
        // System.out.println(j);
        // System.out.println(i);
		System.out.println("\nFollowing words are common in both the files with the following details: \n");
		for(int p=0 ;p<i ;p++) 
		{
			for(int q=0 ;q<j ;q++) {
				if(words1[p].equals(words2[q])) {
					System.out.println(words1[p]+" : length "+ words1[p].length() +" appeared in line no. "+ p +" of demo1.txt and line no. "+ q+" of demo2.txt");
				    System.out.println("\n");
				}
			}
        }
 
	}	
}