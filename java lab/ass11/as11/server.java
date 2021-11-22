import java.net.*;
import java.io.*;
import java.util.*;



public class server {
    public static int Lines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int rdChars = 0;
            boolean empty = true;
            while ((rdChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < rdChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            } 
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static int Words(File file) throws IOException {
        int counts = 0;
        FileInputStream fiss = new FileInputStream(file);
        byte[] bytesArray = new byte[(int)file.length()];
        fiss.read(bytesArray);
        String s = new String(bytesArray);
        String [] data = s.split(" ");
        for (int i=0; i<data.length; i++) {
            counts++;
        }
        return counts;
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket ssocket = new ServerSocket(4999);
        System.out.println("Server Listening on 4999");
        Socket server = ssocket.accept();
        System.out.println("Connected");
        InputStreamReader in = new InputStreamReader(server.getInputStream());
        
        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);
        
        BufferedReader bf = new BufferedReader(in);
        String fileName = bf.readLine();
        System.out.println("/" + fileName + "/");
        
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(fileName.equals(f.getName())){
                writer.println("Found " + f.getName() + " in " + f.getPath());
                writer.println("Number of lines: " + Lines(f.getPath()));
                writer.println("Number of Words: " + Words(f));
                return;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("File not found. Did you mean: ");
        for(File f : filesList){
            String fName = f.getName();
            if(fileName.charAt(0) == fName.charAt(0) && fileName.charAt(1) == fName.charAt(1)){
                System.out.println(fName);
                String inp = sc.nextLine();
                
            }
        }
        
    }
}
