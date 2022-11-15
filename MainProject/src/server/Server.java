package server;

public class Server{
    //create a UserList object
    public static UserList userList = new UserList();

    public static void main(String[] args) {
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

        //create new threads of the driver class when a new client connects
        while(true){
            new Driver(2001, userList).start();
        }
    }

    
}
