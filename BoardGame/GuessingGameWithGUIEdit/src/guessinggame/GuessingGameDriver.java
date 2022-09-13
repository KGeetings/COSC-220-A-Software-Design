/*
 * This class is the driver for the guessing game
 */
package guessinggame;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author FYFES
 */
public class GuessingGameDriver {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameGUI gui = new GameGUI();
        gui.setSize(600,600);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        
        
    }
    
}
