import java.net.*;
import java.io.*;
import java.util.*;


	public class Client{
            public static void main(String[] args) throws IOException {
            Socket skt = new Socket("localhost", 3680);
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the name of the file: ");
            String inp = scan.nextLine();
        
            PrintWriter pw = new PrintWriter(skt.getOutputStream());
            pw.println(inp);
            pw.flush();
            System.out.println("Searching for " + inp + "...");
        
            InputStreamReader in = new InputStreamReader(skt.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            Scanner sc = new Scanner(in);

              String str;
            while(!skt.isClosed()){
              while(sc.hasNextLine()){
                 str = sc.nextLine();
                 System.out.println("Server: " + str);
            }
            
        }

	 sc.close();
	 scan.close();
    }
    
}
