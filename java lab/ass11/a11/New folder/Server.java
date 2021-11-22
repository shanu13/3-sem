import java.net.*;
import java.io.*;
import java.util.*;

	public class Server {
	
	    public static int countlines(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
	
		  try{
	           byte[] c = new byte[1024];
		   int counting = 0;
		   int readC = 0;
	           boolean empty = true;
		
		   while((readC = is.read(c)) !=-1){
		    empty = false;
		    for(int i=0; i<readC; i++){
			if(c[i] == '\n'){
			    ++counting;
			}
		    }
	          }

		  return (counting == 0 && !empty) ? 1 : counting;
	       }
 	         finally{
	 	   is.close();
		}
	    }



	public static int  CountWords(File file) throws IOException{

	     int count = 0;
	     FileInputStream fis = new FileInputStream(file);
             byte[] bytesArray = new byte[(int)file.length()];
             fis.read(bytesArray);
	     String str = new String(bytesArray);
             String [] data = str.split(" ");
             for (int i=0; i<data.length; i++) {
                   count++;
               }
                return count;
	
	}


	public static void main(String[] args) throws IOException{

	     ServerSocket sskt = new ServerSocket(3680);
             System.out.println("Server Listening on 3680");
             Socket skt = sskt.accept();
             System.out.println("Client Connected...");

	     InputStreamReader in = new InputStreamReader(skt.getInputStream());
        
             PrintWriter writer = new PrintWriter(skt.getOutputStream(), true);
          
             BufferedReader bf = new BufferedReader(in);
             String fileName = bf.readLine();
             System.out.println("/" + fileName + "/");

	     
             File curDir = new File(".");
             File[] filesList = curDir.listFiles();
            for(File f : filesList){
                if(fileName.equals(f.getName())){
                     writer.println("Found " + f.getName() + " in " + f.getPath());
                     writer.println("No. of lines: " + countlines(f.getPath()));
                     writer.println("No. of Words: " + CountWords(f));
                  return;
                }
            }


	     Scanner sc = new Scanner(System.in);
            System.out.println("File not found : ");
             for(File f : filesList){
                 String fName = f.getName();
                   if(fileName.charAt(0) == fName.charAt(0) && fileName.charAt(1) == fName.charAt(1)){
                    System.out.println(fName);
                    String inp = sc.nextLine();
		 }
	     }

		sc.close();	 
	}




	
}