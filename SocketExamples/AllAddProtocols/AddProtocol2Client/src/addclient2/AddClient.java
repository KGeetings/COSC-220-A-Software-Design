/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addclient2;


import java.io.PrintWriter;
import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Scanner;

/**
 * A simple client that will query the daytime service on a
 * remote to determine the date and time at that location.
 */


public class AddClient {

    static int ADD_PORT = 2001;  // Well known port for the daytime

    public static void main( String args[] ) {

	
        try {
            // get a host
            String host = "localhost";

            // Attempt to connect to the specified host

            Socket sock = new Socket( host, ADD_PORT );

            // Create the IO streams from the socket
            Scanner in = new Scanner( sock.getInputStream() );

            PrintWriter out =
		    new PrintWriter( sock.getOutputStream(), true );

            // Follow the protocol
            out.println("ADD");
            out.println("3");
            for (int i = 10; i < 31; i = i + 10)
            {
                out.println(Integer.toString(i));
            }

            String result = in.nextLine();
            String value = in.nextLine();

            //process and print the results
            System.out.println( value );

            // All done close the socket

            in.close();
            sock.close();
        }
        catch ( UnknownHostException e ) {
            System.err.println( "DayTimeClient:  no such host" );
        }
        catch ( IOException e ) {
            System.err.println("IOEXCEPTION");
            System.err.println( e.getMessage() );
        }


    }

} // DayTimeClient
