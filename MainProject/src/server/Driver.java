package server;

public class Driver {
    //Server driver class, uses a UserList object to store the users and their information
    //Server driver connects to clients with a socket and communicates with them

    public static void main(String[] args) {
        //create a UserList object
        UserList userList = new UserList();

        //create a socket
        Socket connector = new Socket("localhost", 2001);

        //while loop to keep the server running
            //accept a connection from a client
            //create a thread to handle the client
    }
}
