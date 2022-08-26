package boardgame;

import java.util.Scanner;

/* The driver class will have a main method that will be used to create a game board and accept some guesses from the user. 
The main method will use the Scanner class to get input from the user. 
The method should first prompt the user for the dimensions of the board and the number of hot spots. 
It should then create a board object by calling the appropriate constructor. 
Then the method should prompt the user for guesses and tell the user if that guess is a hot spot until the user says that they don’t want to guess any more. */

public class Driver {
    
    public static void main(String[] args) {
        // get input from the user, using the Scanner class
        Scanner inputScanner = new Scanner(System.in);
        // prompt the user for the dimensions of the board and the number of hot spots
        System.out.println("Enter the dimensions of the board: ");
        int xDim = inputScanner.nextInt();
        int yDim = inputScanner.nextInt();
        System.out.println("Enter the number of hot spots: ");
        int numHotSpots = inputScanner.nextInt();
        // create a board object by calling the appropriate constructor
        Board gameBoard = new Board(xDim, yDim, numHotSpots);

        // for testing, print the game board
        gameBoard.printBoard();

        // prompt the user for guesses and tell the user if that guess is a hot spot until the user says that they don't want to guess any more
        System.out.println("Enter your guesses (x, y): ");
        while (inputScanner.hasNextInt()) {
            int x = inputScanner.nextInt();
            int y = inputScanner.nextInt();
            if (gameBoard.guess(x, y) == "hot spot") {
                System.out.println("hot spot");
            } else {
                System.out.println("cold spot");
            }
            System.out.println("Enter your guesses (x, y): ");
        }
        // close the Scanner object
        inputScanner.close();
    }
    
}