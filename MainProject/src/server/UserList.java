package server;

public class UserList {
    //UserList object stores a list of users and their information

    //register method
    public void register(String username, String password, String ipAddress) {
        //check if username is already taken
        //if not, add user to the HashMap

    }

    //login method
    public void login(String username, String password, String ipAddress) {
        //check if username and password match
        //if so, set the user's status to online
    }

    //logout method
    public void logout(String username) {
        //set the user's status to offline
    }

    public boolean userExists(String username) {
        //check if the user exists
        //return true if the user exists, false if not
        return false;
    }

    public boolean checkPassword(String username, String password) {
        return false;
    }

    public boolean checkLoggedIn(String username) {
        return false;
    }

    public String getList() {
        return null;
    }
}
