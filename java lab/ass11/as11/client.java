import java.net.*;
import java.io.*;
import java.util.*;


	public class client{
            public static void main(String[] args) throws IOException {
            Socket sckt = new Socket("localhost", 4999);
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the name of the file: ");
            String inp = scan.nextLine();
        
            PrintWriter pr = new PrintWriter(sckt.getOutputStream());
            pr.println(inp);
            pr.flush();
            System.out.println("Searching for " + inp + "...");
        
            InputStreamReader in = new InputStreamReader(sckt.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            Scanner sc = new Scanner(in);

              String str;
            while(!sckt.isClosed()){
              while(sc.hasNextLine()){
                 str = sc.nextLine();
                 System.out.println("Server: " + str);
            }
            
        }

	 
    }
    
}
