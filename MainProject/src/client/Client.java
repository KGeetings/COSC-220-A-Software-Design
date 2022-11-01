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
    }
}
