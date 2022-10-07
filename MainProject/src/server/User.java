package server;

public class User {
    //inludes username, password, ipAddress, and status
    //Methods are getUsername, getPassword, getIpAddress, getStatus, setUsername, setPassword, setIpAddress, setStatus

    //fields
    private String username;
    private String password;
    private String ipAddress;
    private boolean status;

    //constructor
    public User(String username, String password, String ipAddress, String status) {
        //initialize the variables
        this.username = username;
        this.password = password;
        this.ipAddress = ipAddress;
        this.status = Boolean.parseBoolean(status);
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

}
