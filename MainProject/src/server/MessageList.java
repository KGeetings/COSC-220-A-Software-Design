package server;

import java.util.ArrayList;

public class MessageList {
    //MessageList object stores a list of messages and their information

    static ArrayList <Message> messageList = new ArrayList <Message> ();

    /* public boolean messageExists(int idNumber) {
        //check if the message exists
        //return true if the message exists, false if not
        return messageList.contains(idNumber);
    } */

    public static void addMessage(String message, String username, String hashtag) {
        //get the latest message id number
        int idNumber = messageList.size() + 1;

        //add a message to the ArrayList
        Message newMessage = new Message(message, username, hashtag, idNumber);
        messageList.add(newMessage);
    }

    public Message getMessage(int idNumber) {
        //get a message from the ArrayList
        return messageList.get(idNumber);
    }

    public ArrayList <Message> getMessageList() {
        //get the entire message list
        return messageList;
    }

    public void removeMessage(int idNumber) {
        //remove a message from the ArrayList
        messageList.remove(idNumber);
    }

    public void editMessage(int idNumber, String message, String username, String hashtag, int timestamp) {
        //edit a message in the ArrayList
        messageList.get(idNumber).setMessage(message);
        messageList.get(idNumber).setUsername(username);
        messageList.get(idNumber).setHashtag(hashtag);
        messageList.get(idNumber).setTimestamp(timestamp);
    }

    // return the message list as a string for the user, starting from the last read message, up to the last message, only if user is following the message's author
    public static String getPublicFeed(String username, int lastRead) {
        String feed = "";
        for (int i = lastRead; i < messageList.size(); i++) {
            if (UserList.checkFollowing(username, messageList.get(i).getUsername())) {
                feed += messageList.get(i).getMessage() + " \t#" + messageList.get(i).getHashtag() + " \tid:" + messageList.get(i).getTimestamp() + " \tfrom:" + messageList.get(i).getUsername() + "BREAKLINE0";
            }
        }
        return feed;
    }

}
