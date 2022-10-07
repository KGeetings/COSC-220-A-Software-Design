package server;

public class UserList {
    //Utilizes a HashMap to store the users
    //Methods are register, login,logout

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
}
