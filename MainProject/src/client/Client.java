/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

/**
 *
 * @author Kenyon
 */
public class Client {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // Run StartupWindow.java form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartupWindow().setVisible(true);
            }
        });
    }
}
