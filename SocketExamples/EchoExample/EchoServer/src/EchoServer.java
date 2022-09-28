import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

/**
 * This program implements a simple server that listens to port 8189 and echoes back all
 * client input.
 * @version 1.22 2018-03-17
 * @author Cay Horstmann
 * 
 * Format of the try/catch blocks was changed
 */
public class EchoServer
{
   public static void main(String[] args) throws IOException
   {
      // establish server socket
      try 
      {
          ServerSocket s = new ServerSocket(8189);
          Socket incoming = s.accept();
         
          InputStream inStream = incoming.getInputStream();
          OutputStream outStream = incoming.getOutputStream();
   
          Scanner in = new Scanner(inStream);
          PrintWriter out = new PrintWriter(
                  new OutputStreamWriter(outStream), true /* autoFlush */);
      
          //Now follow the Echo protocol
          out.println("Hello! Enter BYE to exit.");
      
               // echo client input
          boolean done = false;
          System.out.println("Starting to read");
          while (!done && in.hasNextLine())
          {
                  String line = in.nextLine();
                  System.out.println(line);
                  out.println("Echo: " + line);
                  if (line.trim().equals("BYE")) done = true;
          }
          System.out.println("loop is complete");
            
         
      }
      catch(Exception e) {
          
      }
   }
}
