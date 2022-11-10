/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketquizserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Stephen Fyfe
 */
public class QuizServer {

    public static void main(String[] args) {
        HashMap<String,Account> accounts = new HashMap<>();
        
        //now add some accounts to the HashMap
        Account a1 = new Account("1234", "1234", 350.00);
        Account a2 = new Account("ABC", "4321", 199.99);
        Account a3 = new Account("A12B", "5555", 8906.22);
        accounts.put(a1.getAccountNum(), a1);
        accounts.put(a2.getAccountNum(), a2);
        accounts.put(a3.getAccountNum(), a3);
        
        
        try {

	    // Create the server socket that will be used to accept
	    // incoming connections

	    ServerSocket listen = new ServerSocket( 2002 ); // Bind to any port

	    // Print the port so we can run a client that will connect to
	    // the server.

	    System.out.println( "Listening on port:  " +
				listen.getLocalPort() );
            System.out.println("Listening on address: " +
                    InetAddress.getLocalHost());

	    // Process clients forever...

	    while ( true ) {

		// Wait for a client to connect

		Socket client = listen.accept();

		// use the socket to create IO streams
		PrintWriter out =
		    new PrintWriter( client.getOutputStream(), true );

                Scanner in =
                new Scanner( client.getInputStream());

		// follow the protocol
                String command = in.nextLine();
                System.out.println(command);
                
                if ((command.equals("WITHDRAW")) || (command.equals("DEPOSIT")) || command.equals("BALANCE")){
                    out.println("WHO");
                    String account = in.nextLine();
                    System.out.println(account);
                    if (accounts.containsKey(account)) {
                        out.println("VALID");
                        Account acct = accounts.get(account);
                        String pin = in.nextLine();
                        if (pin.equals(acct.getPin())) {
                            out.println("VALID");
                            String amtStr = in.nextLine();
                            double amt = Double.parseDouble(amtStr);
                            if (command.equals("WITHDRAW")) {
                                if (acct.getBalance() >= amt) {
                                    acct.withdraw(amt);
                                    double balance = acct.getBalance();
                                    out.println("SUFFICIENT");
                                    out.println(Double.toString(balance));
                                    String goodbye = in.nextLine();
                                    out.println("SAYANORA");
                                }
                                else {
                                    out.println("INSUFFICIENT");
                                }
                            }
                            else {
                                if (command.equals("DEPOSIT"))
                                    acct.deposit(amt);
                                double balance = acct.getBalance();
                                out.println("SUFFICIENT");
                                out.println(Double.toString(balance));
                                String goodbye = in.nextLine();
                                out.println("SAYANORA");
                            }
                        }
                        else {
                            out.println("INVALID");
                        }
                        
                    }
                    else {
                        out.println("INVALID");
                    }                
                }
                else
                    out.println("BAD COMMAND");

		out.close();
		client.close();
	    }

	} catch( IOException e) {
	    System.err.println( e.getMessage() );
	}

    }
    
}
