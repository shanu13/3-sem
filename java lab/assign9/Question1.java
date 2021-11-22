import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   


class Question1
{
	public static void main(String[] args)
	{
	  String str1,str2;
	  str1 = args[0];
	  str2 = args[1];
	  A object1 = new A(str1,str2);
	  object1.start();
	}
}


class A extends Thread
{   String str1,str2;

    A(String s1,String s2)
	{
	  this.str1=  s1;
      this.str2 = s2;
	}	  
	public void run()
 	{
       Scanner myFile1= null;
		try {
			Scanner file1= new Scanner (new File(str1)) ;
			myFile1= file1;
		} catch(FileNotFoundException e) {
			System.out.println("Please check the 1st file not found !!!");
		}
		
		Scanner myFile2= null;
		try {
			Scanner file2= new Scanner (new File(str2)) ;
			myFile2= file2;
		} catch(FileNotFoundException e) {
			System.out.println("Please check the 2nd file not found !!!");
		}
		
		String[] words1= new String[1000];
		String[] words2= new String[1000];
		int i=0;
		while(myFile1.hasNext()) {
			words1[i]= myFile1.nextLine();
			i++;
		}
		int k=0;
		while(myFile2.hasNext()) {
			words2[k]= myFile2.nextLine();
            k++;
        }
        // System.out.println(k);
        // System.out.println(i);
		System.out.println("\nFollowing words are common in both the files with the following details: \n");
		for(int m=0 ;m<i ;m++) 
		{
			for(int n=0 ;n<k ;n++) {
				if(words1[m].equals(words2[n])) {
					System.out.println(words1[m]+" : length "+ words1[m].length() +" appeared in line no. "+ m +" of text_file1.txt and line no. "+ n+" of text_file2.txt");
				    System.out.println("\n");
				}
			}
        }
 
	}
}