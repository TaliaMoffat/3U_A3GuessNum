/*
*Name: Talia Moffat
*Date: November 23rd, 2021 - December 9th, 2021
*Desription: Computer generates a random number within a reasonable range
that changes every round and the user has a limited number of attempts to guess 
said number with hints of "Too high!" or "Too low!" given after each guess.
*/

import java.util.*;

public class A3GuessNum{

  //Add (a) method(s)
  
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
    System.out.println("\nPlease enter 'y' for Yes or any other key for No.\n");
    String ansOne = input.nextLine(); //store input to determine if playing

    if (ansOne.equals("y")){ //Player name and greeting
      System.out.println("\nExcellent, might I know the name of my challenger?\n");
      playerName = input.nextLine();
      System.out.println("\nHi " + playerName + "!");
    } //end of playername check
    
    while (ansOne.equals("y")){ //while playing loop
      // Declaring range, answer, guesses, and counter variables.
      int range = numGenerator.nextInt(491) + 10; //range generator
      int guesses = (int)Math.sqrt(range) / 2; // to make number of guess fair (5 per 100)
      int answer = numGenerator.nextInt(range) + 1; //answer generator
      int guess = -1; // default guess num. to make loop work (-1 will never be right).
      int i = 0; // declare counter for guesses loop.

      System.out.println("\nOkay, I'm ready.");

      while (guess != answer && i < guesses - 1){ //guesses and hints loop
        int guessesLeft = guesses - i; // determines guesses left
        System.out.println("\nYou have " + guessesLeft + " guesses!");
        System.out.println("\nGuess a number between 1 and " + range + ".\n");
        String str = input.nextLine(); //stores input to be checked if numeric

        //Make an arraylist to store all guesses in that round
        //and make a loop to check for repeated guesses
        //after a round. list all guesses

        try { //catches non numeric guesses
          guess = Integer.parseInt(str); //convert str to int
        } catch (NumberFormatException e){ //if can't convert
          System.out.println("\nThat doesn't look like a number...");
          System.out.println("\nTry again!");
          continue; //doesn't count it as a guess
        } //end of try/catch numeric guess or not

        if (guess > range || guess < 1){ //Is guess in range check
          System.out.println("\nThat number seems out of the range, try again!");
          continue; //doesn't count it as a guess
        } //end of if in range check

        else if (guess > answer){ //Too high hint
          System.out.println("\nToo high!");
        } //end of else if too high
        else if (guess < answer){ //Too low hint
          System.out.println("\nToo low!");
        } //end of else if too low

        //Add freezing, cold, warm, hot hints

      i++; //could use for loop?
    } //end of guessing and hints loop

      if (guess != answer && i < guesses){ //one guess left warning (fixes grammar)
        System.out.println("\nCareful, just 1 guess left...");
        System.out.println("\nGuess a number between 1 and " + range + ".\n");
        guess = input.nextInt();
      } //end of if one guess left

      if(guess != answer){ //if lost
        System.out.println("\nNot quite challenger,");
        System.out.println("\nThe number was " + answer + ".");
      } //end of if lost 
      else if(guess == answer){ //if guess = answer
        System.out.println("\nWow, you got it in " + (i + 1) + " guesses!");
        System.out.println("\nI guess you win this round...");
      } //end of else if guess = answer

      System.out.println("\nGood game " + playerName + "!"); 
      System.out.println("\n...Play again?");
      System.out.println("\nPlease enter 'y' for Yes or any other key for No\n");
      String s = input.nextLine();
      ansOne = input.nextLine(); //necessary?

    } //closes while playing loop

    System.out.println("\nWell, feel free to come back and play any time!");
      
  }// close main
}// close class
