/*
 * GUI for the guessing game
 */
package guessinggame;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Stephen Fyfe
 */
public class GameGUI extends JFrame {
    JLabel titleLbl;
    JLabel infoLbl;
    JLabel resultLbl;
    JPanel gridPnl;
    JLabel[][] gridLabels;
    JButton startRndBtn;
    JLabel currentPlayerLbl;
    JButton seeGuessBtn;
    JLabel rowLbl;
    JTextField rowFld;
    JLabel colLbl;
    JTextField colFld;
    JButton makeGuessBtn;
    JPanel infoPnl;
    JPanel rowPnl;
    JPanel colPnl;
    
    public GameGUI() {
        NumPlayerDlg playerDlg = new NumPlayerDlg(this, true);
        playerDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        playerDlg.setVisible(true);
        setLayout(new BorderLayout());
        titleLbl = new JLabel("My Exciting Guessing Game!");
        //titleLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        titleLbl.setHorizontalAlignment(JLabel.CENTER);
        add(titleLbl, BorderLayout.NORTH);
        infoLbl = new JLabel("Info will go here");
        add(infoLbl, BorderLayout.WEST);
        resultLbl = new JLabel();
        resultLbl.setText("Guess Result");
        resultLbl.setHorizontalAlignment(JLabel.CENTER);
        add(resultLbl, BorderLayout.SOUTH);
        
        infoPnl = new JPanel();
        infoPnl.setLayout(new GridLayout(6,1));
        rowPnl = new JPanel();
        rowPnl.setLayout(new GridLayout(1,2));
        rowLbl = new JLabel("row:");
        rowFld = new JTextField(5);
        rowPnl.add(rowLbl);
        rowPnl.add(rowFld);
        //infoPnl.add(rowPnl);
        
        //Code added for the assignment
        colPnl = new JPanel();
        colPnl.setLayout(new GridLayout(1,2));
        colLbl = new JLabel("row:");
        colFld = new JTextField(5);
        colPnl.add(colLbl);
        colPnl.add(colFld);
        
        startRndBtn = new JButton("Start Round");
        currentPlayerLbl = new JLabel("Current Player");
        seeGuessBtn = new JButton("See Guesses");
        makeGuessBtn = new JButton("Make Guess");
        
        infoPnl.add(startRndBtn);
        infoPnl.add(currentPlayerLbl);
        infoPnl.add(seeGuessBtn);
        infoPnl.add(rowPnl);
        infoPnl.add(colPnl);
        infoPnl.add(makeGuessBtn);
        add(infoPnl, BorderLayout.EAST);
        
        gridLabels = new JLabel[10][10];
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++)
                gridLabels[i][j] = new JLabel("*");
        
        gridPnl = new JPanel();
        gridPnl.setLayout(new GridLayout(10,10));
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++)
                gridPnl.add(gridLabels[i][j]);
        
        add(gridPnl, BorderLayout.CENTER);
        
    }
}
