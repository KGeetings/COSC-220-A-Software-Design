/*
 * Dialog Box to get the number of players
 */
package guessinggame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author FYFES
 */
public class NumPlayerDlg extends JDialog {
    JLabel title;
    JLabel prompt;
    JTextField numPlayersFld;
    JButton doneBtn;
    
    public NumPlayerDlg(Frame owner, boolean modal) {
        super(owner, modal);
        setLayout(new GridLayout(4,1));
        setSize(300,200);
        title = new JLabel("Start the Game");
        prompt = new JLabel("How many players?");
        numPlayersFld = new JTextField(6);
        doneBtn = new JButton("Get Players");
        add(title);
        add(prompt);
        add(numPlayersFld);
        add(doneBtn);
    }
    
}
