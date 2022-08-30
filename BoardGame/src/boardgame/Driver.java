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
        // have each player make 10 guesses (alternating the guesses)
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the x and y coordinates of " + player1.getName() + "'s guess: ");
            int x = inputScanner.nextInt();
            int y = inputScanner.nextInt();
            Guess guess = board.guess(x, y);
            player1.addGuess(guess);
            if (guess.isSuccessfulGuess()) {
                player1.addHotSpotGuessed();
            }
            System.out.println("Enter the x and y coordinates of " + player2.getName() + "'s guess: ");
            x = inputScanner.nextInt();
            y = inputScanner.nextInt();
            guess = board.guess(x, y);
            player2.addGuess(guess);
            if (guess.isSuccessfulGuess()) {
                player2.addHotSpotGuessed();
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