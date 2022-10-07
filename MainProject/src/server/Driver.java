package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Driver {
    //Server driver class, uses a UserList object to store the users and their information
    //Server driver connects to clients with a socket and communicates with them

    //Protocol:
        //Client sends a command (LOGIN, LOGOUT, REGISTER, GETLIST), along with the expected information (for example, username, password, ipAddress for login)
        //Server responds with a message (SUCCESS, FAILURE, LIST)

    public static void main(String[] args) {
        //create a UserList object
        UserList userList = new UserList();

        try (//create a socket
        Socket connector = new Socket("localhost", 2001)) {
            //use the socket to create IO streams
            PrintWriter out = new PrintWriter(connector.getOutputStream(), true);
            Scanner in = new Scanner(connector.getInputStream());

            //follow the protocol
            String line = in.nextLine();
            System.out.println(line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //while loop to keep the server running
            //accept a connection from a client
            //create a thread to handle the client
    }
}
