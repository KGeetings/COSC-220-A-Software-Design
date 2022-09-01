package boardgame;

import java.util.ArrayList;

public class Player {
    /* Add a Player class that will keep information about a single player. 
    The class should have instance variables for the name of the player, 
    the number of hotspots they guessed correctly and a list of the guesses they have made (use Java’s ArrayList). 
    The class should have a single constructor method to initialize the instance variables. Only the name needs to passed as a parameter. 
    Initialize the number of hot spots guessed and the list of guesses made to an appropriate value. 
    It should have accessor methods to get the players name and the number of hot spots guessed. 
    It should also have “mutator” methods to add 1 to the number of hot spots guessed and to add a guess to the list of guesses. */

    // instance variables
    private String name;
    private int numHotSpotsGuessed;
    private ArrayList<Guess> guesses;

    // constructor
    public Player(String name) {
        this.name = name;
        numHotSpotsGuessed = 0;
        guesses = new ArrayList<Guess>();
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public int getNumHotSpotsGuessed() {
        return numHotSpotsGuessed;
    }

    // mutator methods
    public void addHotSpotGuessed() {
        numHotSpotsGuessed++;
    }

    public void addGuessList(Guess guess) {
        guesses.add(guess);
    }

}
