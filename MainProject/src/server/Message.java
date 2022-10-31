package server;

public class Message {
    //MessageList object stores a list of messages and their information
    //Methods are addMessage, getMessage, getMessageList, removeMessage, editMessage
    //includes message, username, hashtag, and timestamp

    //fields
    private String message;
    private String username;
    private String hashtag;
    private int timestamp;

    //constructor
    public Message(String message, String username, String hashtag, int timestamp) {
        this.message = message;
        this.username = username;
        this.hashtag = hashtag;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getHashtag() {
        return hashtag;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message2) {
        message = message2;
    }

    public void setUsername(String username2) {
        username = username2;
    }

    public void setHashtag(String hashtag2) {
        hashtag = hashtag2;
    }

    public void setTimestamp(int timestamp2) {
        timestamp = timestamp2;
    }
}
