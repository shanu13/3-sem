import java.util.LinkedList; 
import java.util.Scanner;

	public class a10 {
	   public static void main(String[] args) throws InterruptedException{

		System.out.println("Enter the buffer size");
		 Scanner scan = new Scanner(System.in);
 		 int buffer = scan.nextInt();
		  scan.close();
			
	    final CP cp = new CP(buffer);
	     Thread T1 = new Thread(new Runnable(){ // producer thread
  	       @Override
	       public void run (){
	         
		  try{
		      cp.produce();
	   	      }
	
		  catch(InterruptedException e){
			e.printStackTrace();
		   }
	      }
	  });

	      Thread T2 = new Thread(new Runnable(){
		@Override
	       public void run(){
	        try{
		    cp.consume();	
		   }

		catch(InterruptedException e){
		  e.printStackTrace();
		 }
	     }
	 });

	     T1.start();
	     T2.start();

	     T1.join();
	     T2.join();
		
		
      }
	



	public static class CP {
	  
	   LinkedList<Integer> list = new LinkedList<>();
	   int capacity;
	    
	     CP (int buffer){
    		 capacity = buffer;
		}

	   public void produce() throws InterruptedException {
	     int temp = 0;
 	       
	     while(true){
		synchronized(this){
		   while(list.size()==capacity)
		   wait();
		 System.out.println("Producer Produced : " + temp);

		  list.add(temp++);

		  notify();  // notifies to consumer thread

		   Thread.sleep(2000);
	        }  
	     }
	   }

	   public void consume() throws InterruptedException {
	    
 	     while(true){
	       synchronized(this){
	         while(list.size() == 0)
		   wait();
	
		 int value = list.removeFirst();
		 System.out.println("Consumer Consumed : " + value);
	
		 notify();

		  Thread.sleep(2000);
	       }
	     } 
	   }


	}

    }