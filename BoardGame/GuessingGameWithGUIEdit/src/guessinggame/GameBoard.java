/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;

import java.util.Random;

/**
 *
 * @author FYFES
 */
public class GameBoard {
    private int[][] board;
    private int rdim;
    private int cdim;
    private int numHot;
    public static final int MAXHOT = 20;
    
    public GameBoard() {
        rdim = 10;
        cdim = 10;
        board = new int[rdim][cdim];
        numHot = 10;
        
        generateHot();
        
    }
    
    public GameBoard(int r, int c, int hot) {
        rdim = r;
        cdim = c;
        numHot = hot;
        board = new int[rdim][cdim];
        
        generateHot();
    }
    
    //This method allows the possibility of the same spot being generate twice
    //and so it may generate fewer than the asked for hot spots
    private void generateHot() {
        Random rand = new Random();
        for (int i=0; i<numHot; i++) {
            int r = rand.nextInt(rdim);
            int c = rand.nextInt(cdim);
            board[r][c] = 1;
        }
    }
    
    public boolean testGuess(int r, int c) {
        if (board[r][c] == 1) {
            board[r][c] = 0;
            return true;
        }
        return false;
    }
    
    public int findNearest(int r, int c) {
        System.out.println("in find nearest");
        int top=cdim; int bottom=cdim; int right=rdim; int left=rdim;
        int positions = 0;
        
        //search right
        boolean oneFound = false;
        int current = c+1;
        while ( (current < cdim) && !oneFound)
            if (board[r][current] == 1) {
                right = current - c;
                oneFound = true;
            } 
            else {
                current++;
            }

        //search left
        oneFound = false;
        current = c-1;
        while ( (current >= 0) && !oneFound)
            if (board[r][current] == 1) {
                left = c - current;
                oneFound = true;
            } 
            else {
                current--;
            }        
        
        //search down
        oneFound = false;
        current = r+1;
        while ( (current < rdim) && !oneFound)
            if (board[current][c] == 1) {
                bottom = current - r;
                oneFound = true;
            } 
            else {
                current++;
            }

        //search left
        oneFound = false;
        current = r-1;
        while ( (current >= 0) && !oneFound)
            if (board[current][c] == 1) {
                top = r - current;
                oneFound = true;
            } 
            else {
                current--;
            }        
        
        //determine which direction is closest
        System.out.println(right + " " + left + " " + top + " " + bottom);
        if ((right > 0) && (right <= left) && (right <= top) && (right <= bottom))
            return right;
        else if ((left > 0) && (left <= right) && (left <= top) && (left <= bottom))
            return left;
        else if ((top > 0) && (top <= left) && (top <= right) && (top <= bottom))
            return top;
        else if ((bottom > 0) && (bottom <= left) && (bottom <= top) && (bottom <= right))
            return bottom;
        else
            return 0;
        
        
    }
    
    public boolean allFound() {
        for (int i=0; i<rdim; i++)
            for (int j=0; j<cdim; j++)
                if (board[i][j] == 1)
                    return false;
        
        return true;
    }
    
    public String toString() {
        String boardStr = "";
        for (int i=0; i<rdim; i++) {
            for (int j=0; j<cdim; j++)
                boardStr += board[i][j] + " ";
            boardStr += "\n";
        }
        return boardStr;
    }
}
