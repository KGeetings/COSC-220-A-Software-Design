package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server{
    //create a UserList object
    private static UserList userList = new UserList();

    public static void main(String[] args) throws UnknownHostException {
        //create an admin user, with username "admin" and pass "admin"
        userList.register("admin", "admin", "admin");

        //create a test user, with username "test" and pass "test"
        userList.register("test", "test", "localhost");
        userList.register("test2", "test2", "localhost");
        userList.register("test3", "test3", "localhost");

        //create a test message, with sender "test" and message
        MessageList.addMessage("testMessage", "test2", "hashtag");
        MessageList.addMessage("test2Message", "test2", "hashtag2");
        MessageList.addMessage("test3Message", "test3", "hashtag3");
        MessageList.addMessage("test1Message", "test", "hashtag1");
        MessageList.addMessage("test1Message", "test", "hashtag2");

        //have test follow test2
        userList.addFollowing("test", "test2");
        userList.addFollower("test2", "test");

        // Print out ip address so we can connect to this server
        System.out.println("Server is running on ip address " + InetAddress.getLocalHost().getHostAddress());

        //create new threads of the driver class when a new client connects
        while(true){
            new Driver(2001, userList).start();
            System.out.println("Driver thread started on port 2001");
        }
    }

    
}
