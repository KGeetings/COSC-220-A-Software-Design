package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Driver {
    //Server driver class, uses a UserList object to store the users and their information
    //Server driver connects to clients with a socket and communicates with them

    //Protocol:
        //Client sends a command example: (LOGIN, LOGOUT, REGISTER, GETLIST)
        //Server responds with a message example: (SUCCESS, FAILURE, LIST)
        //If SUCCESS, Client expected information (for example, username, password, ipAddress for login)
        //If FAILURE, Client expected error message
        //If LIST, Client expected list of users


    public Driver (int port, UserList userList) {
        try (ServerSocket listen = new ServerSocket (port)) {
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
                            //check if user is admin, if so send ADMIN, if not send SUCCESS
                            if (UserList.isAdmin(username, password)) {
                                out.println("ADMIN");
                            } else {
                                out.println("SUCCESS");
                            }
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
            } //Client follows a user
            else if (line.equals("FOLLOW")) {
                //get username and followee
                String username = in.nextLine();
                String followee = in.nextLine();
                System.out.println(username + " " + followee);

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if we are trying to follow ourselves
                    if (username.equals(followee)) {
                        //if we are trying to follow ourselves, send a failure message
                        out.println("FAILURE");
                        out.println("Cannot follow yourself");
                    }
                    //check if we aren't signed in
                    else if (!userList.checkLoggedIn(username)) {
                        //if we aren't signed in, send a failure message
                        out.println("FAILURE");
                        out.println("User not logged in");
                    }
                    //check if the followee exists
                    else if (userList.userExists(followee)) {
                        //check if the user is already following the followee
                        if (UserList.checkFollowing(username, followee)) {
                            //if the user is already following the followee, send a failure message
                            out.println("FAILURE");
                            out.println("Already following user");
                        } else {
                            //if the user is not following the followee, follow them, and set the followee's follower to the user
                            userList.addFollowing(username, followee);
                            userList.addFollower(followee, username);
                            out.println("SUCCESS");
                        }
                    } else {
                        //if the followee does not exist, send a failure message
                        out.println("FAILURE");
                        out.println("Followee does not exist");
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } //Client unfollows a user
            else if (line.equals("UNFOLLOW")) {
                //get username and followee
                String username = in.nextLine();
                String followee = in.nextLine();
                System.out.println(username + " " + followee);

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if we are trying to unfollow ourselves
                    if (username.equals(followee)) {
                        //if we are trying to unfollow ourselves, send a failure message
                        out.println("FAILURE");
                        out.println("Cannot unfollow yourself");
                    }
                    //check if we aren't signed in
                    else if (!userList.checkLoggedIn(username)) {
                        //if we aren't signed in, send a failure message
                        out.println("FAILURE");
                        out.println("User not logged in");
                    }
                    //check if the followee exists
                    else if (userList.userExists(followee)) {
                        //check if the user is following the followee
                        if (UserList.checkFollowing(username, followee)) {
                            //if the user is following the followee, unfollow them, and remove the followee's follower
                            userList.removeFollowing(username, followee);
                            userList.removeFollower(followee, username);
                            out.println("SUCCESS");
                        } else {
                            //if the user is not following the followee, send a failure message
                            out.println("FAILURE");
                            out.println("You are not following this user");
                        }
                    } else {
                        //if the followee does not exist, send a failure message
                        out.println("FAILURE");
                        out.println("Followee does not exist");
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } //Client gets the list of users they are following
            else if (line.equals("GETFOLLOWING")) {
                //get username
                String username = in.nextLine();

                //check if the user exists
                if (userList.userExists(username)) {
                    //get the list of users the user is following
                    String list = userList.getFollowing(username);

                    //send the list of users the user is following
                    out.println("SUCCESS");
                    out.println(list);
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } //Client gets the list of users following them
            else if (line.equals("GETFOLLOWERS")) {
                //get username
                String username = in.nextLine();

                //check if the user exists
                if (userList.userExists(username)) {
                    //get the list of users following the user
                    String list = userList.getFollowers(username);

                    //send the list of users following the user
                    out.println("SUCCESS");
                    out.println(list);
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } //Client receives the public feed from lastread
            else if (line.equals("GETPUBLICFEED")) {
                //get username
                String username = in.nextLine();
                System.out.println(username);

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if we aren't signed in
                    if (!userList.checkLoggedIn(username)) {
                        //if we aren't signed in, send a failure message
                        out.println("FAILURE");
                        out.println("User not logged in");
                    } else {
                        //get the public feed from lastread
                        int lastRead = userList.getLastRead(username);
                        String feed = MessageList.getPublicFeed(username, lastRead);

                        out.println("SUCCESS");

                        //send the public feed from lastread
                        out.println(feed);
                        System.out.println(feed);
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            } //Client sends a message to the public feed
            else if (line.equals("SENDPUBLICMESSAGE")) {
                //get username, message, and timestamp
                String username = in.nextLine();
                String hashtag = in.nextLine();
                String message = in.nextLine();
                System.out.println(username);

                // Check if message is empty, or if it is too long, or if it contains "BREAKLINE000"
                if (message.equals("") || message.length() > 140 || message.contains("BREAKLINE000") || hashtag.contains("BREAKLINE000") || hashtag.contains(" ") || hashtag.contains("#") || hashtag.contains("@") || message.contains("/n")) {
                    out.println("FAILURE");
                    out.println("Message is either empty, too long, or contains unallowed characters");
                } else {
                    //check if the user exists
                    if (userList.userExists(username)) {
                        //check if we aren't signed in
                        if (!userList.checkLoggedIn(username)) {
                            //if we aren't signed in, send a failure message
                            out.println("FAILURE");
                            out.println("User not logged in");
                        } else {
                            //send the message to the public feed
                            MessageList.addMessage(message, username, hashtag);
                            out.println("SUCCESS");
                        }
                    } else {
                        //if the user does not exist, send a failure message
                        out.println("FAILURE");
                        out.println("User does not exist");
                    }
                }
            } //Client sends a hashtag to search through the entire messages list for
            else if (line.equals("SEARCHHASHTAG")) {
                //get hashtag
                String hashtag = in.nextLine();
                System.out.println(hashtag);

                //check if the hashtag exists
                if (MessageList.hashtagExists(hashtag)) {
                    //get the list of messages with the hashtag
                    String list = MessageList.getHashtagMessages(hashtag);

                    //send the list of messages with the hashtag
                    out.println("SUCCESS");
                    out.println(list);
                    System.out.println(list);
                } else {
                    //if the hashtag does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("Hashtag does not exist");
                }
            } //Admin sends command "SHUTDOWN"
            else if (line.equals("SHUTDOWN")) {
                //get username
                String username = in.nextLine();
                String password = in.nextLine();
                System.out.println(username);

                //check if the user exists
                if (userList.userExists(username)) {
                    //check if the user is an admin
                    if (UserList.isAdmin(username, password)) {
                        //if the user is an admin, shut down the server
                        out.println("SUCCESS");
                        System.out.println("Server shutting down");
                        System.exit(0);
                    } else {
                        //if the user is not an admin, send a failure message
                        out.println("FAILURE");
                        out.println("User is not an admin");
                    }
                } else {
                    //if the user does not exist, send a failure message
                    out.println("FAILURE");
                    out.println("User does not exist");
                }
            }
        } catch (IOException e) {
            // If an I/O error occurs, print a message, then attempt to reconnect
            System.out.println("Connection lost, attempting to reconnect");
        }
    }

    public static void main(String[] args) {
        //create a UserList object
        UserList userList = new UserList();

        //create an admin user, with username "admin" and pass "admin"
        userList.register("admin", "admin", "admin");

        //create a test user, with username "test" and pass "test"
        userList.register("test", "test", "testt");
        userList.register("test2", "test2", "testt2");
        userList.register("test3", "test3", "testt3");

        //create a test message, with sender "test" and message
        MessageList.addMessage("testMessage", "test2", "hashtag");
        MessageList.addMessage("test2Message", "test2", "hashtag2");
        MessageList.addMessage("test3Message", "test3", "hashtag3");
        MessageList.addMessage("test1Message", "test", "hashtag1");

        //have test follow test2
        userList.addFollowing("test", "test2");
        userList.addFollower("test2", "test");

        new Driver(2001, userList);

        //continue to rerun the driver if the connection is lost
        while (true) {
            new Driver(2001, userList);
        }
    }
}
