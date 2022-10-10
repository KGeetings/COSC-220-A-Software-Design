package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Driver {
    //Server driver class, uses a UserList object to store the users and their information
    //Server driver connects to clients with a socket and communicates with them

    //Protocol:
        //Client sends a command (LOGIN, LOGOUT, REGISTER, GETLIST)
        //Server responds with a message (SUCCESS, FAILURE, LIST)
        //If SUCCESS, Client expected information (for example, username, password, ipAddress for login)
        //If FAILURE, Client expected error message
        //If LIST, Client expected list of users

    public Driver (int port, UserList userList) {
        try (ServerSocket listen = new ServerSocket (2001)) {
            //wait for a client to connect
            Socket client = listen.accept();
            //use the socket to create IO streams
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner in = new Scanner(client.getInputStream());
            
            //follow the protocol
            String line = in.nextLine();
            System.out.println(line);
            if (line.equals("LOGIN")) {
                //get username, password, and ipAddress
                String username = in.nextLine();
                String password = in.nextLine();
                String ipAddress = in.nextLine();
                System.out.println(username + " " + password + " " + ipAddress);

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if the password is correct
                    if (userList.checkPassword(username, password)) {
                        //check if the user is already logged in
                        if (userList.checkLoggedIn(username)) {
                            //if the user is already logged in, send a failure message
                            out.println("FAILURE");
                            out.println("User already logged in");
                        } else {
                            //if the user is not logged in, log them in
                            userList.login(username, password, ipAddress);
                            out.println("SUCCESS");
                        }
                    } else {
                        //if the password is incorrect, send a failure message
                        out.println("FAILURE");
                        out.println("Incorrect password");
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } else if (line.equals("LOGOUT")) {
                //get username
                String username = in.nextLine();

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if the user is logged in
                    if (userList.checkLoggedIn(username)) {
                        //if the user is logged in, log them out
                        userList.logout(username);
                        out.println("SUCCESS");
                    } else {
                        //if the user is not logged in, send a failure message
                        out.println("FAILURE");
                        out.println("User not logged in");
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } else if (line.equals("REGISTER")) {
                //get username, password, and ipAddress
                String username = in.nextLine();
                String password = in.nextLine();
                String ipAddress = in.nextLine();
                System.out.println(username + " " + password + " " + ipAddress);

                //check if the user exists
                if (userList.userExists(username)) {
                    //if the user exists, send a failure message
                    out.println("FAILURE");
                    out.println("User already exists");
                } else {
                    //if the user does not exist, register them
                    userList.register(username, password, ipAddress);
                    out.println("SUCCESS");
                }
            } else if (line.equals("GETLIST")) {
                System.out.println("Running getlist");
                //get the list of users
                String list = userList.getList();

                //send the list of users
                System.out.println("Sending list");
                out.println("LIST");
                out.println(list);
                System.out.println("List:");
                System.out.println(list);
            }
        } catch (IOException e) {
            // If an I/O error occurs, print a message, then attempt to reconnect
            System.out.println("Connection lost, attempting to reconnect");
        }
    }

    public static void main(String[] args) {
        //create a UserList object
        UserList userList = new UserList();

        //create a server driver object
        Driver driver = new Driver(2001, userList);

        //continue to rerun the driver if the connection is lost
        while (true) {
            driver = new Driver(2001, userList);
        }
    }
}
