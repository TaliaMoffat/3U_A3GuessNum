/*
*Name: Talia Moffat
*Date: November 23rd, 2021 - December 9th, 2021
*Desription: Computer generates a random number within a reasonable range
that changes every round and the user has a limited number of attempts to guess 
said number with hints of "Too high!" or "Too low!" given after each guess.
*/

import java.util.*;

public class A3GuessNum{
  
  //main method
  public static void main(String[] arg){

    // Make a scanner, random object, and default player name
    Scanner input = new Scanner(System.in);
    Random numGenerator = new Random();
    String playerName = "Unknown";

    //Greet user
    System.out.println("\nHi! Welcome to The Great Number Guessing Game!");
    System.out.println("\nShould you dare to play...");
    System.out.println("\nYou will have to guess a random number inside a range of numbers that is different each game.");
    System.out.println("You will have a limited number of guesses with hints after each guess you get wrong.");
    System.out.println("\nDo you dare to challenge me?");

    //Determine if playing 
    System.out.println("\nPlease enter 'y' for Yes or enter any key for No.\n");
    char ansOne = input.next().charAt(0);

    if (ansOne == 'y'){ //Player name and greeting
      System.out.println("\nExcellent, might I know the name of my challenger?\n");

      playerName = input.nextLine();

      System.out.println("\nHi " + playerName + "!");
    }
    
    while (ansOne == 'y'){
      // Declaring range, answer, guess, and counter variables.
      int range = numGenerator.nextInt(491) + 10;
      int guesses = (int)Math.sqrt(range) / 2; // to make number of guess fair (5 per 100)
      int answer = numGenerator.nextInt(range) + 1;
      int guess = -1; // default guess num. to make loop work (-1 will never be right).
      int i = 0; // declare counter for guesses loop.

      System.out.println("\nOkay, I'm ready.");

      while (guess != answer && i < guesses - 1){ //guesses and hints loop
        int guessesLeft = guesses - i;
        System.out.println("\nYou have " + guessesLeft + " guesses!");
        System.out.println("\nGuess a number between 1 and " + range + ".\n");
        guess = input.nextInt();
        if (guess > answer){
          System.out.println("\nToo high!");
        }
        else if (guess < answer){
          System.out.println("\nToo low!");
        }
      i++;
    }

      if (guess != answer && i < guesses){
        System.out.println("\nCareful, just 1 guess left...");
        System.out.println("\nGuess a number between 1 and " + range + ".\n");
        guess = input.nextInt();
      }

      if(guess != answer){
        System.out.println("\nNot quite challenger,");
        System.out.println("\nThe number was " + answer + ".");
      }
      else if(guess == answer){
        System.out.println("\nWow, you got it in" + (i + 1) + " guesses!");
        System.out.println("\nI guess you win this round...");
      }
      System.out.println("\nGood game " + playerName + "!"); 
      System.out.println("\n...Play again?");
      System.out.println("\nPlease enter 'y' for Yes or 'n' for No\n");
      ansOne = input.next().charAt(0);
    }

    System.out.println("\nWell, feel free to come back and play any time!");
      
  }// close main
}// close class
