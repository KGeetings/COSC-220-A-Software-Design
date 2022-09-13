/*
 * This class implements a list of guesses for the guessing game
 */
package guessinggame;

import java.util.ArrayList;

/**
 *
 * @author FYFES
 */
public class GuessList {
    private ArrayList<Guess> guesses;
    
    public GuessList() {
        guesses = new ArrayList<>();
    }
    
    public void addGuess(Guess g) {
        guesses.add(g);
    }
    
}
