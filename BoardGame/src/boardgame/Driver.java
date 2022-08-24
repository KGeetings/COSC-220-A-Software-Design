package boardgame;

import java.util.Scanner;

/* The driver class will have a main method that will be used to create a game board and accept some guesses from the user. 
The main method will use the Scanner class to get input from the user. 
The method should first prompt the user for the dimensions of the board and the number of hot spots. 
It should then create a board object by calling the appropriate constructor. 
Then the method should prompt the user for guesses and tell the user if that guess is a hot spot until the user says that they don’t want to guess any more. */

public class Driver {
    
    public static void main(String[] args) {
        Board b = new Board();
        // print out the board to see if it is working
        b.printBoard();

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter x and y guess: ");
        int x = inputScanner.nextInt();
        int y = inputScanner.nextInt();
        System.out.println(b.guess(x,y));
        /* String input = inputScanner.nextLine();
        int inputInt = inputScanner.nextInt();
        inputScanner.nextLine(); */
        
        inputScanner.close();
    }
    
}