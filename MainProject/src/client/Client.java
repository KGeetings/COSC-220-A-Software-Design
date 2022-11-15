/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import java.util.ArrayList;

/**
 *
 * @author Kenyon
 */
public class Client {
    /**
     * @param args the command line arguments
     */

    //keep track of the user's username
    public static String username;
    public static String password;
    public static String ipAddress;

    //keep track of the user's ip address and username that we want to connect to
    public static String userIPAddress;
    public static String userUsername;
    public static ArrayList<String> userPrivateMessages = new ArrayList<String>();
    public static ArrayList<String> userPrivateMessagesUsernameReceiving = new ArrayList<String>();
    public static ArrayList<String> userPrivateMessagesUsernameSending = new ArrayList<String>();

    //keep track of the messages sent by the user for this session
    public static ArrayList<String> messages = new ArrayList<String>();
    public static ArrayList<String> hashtags = new ArrayList<String>();

    public static void main(String[] args) {
        // Run StartupWindow.java form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartupWindow sw = new StartupWindow();
                sw.setVisible(true);
            }
        });

        // Create new threads to listen for messages from the server or other clients when needed
        /* new ClientListener(2001).start(); */
        while(true){
            new ClientListener(2002).start();
        }
    }
}
