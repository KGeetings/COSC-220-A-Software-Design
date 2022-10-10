package server;

import java.util.HashMap;

public class UserList {
    //UserList object stores a list of users and their information
    HashMap <String, User> userList = new HashMap <String, User> ();

    public boolean userExists(String username) {
        //check if the user exists
        //return true if the user exists, false if not
        return userList.containsKey(username);
    }

    public boolean checkPassword(String username, String password) {
        //check if the password is correct
        //return true if the password is correct, false if not
        if (userList.get(username).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLoggedIn(String username) {
        //check if the user is logged in
        //return true if the user is logged in, false if not
        if (userList.get(username).getStatus()) {
            return true;
        } else {
            return false;
        }
    }

    //register method
    public void register(String username, String password, String ipAddress) {
        //check if username is already taken
        //if not, add user to the HashMap
        if (userExists(username)) {
            System.out.println("Username already taken");
        } else {
            User newUser = new User(username, password, ipAddress, "false");
            userList.put(username, newUser);
        }
    }

    //login method
    public void login(String username, String password, String ipAddress) {
        //check if username and password match
        //if so, set the user's status to online
        if (checkPassword(username, password)) {
            userList.get(username).setStatus(true);
            userList.get(username).setIpAddress(ipAddress);
        } else {
            System.out.println("Username and password do not match");
        }
    }

    //logout method
    public void logout(String username) {
        //set the user's status to offline
        userList.get(username).setStatus(false);
    }

    public String getList() {
        //return a list of all users
        String list = "";
        for (String key: userList.keySet()) {
            list += key + " ";
        }
        return list;
    }
}
