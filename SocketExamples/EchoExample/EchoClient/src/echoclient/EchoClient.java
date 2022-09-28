
package echoclient;

import java.io.*;
import java.net.*;
//import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Client code to connect to Echo Server
 * @author FYFES
 */
public class EchoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket connector = new Socket("216.159.69.82", 8189);
            
            InputStream inStream = connector.getInputStream();
            OutputStream outStream = connector.getOutputStream();
   
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(
                  new OutputStreamWriter(outStream),
                  true /* autoFlush */);
            
            //communicate!
            
            String result = in.nextLine();
            System.out.println(result);
            out.println("Message");
            result = in.nextLine();
            System.out.println(result);
            out.println("Message");
            result = in.nextLine();
            System.out.println(result);
            out.println("Message");
            result = in.nextLine();
            System.out.println(result);
            out.println("BYE");
            result = in.nextLine();
            System.out.println(result);
            System.out.println("Done");
            connector.close();
        }
        catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
