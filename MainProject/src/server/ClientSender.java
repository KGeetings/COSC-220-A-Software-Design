package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSender extends Thread{
    public ClientSender(String username, String ipAddress, String newMessages) {
        this.username = username;
        this.ipAddress = ipAddress;
        this.newMessages = newMessages;
    }

    private String username;
    private String ipAddress;
    private String newMessages;

    @Override
    public void run() {
        // Print out what thread we are running on
        System.out.println("ClientSender is running on thread " + Thread.currentThread().getName());

        try (Socket connector = new Socket(ipAddress, 2002)) {
            InputStream inStream = connector.getInputStream();
            OutputStream outStream = connector.getOutputStream();

            try (Scanner in = new Scanner(inStream)) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream), true);

                // Send "SENDMESSAGE" to the client
                out.println("SENDMESSAGE");
                
                // Make the mesage say "Welcome back {username}, the following people have followed/unfollowed you since you last logged in: {newMessages}"
                String message = "Hello " + username + ", the following people have followed/unfollowed you: " + newMessages;

                // Send the message to the client
                out.println(message);
                System.out.println("Sent message to " + username + " at " + ipAddress + " with message: " + message);

                // Wait for the client to send "SUCCESS"
                String line = in.nextLine();
                // If the client sends "SUCCESS"
                if (line.equals("SUCCESS")) {
                    System.out.println("Received success from " + username + " at " + ipAddress);
                    // clear the new messages
                    UserList.resetNewFollowerOrUnfollower(username);
                }
            }
            // Close the socket
            connector.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
