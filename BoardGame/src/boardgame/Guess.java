package boardgame;

public class Guess {
    /* Add a Guess class that will keep information about a single guess. 
    The instance variables for this class should be an x and y location (or row, column), 
    a Boolean value that indicates if the guess was successful or not, and another int that is the distance that guess is from a hotspot. 
    The class only needs to have a single constructor which takes parameters for each of the instance variables 
    and “accessor” methods for each of the instance variables which returns the value of that instance variable. */

    // instance variables
    private int x;
    private int y;
    private boolean successfulGuess;
    private int distanceFromHotSpot;

    // constructor
    public Guess(int x, int y, boolean successfulGuess, int distanceFromHotSpot) {
        this.x = x;
        this.y = y;
        this.successfulGuess = successfulGuess;
        this.distanceFromHotSpot = distanceFromHotSpot;
    }

    // accessor methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSuccessfulGuess() {
        return successfulGuess;
    }

    public int getDistanceFromHotSpot() {
        return distanceFromHotSpot;
    }
}
