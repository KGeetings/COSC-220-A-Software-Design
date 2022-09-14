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
    private PlayerList thePlayers;
    
    public NumPlayerDlg(Frame owner, boolean modal, PlayerList players) {
        super(owner, modal);
        thePlayers = players;
        setLayout(new GridLayout(4,1));
        setSize(300,200);
        title = new JLabel("Start the Game");
        prompt = new JLabel("How many players?");
        numPlayersFld = new JTextField(6);
        doneBtn = new JButton("Get Players");
        doneBtn.addActionListener(new ButtonHandler());
        add(title);
        add(prompt);
        add(numPlayersFld);
        add(doneBtn);
    }
    
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int np = Integer.parseInt(numPlayersFld.getText());
            thePlayers.setMax(np);
            NumPlayerDlg.this.dispose();
        }
    }
    
}
