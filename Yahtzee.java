/***************************************
Yahtzee.java
Author: David Brungardt
This program simulates a game of Yahtzee.
The game starts with the rolling of 5 dice, then
the user is prompted to enter which dice to re-roll (or 0 for none).
After the user has had two chances to re-roll the dice, the program asks
if you would like to enter "cheater" mode (for grading purposes).
Finally the program evaluates which numbers were rolled on all 5 dice at the end of the game.
If the user gets 5 of a kind, the program prints "YAHTZEE!!!"
If the user gets 5 in a row, the program prints "Large Straight!!!"
If the user gets any 4 in a row, the program prints "Small Straight!!!"
If the user gets 4 of a kind, the program prints "Four of a Kind!!!"
If the user gets 2 of one kind and 3 of another, the program prints "Full House!!!"
If the user gets 3 of a kind, the program prints "Three of a Kind!!!"
Finally if the dice show none of these conditions, the program prints "Better luck next time."
Only the highest condition is evaluated, so if the user gets 5 of a kind and 4 of a kind,
the program will only print "YAHTZEE!!!"
*****************************************/
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Yahtzee
{
  public static void main(String[] args)
  {

    ArrayList<Integer> reRoll = new ArrayList<Integer>(); // array to keep track of dice to be re-rolled
    ArrayList<Integer> reRoll2 = new ArrayList<Integer>(); // array to keep track of dice to be re-rolled
    boolean isCheaterMode = false; // cheater mode boolean for grading purposes
    int[] dice = new int[5]; // array to hold dice 1-5
    int i; // counter variable
    int tempVal; // temporary value for storing user input during checks
    int tempReRoll; // temporary value for storing user input
    Random r = new Random(); // random number generator
    Scanner userScanner = new Scanner(System.in); // scanner to receive user input
    String userInput; // Input from user
    String cheaterModeString; // string for cheater mode user input

    //generate the dice rolls
    System.out.print("\nDice Roll: ");
    for (i = 0; i < 5; i++)
    {
      dice[i] = r.nextInt(6) + 1;
    }
    //display the dice rolls
    for (i = 0; i < 5; i++)
    {
      System.out.print(dice[i] + " ");
    }
    System.out.println();

    /*************************************************************************
    SECOND ROLL STARTS HERE
    **************************************************************************/

    // ask user which dice they would like to re-roll
    // value must be between 1 and 5 since we are using 5 dice.
    System.out.println("\nWhich dice would you like to roll again?");
    System.out.println("List each die (1-5) seperated by a space.");
    System.out.println("Type \"0\" if you do not wish to re-roll any dice.\n");

    // read in input from the user
    userInput = userScanner.nextLine();

    // indicate next roll of the dice
    System.out.print("\nDice Roll: ");

    // scanner to read user input from string.
    Scanner scnr = new Scanner(userInput);

    // While there is another int in the string.
    while(scnr.hasNextInt())
    {
      // Take input from the user
      tempVal = scnr.nextInt();

      // if user did not select zero
      if (tempVal != 0)
      {
        // if user selects die 1-5
        if (tempVal > 0 && tempVal < 6)
        {
          // add integers to reRoll ArrayList
          reRoll.add(tempVal);
        }
        else
        {
          // Print error message
          System.out.println("Invalid entry.");
        }

      }
      else
      {
        System.out.println("No dice will be re-rolled.");
      }

    } // end of while loop

    // Re-shuffle dice selected by user.
    for (i = 0; i < reRoll.size(); i++)
    {
      tempReRoll = reRoll.get(i);
      dice[(tempReRoll - 1)] = (r.nextInt(6) + 1);
    }

    //display the dice rolls
    for (i = 0; i < 5; i++)
    {
      System.out.print(dice[i] + " ");
    }
      System.out.println();

/*************************************************************************
THIRD ROLL STARTS HERE
**************************************************************************/

    // ask user which dice they would like to re-roll
    // value must be between 1 and 5 since we are using 5 dice.
    System.out.println("\nWhich dice would you like to roll again?");
    System.out.println("List each die (1-5) seperated by a space.");
    System.out.println("Type \"0\" if you do not wish to re-roll any dice.\n");

    // read in input from the user
    userInput = userScanner.nextLine();

    // indicate next roll of the dice
    System.out.print("\nDice Roll: ");

    // scanner to read user input from string.
    Scanner scnr2 = new Scanner(userInput);

    // While there is another int in the string.
    while(scnr2.hasNextInt())
    {
      // Take input from the user
      tempVal = scnr2.nextInt();

      // if user did not select zero
      if (tempVal != 0)
      {
        // if user selects die 1-5
        if (tempVal > 0 && tempVal < 6)
        {
          // add integers to reRoll ArrayList
          reRoll2.add(tempVal);
        }
        else
        {
          // Print error message
          System.out.println("Invalid entry.");
        }

      }
      else
      {
        System.out.println("No dice will be re-rolled.");
      }

    } // end of while loop

    // Re-shuffle dice selected by user.
    for (i = 0; i < reRoll2.size(); i++)
    {
      tempReRoll = reRoll2.get(i);
      dice[(tempReRoll - 1)] = (r.nextInt(6) + 1);
    }

    //display the dice rolls
    for (i = 0; i < 5; i++)
    {
      System.out.print(dice[i] + " ");
    }
    System.out.println();

    // Ask user if they would like to enter cheater mode (for grading purposes)
    System.out.println("\nEngage cheater mode? (Type \"Yes\" or \"No\")");
    cheaterModeString = userScanner.nextLine();

    // if the user would like to enter cheater mode
    if (cheaterModeString.equalsIgnoreCase("yes"))
    {
      isCheaterMode = true;
    }
    // if the user would not like to enter cheater mode
    else if (cheaterModeString.equalsIgnoreCase("No"))
    {
      isCheaterMode = false;
    }
    // if the user enters something else
    else
    {
      System.out.println("Input was invalid");
    }

    // if cheater mode is activated
    if (isCheaterMode == true)
    {
      // loop through each item in array
      for (i = 0; i < dice.length ; i++)
      {
        // prompt the user to assign a value for each die
        System.out.println("Please enter the enter the value for dice number " + (i + 1) + ": ");
        tempVal = userScanner.nextInt();

        // if user input is between 1 and 6
        if (tempVal >= 1 && tempVal <= 6)
        {
          dice[i] = tempVal; // assign each value based on the user input
        }
        else // if user enters an invalid number
        {
          // display an error message.
          System.out.println("Input was invalid.");
        }
      }
    }

    //Create a counts array, set all values to zero.
    int[] counts = new int[6];
    for (i = 0; i < 6; i++)
    {
      counts[i] = 0;
    }
    //count up the values
    for (i = 0; i < 5; i++)
    {
      /* diceIndex will hold the value of the dice location
      minus one. This is so it can be placed in the 0th
      based array, in the correct location.*/
      int diceIndex = dice[i] - 1;
      /* This will go to the location reserved for the dice and
      increment its value by 1.
      For example, if the value of the die was 4, the diceIndex
      value would be 3. This would increment counts[3] by one.
      Now it’s easy to tell how many 4s there are, because each
      time there is a 4, it will increment the count[3] location
      by one again.*/
      counts[diceIndex]++;
    } // end of for-loop

    /*This prints out how many of each number there is. COMMENT IT
    OUT WHEN YOU ARE DONE WITH IT.
    System.out.println();
    for (i = 0; i < 6; i++)
    {
      System.out.println("The number of " + (i+1) + "s is : " + counts[i]);
    }*/
    
    // display results of the game
    if ((counts[0] == 5 || counts[1] == 5 || counts[2] == 5 || counts[3] == 5 || counts[4]== 5 || counts[5] == 5))
    {
      // if user has five of a kind, display Yahtzee
      System.out.println("\nYAHTZEE!!!");
    }
    else if (((counts[0] >= 1 && counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1) || (counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1)))
    {
      // if the user has five in a row, display Large Straight
      System.out.println("\nLarge Straight!!!");
    }
    else if (((counts[0] >= 1 && counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1) || (counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1) || (counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1)))
    {
      // if a 4 in a row exists, display Small Straight
      System.out.println("\nSmall Straight!!!");
    }
    else if ((counts[0] == 4 || counts[1] == 4 || counts[2] == 4 || counts[3] == 4 || counts[4]== 4 || counts[5] == 4))
    {
      // if the user has four of a kind, display Four of a Kind.
      System.out.println("\nFour of a Kind!!!");
    }
    else if (((counts[0] == 3 || counts[1] == 3 || counts[2] == 3 || counts[3] == 3 || counts[4] == 3 || counts[5] == 3) && (counts[0] == 2 || counts[1] == 2 || counts[2] == 2 || counts[3] == 2 || counts[4] == 2 || counts[5] == 2)))
    {
      // if the user has two of a kind and three of a kind, display Full House
      System.out.println("\nFull House!!!");
    }
    else if ((counts[0] == 3 || counts[1] == 3 || counts[2] == 3 || counts[3] == 3 || counts[4] == 3 || counts[5] == 3))
    {
      // if the user has three of a kind, display Three of a Kind
      System.out.println("\nThree of a Kind!!!");
    }
    else
    {
      // inform the user that they didn't score
      System.out.println("\nBetter luck next time.");
    }

  } // end of main method
} // end of Yahtzee class
