/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addserver2;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;

import java.util.Scanner;

/**
 * A Java implementation of a Daytime server.  This program
 * does not accept connections on the well-known port for the
 * daytime service.
 */

public class AddServer {

    public static void main( String args[] ) {

	try {

	    // Create the server socket that will be used to accept
	    // incoming connections

	    try (ServerSocket listen = new ServerSocket( 2001 )) {
			System.out.println( "Listening on port:  " + listen.getLocalPort() );
			    System.out.println("Listening on address: " + InetAddress.getLocalHost());

			// Process clients forever...

			while ( true ) {

			// Wait for a client to connect

			Socket client = listen.accept();

			// use the socket to create IO streams
			PrintWriter out =
			    new PrintWriter( client.getOutputStream(), true );

			        Scanner in = new Scanner( client.getInputStream() );

			// follow the protocol
			        String line = in.nextLine();
			        System.out.println(line);
			        String number = in.nextLine();
			        int num = Integer.parseInt(number);
			        int sum = 0;
			        for (int i = 0; i < num; ++i)
			        {
			            String valStr = in.nextLine();
			            int val = Integer.parseInt(valStr);
			            sum += val;
			        }

			        //Send the result
			out.println( "Result \n" + Integer.toString(sum) );


			out.close();
			client.close();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Print the port so we can run a client that will connect to
	    // the server.


	} catch( IOException e) {
	    System.err.println( e.getMessage() );
	}

    }

}  
