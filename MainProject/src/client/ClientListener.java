package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientListener extends Thread {
    public ClientListener(int port) {
        try (ServerSocket listen = new ServerSocket (port)) {
            //wait for a client to connect
            Socket client = listen.accept();
            //use the socket to create IO streams
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner in = new Scanner(client.getInputStream());
            
            //follow the protocol
            String line = in.nextLine();
            System.out.println(line);

            // if the client receives a message from another client as "SENDPRIVATEMESSAGE"
            if (line.equals("SENDPRIVATEMESSAGE")) {
                //get the username of the other user
                String username = in.nextLine();

                //get the message
                String message = in.nextLine();

                //add the message to the list of messages
                Client.userPrivateMessages.add(message);
                Client.userPrivateMessagesUsernameReceiving.add(Client.username);
                Client.userPrivateMessagesUsernameSending.add(username);

                //update the private message window
                MainPage.updateUserPrivateMessages();

                //send "SUCCESS" to the server
                out.println("SUCCESS");
            } // if the Client receives a message from the server as "SENDMESSAGE"
            else if (line.equals("SENDMESSAGE")) {
                //get the next line from the server
                Client.newMessages = in.nextLine();

                //send "SUCCESS" to the server
                out.println("SUCCESS");
            }
        } catch (IOException e) {
            // If an I/O error occurs, print a message, then attempt to reconnect
            System.out.println("Connection lost, attempting to reconnect");
        }
    }

    @Override
    public void run() {
        // Print out what thread we are running on
        System.out.println("ClientListener is running on thread " + Thread.currentThread().getName());
    }
}
