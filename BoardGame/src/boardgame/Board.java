package boardgame;

/* Written by KGeetings */

public class Board {

// Instance variables
    // game board - a 2D array of int that will store 0s and 1s
    private int[][] gameBoard;
    // x dim - the number of spots on the board in the x direction
    private int xDim;
    // y dim - the number of spots on the board in the y direction
    private int yDim;
    // number of hot spots - the number of hot spots on the board
    private int numHotSpots;

// Methods
    // default constructor that initializes x dim, y dim, and hot spots all to 10 and then initializes the game board to be a 10 x 10 array with 10 hot spots. 
    // The method should first set all positions of the board to be 0 and should then use Java’s Random class to generate 10 random positions on the board and set those positions to 1. 
    // Don’t worry about duplicating the same position as a hot position for now (unless you want to)
    public Board() {
        xDim = 10;
        yDim = 10;
        numHotSpots = 10;
        gameBoard = new int[yDim][xDim];
        for (int i = 0; i < yDim; i++) {
            for (int j = 0; j < xDim; j++) {
                gameBoard[i][j] = 0;
            }
        }
        for (int i = 0; i < numHotSpots; i++) {
            int x = (int) (Math.random() * xDim);
            int y = (int) (Math.random() * yDim);
            gameBoard[y][x] = 1;
        }
    }

    // a constructor that takes an x, y and hot spots as parameters to initialize those instance variables, and creates the board with those x and y dimensions and number of hot spots
    public Board(int x, int y, int hotSpots) {
        xDim = x;
        yDim = y;
        numHotSpots = hotSpots;
        gameBoard = new int[yDim][xDim];
        for (int i = 0; i < yDim; i++) {
            for (int j = 0; j < xDim; j++) {
                gameBoard[i][j] = 0;
            }
        }
        // check if the number of entered hot spots is greater than the number of spots on the board
        if (hotSpots > x * y) {
            System.out.println("The number of hot spots is greater than the number of spots on the board. Please restart the program and enter a smaller number of hot spots.");
        } else {
            // verify that our expected hot spots are actually hot spots
            while (countHotSpots() < hotSpots) {
                int xHotSpot = (int) (Math.random() * xDim);
                int yHotSpot = (int) (Math.random() * yDim);
                gameBoard[yHotSpot][xHotSpot] = 1;
            }

        }
    }

    // count the number of hot spots on the board
    public int countHotSpots() {
        int numHotSpotsOnBoard = 0;
        for (int i = 0; i < yDim; i++) {
            for (int j = 0; j < xDim; j++) {
                if (gameBoard[i][j] == 1) {
                    numHotSpotsOnBoard++;
                }
            }
        }
        return numHotSpotsOnBoard;
    }

    // appropriate accessor (get) methods that simply return the value of the x dimension, y dimension and the number of hot spots
    public int getXDim() {
        return xDim;
    }

    public int getYDim() {
        return yDim;
    }

    public int getNumHotSpots() {
        return numHotSpots;
    }

    // reset method that takes no parameters and resets the game board using the already defined dimensions and number of hot spots
    public void reset() {
        for (int i = 0; i < yDim; i++) {
            for (int j = 0; j < xDim; j++) {
                gameBoard[i][j] = 0;
            }
        }
        for (int i = 0; i < numHotSpots; i++) {
            int xHotSpot = (int) (Math.random() * xDim);
            int yHotSpot = (int) (Math.random() * yDim);
            gameBoard[yHotSpot][xHotSpot] = 1;
        }
    }

    // a guess method that takes an x and y position on the board and returns a value that indicates whether or not that position is a hot spot
    // if the position is out of range, we will return "out of range"
    public String guess(int x, int y) {
        if (x < 0 || x >= xDim || y < 0 || y >= yDim) {
            return "out of range";
        } else if (gameBoard[y][x] == 1) {
            return "hot spot";
        } else {
            return "cold spot";
        }
    }

    // print out the game board
    public void printBoard() {
        for (int i = 0; i < yDim; i++) {
            for (int j = 0; j < xDim; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

}