/*
 * GUI for the guessing game
 */
package guessinggame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
    
    private PlayerList thePlayers;
    private Player currentPlayer;
    private GameBoard board;
    
    public GameGUI() {
        thePlayers = new PlayerList();
        board = new GameBoard();
        System.out.println(board);
        NumPlayerDlg playerDlg = new NumPlayerDlg(this, true, thePlayers);
        playerDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        playerDlg.setVisible(true);
        //Need to get the player names and create the player list
        int np = thePlayers.getMaxPlayers();
        for (int i = 0; i < np; i++) {
            String name = JOptionPane.showInputDialog(this,"Enter next player's name");
            Player player = new Player(name);
            thePlayers.addPlayer(player);
        }
        currentPlayer = thePlayers.getNextPlayer();
        JOptionPane.showMessageDialog(this, currentPlayer.getName() + " it is your turn");
        JOptionPane.showMessageDialog(this, "You are the first player so click start round");
        
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
        
        colPnl = new JPanel();
        colPnl.setLayout(new GridLayout(1,2));
        colLbl = new JLabel("col:");
        colFld = new JTextField(5);
        colPnl.add(colLbl);
        colPnl.add(colFld);
        
        startRndBtn = new JButton("Start Round");
        startRndBtn.addActionListener(new StartHandler());
        currentPlayerLbl = new JLabel(currentPlayer.getName());
        seeGuessBtn = new JButton("See Guesses");
        seeGuessBtn.setEnabled(false);
        seeGuessBtn.addActionListener(new SeeGuessHandler());
        makeGuessBtn = new JButton("Make Guess");
        makeGuessBtn.setEnabled(false);
        makeGuessBtn.addActionListener(new GuessHandler());
        
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
    
    private class StartHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeGuessBtn.setEnabled(true);
            seeGuessBtn.setEnabled(true);
            startRndBtn.setEnabled(false);
        }
    }
    
    private class GuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = Integer.parseInt(rowFld.getText());
            int col = Integer.parseInt(colFld.getText());
            boolean result = board.testGuess(row, col);
            if (result) {
                board.removeHot(row,col);
                gridLabels[row][col].setText("1");
                currentPlayer.addGuess(row, col, result, 0);
                currentPlayer.incrementHot();
                resultLbl.setText("Congratulations!  You found a hot spot!");
            }
            else {
                int distanceToHot = board.findNearest(row, col);
                currentPlayer.addGuess(row, col, result, distanceToHot);
                resultLbl.setText("Sorry, try again you were " + distanceToHot + "spaces from a hot spot");
            }
            
            //Have all the hotspots been found?
            if (board.allFound()) {
                //code for determine the winner use case goes here
            }
            else {
                if (thePlayers.isLastPlayer()){
                    startRndBtn.setEnabled(true);
                    makeGuessBtn.setEnabled(false);
                    seeGuessBtn.setEnabled(false);
                    //code for list current status goes here
                }
                
                currentPlayer = thePlayers.getNextPlayer();
                currentPlayerLbl.setText(currentPlayer.getName());
                JOptionPane.showMessageDialog(GameGUI.this, currentPlayer.getName() + " it is your turn");
                if (thePlayers.isFirstPlayer()) {
                    JOptionPane.showMessageDialog(GameGUI.this, "Click Start Round to begin the round");
                }
                
            }
            
        }
    }
    
    private class SeeGuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Guess> guesses = currentPlayer.getGuesses();
            String guessesStr = "<html>";
            for (Guess g: guesses) {
                String oneGuessStr = g.toString();
                guessesStr = guessesStr + oneGuessStr + "<br>";
            }
            infoLbl.setText(guessesStr);
            
        }
    }
}
