package client;

import java.util.HashMap;

public class SystemPublicMessages {
    // Store the messages, their hashtag, messageID, and username as a HashMap
    private HashMap<String, String> messages = new HashMap<String, String>();
    private HashMap<String, String> messageID = new HashMap<String, String>();
    private HashMap<String, String> messageHashtag = new HashMap<String, String>();
    private HashMap<String, String> messageUsername = new HashMap<String, String>();
    
    // Add a message to the HashMap
    public void addMessage(String message, String messageID, String messageHashtag, String messageUsername) {
        messages.put(message, messageID);
        this.messageID.put(messageID, message);
        this.messageHashtag.put(messageHashtag, message);
        this.messageUsername.put(messageUsername, message);
    }
    
    // Get a message from the HashMap
    public String getMessage(String messageID) {
        return this.messageID.get(messageID);
    }
    
    // Get a message's hashtag from the HashMap
    public String getHashtag(String messageID) {
        return messageHashtag.get(this.messageID.get(messageID));
    }
    
    // Get a message's username from the HashMap
    public String getUsername(String messageID) {
        return messageUsername.get(this.messageID.get(messageID));
    }
    
    // Get the messageID of a message
    public String getMessageID(String message) {
        return messages.get(message);
    }

}
