package boardgame;

import java.util.Scanner;

/* The driver class will have a main method that will be used to create a game board and accept some guesses from the user. 
The main method will use the Scanner class to get input from the user. 
The method should first prompt the user for the dimensions of the board and the number of hot spots. 
It should then create a board object by calling the appropriate constructor. 
Then the method should prompt the user for guesses and tell the user if that guess is a hot spot until the user says that they don’t want to guess any more. */

/* Change the main method of the driver class to create a Board and two players. 
Prompt for all the needed information and then have each player make 10 guesses (alternating the guesses). 
After each player has made 10 guesses print out how many hot spots each guessed correctly and say who won (guessed the most hot spots). */

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
        Board board = new Board(xDim, yDim, numHotSpots);
        // prompt the user for guesses and tell the user if that guess is a hot spot until the user says that they don’t want to guess any more
        System.out.println("Enter the name of the first player: ");
        String name1 = inputScanner.next();
        Player player1 = new Player(name1);
        System.out.println("Enter the name of the second player: ");
        String name2 = inputScanner.next();
        Player player2 = new Player(name2);

        // for testing print out the board
        board.printBoard();

        // have each player make 10 guesses (alternating the guesses)
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the guess for player 1: ");
            int x1 = inputScanner.nextInt();
            int y1 = inputScanner.nextInt();
            Guess guess1 = new Guess(x1, y1, board.isHotSpot(x1, y1), board.getDistanceFromHotSpot(x1, y1));
            player1.addGuessList(guess1);
            if (board.isHotSpot(x1, y1)) {
                player1.addHotSpotGuessed();
            } else {
                System.out.println("That guess is not a hot spot.");
                System.out.println("You were " + board.getDistanceFromHotSpot(x1, y1) + " away from the hot spot.");
            }
            System.out.println("Enter the guess for player 2: ");
            int x2 = inputScanner.nextInt();
            int y2 = inputScanner.nextInt();
            Guess guess2 = new Guess(x2, y2, board.isHotSpot(x2, y2), board.getDistanceFromHotSpot(x2, y2));
            player2.addGuessList(guess2);
            if (board.isHotSpot(x2, y2)) {
                player2.addHotSpotGuessed();
            }else {
                System.out.println("That guess is not a hot spot.");
                System.out.println("You were " + board.getDistanceFromHotSpot(x1, y1) + " away from the hot spot.");
            }
        }
        // print out how many hot spots each guessed correctly and say who won (guessed the most hot spots)
        System.out.println(player1.getName() + " guessed " + player1.getNumHotSpotsGuessed() + " hot spots correctly.");
        System.out.println(player2.getName() + " guessed " + player2.getNumHotSpotsGuessed() + " hot spots correctly.");
        if (player1.getNumHotSpotsGuessed() > player2.getNumHotSpotsGuessed()) {
            System.out.println(player1.getName() + " won!");
        } else if (player1.getNumHotSpotsGuessed() < player2.getNumHotSpotsGuessed()) {
            System.out.println(player2.getName() + " won!");
        } else {
            System.out.println("It's a tie!");
        }
        // close the Scanner object
        inputScanner.close();
    }
    
}