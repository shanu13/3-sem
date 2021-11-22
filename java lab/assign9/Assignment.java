import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   



	class Common extends Thread{

	   String s1,s2;
	    
	   Common(){
	    s1 = s2 = null;
	   }
	
	   Common(String w1 , String w2){
	    s1 = w1;
	    s2 = w2; 
	   }

	  public void run(){
	  
	  Scanner myfile1 = null;
	   try{
	        Scanner	file1 = new Scanner(new File(s1));
		  myfile1 = file1;
	      }catch(FileNotFoundException e){
	 	   System.out.println("First File does Not Found....");
	       }
	
	 Scanner myfile2 = null;
	   try{
		Scanner file2 = new Scanner(new File(s2));
		myfile2 = file2;
	      }catch(FileNotFoundException e){
	           System.out.println("Second File Does Not Found ....");
	      }

	    String[] Words1 = new String[1000];
	    String[] Words2 = new String[1000];
	    int i=0,j=0;
	    
	    while(myfile1.hasNext()){
	      Words1[i] = myfile1.nextLine();
	      i++;
	    }
	   
	    while(myfile2.hasNext()){
	      Words2[j] = myfile2.nextLine();
	      j++;
	    }


	   System.out.println("Details are : \n");

	    for(int k=0; k<i; k++){
	        for(int l=0; l<j; l++){
	          if(Words1[k].equals(Words2[l])){
		     System.out.println(Words1[k] + " : length " + Words1[k].length() + " appeared in " + (k+1) + " of " + s1 + " and " + (l+1) + " line in " + s2);
		   }
	       }
	    }

	}

     }




	class Assignment {
	
	public static void main(String[] args){

	  String s1,s2;
	  
	  s1 = args[0];
	  s2 = args[1];
	  Common obj = new Common(s1,s2);
	  obj.start();


	  }

	}