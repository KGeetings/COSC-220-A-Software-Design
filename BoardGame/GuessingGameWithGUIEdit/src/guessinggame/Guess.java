package guessinggame;

/*
 * This class implements a Guess in the guessing game
 */

/**
 *
 * @author FYFES
 */
public class Guess {
    private int row;
    private int col;
    private boolean hot;
    private int distance;
    
    public Guess(int r, int c, boolean h, int d) {
        row = r;
        col = c;
        hot = h;
        distance = d;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean getHot() {
        return hot;
    }
    
    public int getDistance() {
        return distance;
    }
    
}
