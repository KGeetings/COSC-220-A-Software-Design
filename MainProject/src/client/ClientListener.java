package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientListener extends Thread {
    public ClientListener(int port) {
        this.port = port;
    }

    private int port;

    @Override
    public void run() {
        // Print out what thread we are running on
        System.out.println("ClientListener is running on thread " + Thread.currentThread().getName());
        while(true) {
            try (ServerSocket listen = new ServerSocket (port); //wait for a client to connect
                Socket client = listen.accept()) {
                //use the socket to create IO streams
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                Scanner in = new Scanner(client.getInputStream());
                
                //follow the protocol
                String line = in.nextLine();
                System.out.println(line);

                // if the client receives a message from another client as "SENDPRIVATEMESSAGE"
                if (line.equals("SENDPRIVATEMESSAGE")) {
                    // get the username of who we should be
                    String usernameReceiving = in.nextLine();

                    // if the usernameReceiving is the same as our username
                    if (usernameReceiving.equals(Client.username)) {
                        // send "SUCCESS"
                        out.println("SUCCESS");
                        
                        // get the username of who sent the message
                        String usernameSending = in.nextLine();

                        // get the message
                        String message = in.nextLine();

                        // add the message to the list of private messages
                        Client.userPrivateMessages.add(message);
                        Client.userPrivateMessagesUsernameReceiving.add(usernameReceiving);
                        Client.userPrivateMessagesUsernameSending.add(usernameSending);

                        //update the private message window
                        MainPage.updateUserPrivateMessages();

                        //send "SUCCESS" to the server
                        out.println("SUCCESS");
                    } else {
                        //send "FAILURE" to the server
                        out.println("FAILURE");

                        // send the error message that we are not logged in
                        out.println(Client.username + " is not logged in");
                    }
                } // if the Client receives a message from the server as "SENDMESSAGE"
                else if (line.equals("SENDMESSAGE")) {
                    //get the next line from the server
                    Client.newMessages = in.nextLine();
                    String newMessages = Client.newMessages;

                    //Open a new dialog box to display the message
                    javax.swing.JOptionPane.showMessageDialog(null, newMessages);

                    //send "SUCCESS" to the server
                    out.println("SUCCESS");
                }
                //close the socket
                client.close();
            } catch (IOException e) {
                // If an I/O error occurs, print a message, then attempt to reconnect
                System.out.println("Connection lost, attempting to reconnect");
            }
        }
    }
}
