package server;

import java.util.ArrayList;

public class MessageList {
    //MessageList object stores a list of messages and their information

    private static ArrayList <Message> messageList = new ArrayList <Message> ();

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
                feed += messageList.get(i).getMessage() + " \t#" + messageList.get(i).getHashtag() + " \tid:" + messageList.get(i).getTimestamp() + " \tfrom:" + messageList.get(i).getUsername() + "BREAKLINE000";
            }
        }
        // set the user's last read message to the last message in the list
        UserList.setLastRead(username, messageList.size());
        return feed;
    }

    public static boolean hashtagExists(String hashtag) {
        //check if the hashtag exists
        //return true if the hashtag exists, false if not
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getHashtag().equals(hashtag)) {
                return true;
            }
        }
        return false;
    }

    public static String getHashtagMessages(String hashtag) {
        //get all messages with the given hashtag
        String messages = "";
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getHashtag().equals(hashtag)) {
                messages += messageList.get(i).getMessage() + " \t#" + messageList.get(i).getHashtag() + " \tid:" + messageList.get(i).getTimestamp() + " \tfrom:" + messageList.get(i).getUsername() + "BREAKLINE000";
            }
        }
        return messages;
    }

    public static String getUserMessages(String usernameSearch) {
        //get all messages from the given user
        String messages = "";
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getUsername().equals(usernameSearch)) {
                messages += messageList.get(i).getMessage() + " \t#" + messageList.get(i).getHashtag() + " \tid:" + messageList.get(i).getTimestamp() + " \tfrom:" + messageList.get(i).getUsername() + "BREAKLINE000";
            }
        }
        return messages;
    }

    public static boolean messageExists(String id) {
        //check if the message exists
        //return true if the message exists, false if not
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getTimestamp() == Integer.parseInt(id)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteMessage(String id) {
        //delete the message with the given id
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).getTimestamp() == Integer.parseInt(id)) {
                messageList.remove(i);
            }
        }
    }

    public static char[] getNumberOfMessages() {
        //get the number of messages in the message list
        return Integer.toString(messageList.size()).toCharArray();
    }

}
