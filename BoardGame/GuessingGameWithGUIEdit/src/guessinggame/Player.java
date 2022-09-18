/*
 * This class defines a Player
 */
package guessinggame;
import java.util.ArrayList;

/**
 *
 * @author FYFES
 */
public class Player {
    String name;
    int hotSpotsFound;
    ArrayList<Guess> guesses;
    
    public Player(String nm) {
        name = nm;
        hotSpotsFound = 0;
        guesses = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addGuess(int r, int c, boolean s, int n) {
        Guess g = new Guess(r,c,s,n);
        guesses.add(g);
    }
    
    public ArrayList<Guess> getGuesses() {
        return guesses;
    }
    
    public int getHosSpotsFound() {
        return hotSpotsFound;
    }
    
    public void incrementHot() {
        hotSpotsFound++;
    }
    
}
