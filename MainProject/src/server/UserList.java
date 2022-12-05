package server;

import java.util.HashMap;

public class UserList {
    //UserList object stores a list of users and their information
    static HashMap <String, User> userList = new HashMap <String, User> ();

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

    //addFollower method
    public void addFollower(String username, String follower) {
        //add a follower to the user's list of followers
        userList.get(username).addFollower(follower);
    }

    //addFollowing method
    public void addFollowing(String username, String following) {
        //add a user to the user's list of following
        userList.get(username).addFollowing(following);
    }

    //removeFollower method
    public void removeFollower(String username, String follower) {
        //remove a follower from the user's list of followers
        userList.get(username).removeFollower(follower);
    }

    //removeFollowing method
    public void removeFollowing(String username, String following) {
        //remove a user from the user's list of following
        userList.get(username).removeFollowing(following);
    }

    //getFollowers method
    public String getFollowers(String username) {
        //return a list of the user's followers
        return userList.get(username).getFollowers();
    }

    //getFollowing method
    public String getFollowing(String username) {
        //return a list of the user's following
        return userList.get(username).getFollowing();
    }

    //getIpAddress method
    public String getIpAddress(String username) {
        //return the user's ip address
        return userList.get(username).getIpAddress();
    }

    public static boolean checkFollowing(String username, String followee) {
        //check if the user is following the followee
        //return true if the user is following the followee, false if not
        //split the list of following into an array, then loop through the array

        String[] following = userList.get(username).getFollowing().split(",");
        for (int i = 0; i < following.length; i++) {
            if (following[i].equals(followee)) {
                return true;
            }
        }
        return false;
    }

    //get user's last read message
    public int getLastRead(String username) {
        return userList.get(username).getLastRead();
    }

    //set user's last read message
    public static void setLastRead(String username, int lastRead) {
        userList.get(username).setLastRead(lastRead);
    }

    //check if user is an admin
    public static boolean isAdmin(String username, String password) {
        if (userList.get(username).getPassword().equals(password) && userList.get(username).getAdmin().equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    //get user's new follower or unfollower notifications
    public static String getNewFollowerOrUnfollower(String username) {
        return userList.get(username).getNewFollowerOrUnfollower();
    }

    //set user's new follower or unfollower notifications
    public static void setNewFollowerOrUnfollower(String username, String newFollowerOrUnfollower) {
        userList.get(username).addNewFollowerOrUnfollower(newFollowerOrUnfollower);
    }

    //reset user's new follower or unfollower notifications
    public static void resetNewFollowerOrUnfollower(String username) {
        userList.get(username).clearNewFollowerOrUnfollower();
    }

    //change user's password
    public static void changePassword(String username, String password) {
        userList.get(username).setPassword(password);
    }

    public char[] getNumberOfUsers() {
        //return the number of users
        return Integer.toString(userList.size()).toCharArray();
    }

}
