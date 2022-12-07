package server;

public class User {
    //Methods are getUsername, getPassword, getIpAddress, getStatus, setUsername, setPassword, setIpAddress, setStatus
    //ALso need to getFollowers, getFollowing, addFollower, addFollowing, removeFollower, removeFollowing
    //inludes username, password, ipAddress, and status, and followers and following

    // Need to keep track of user's last read message from the public feed, only show messages after that one, from users they follow

    //fields
    private String username;
    private String password;
    private String ipAddress;
    private boolean status;
    private String followers;
    private String following;
    private int lastRead;
    private String newFollowerOrUnfollower;

    //constructor
    public User(String username, String password, String ipAddress, String status) {
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
        this.status = Boolean.parseBoolean(status);
        this.followers = "";
        this.following = "";
        this.lastRead = 0;
        this.newFollowerOrUnfollower = "";
    }

    public Object getPassword() {
        return password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean b) {
        status = b;
    }

    public void setIpAddress(String ipAddress2) {
        ipAddress = ipAddress2;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password2) {
        password = password2;
    }

    public void setUsername(String username2) {
        username = username2;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public void addFollower(String username) {
        followers = followers + username + ",";
    }

    public void addFollowing(String username) {
        following = following + username + ",";
    }

    public void removeFollower(String username) {
        String[] followersArray = followers.split(",");
        followers = "";
        for (int i = 0; i < followersArray.length; i++) {
            if (!followersArray[i].equals(username)) {
                followers = followers + followersArray[i] + ",";
            }
        }
    }

    public void removeFollowing(String username) {
        String[] followingArray = following.split(",");
        following = "";
        for (int i = 0; i < followingArray.length; i++) {
            if (!followingArray[i].equals(username)) {
                following = following + followingArray[i] + ",";
            }
        }
    }

    public int getLastRead() {
        return lastRead;
    }

    public void setLastRead(int lastRead2) {
        lastRead = lastRead2;
    }

    // If username is "admin" and password is "admin", return true
    public Object getAdmin() {
        return (username.equals("admin"));
    }

    public String getNewFollowerOrUnfollower() {
        return newFollowerOrUnfollower;
    }

    public void addNewFollowerOrUnfollower(String newFollowerOrUnfollower2) {
        newFollowerOrUnfollower = newFollowerOrUnfollower + newFollowerOrUnfollower2 + ",";
    }

    public void clearNewFollowerOrUnfollower() {
        newFollowerOrUnfollower = "";
    }
}
