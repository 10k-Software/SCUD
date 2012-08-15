
package scud.app;

import java.util.Scanner;

import scud.app.ScudUI;
import scud.logic.GameLogic;

/**
 * ConsoleUI is a user interface for the program Project SCUD that uses
 * the console to interact with the user. The user can interact with the
 * game via a variety of commands. Some of these commands are hard-coded,
 * such as displaying the inventory, while others are game-file dependent,
 * such "move south." The hard-coded commands currently include: inventory,
 * help, and quit. See the description of initUI() for more on these commands.
 *
 * @author Lisa Hunter
 * @version 0.3
 * @.date 2008-10-12
 * @see #initUI()
 */
//Version History
//  10/16/2008 Lisa Hunter added algorithm pseudocode

public class ConsoleUI implements ScudUI 
{

    /**
     * Handles the functionality of the game
     */
    private GameLogic gameLogic;
    /**
     * Used to get the input from the user
     */
    private Scanner scanner;


    /**
     * Constructs the game's components for the command-line
     * user interface with the inputed game logic.
     *
     * @param logic the game logic initialized with the proper game file
     */
    public ConsoleUI(GameLogic logic)
    {
        System.out.println("The ConsoleUI constructor was called.");
        
    }



    /**
     * Runs the command-line version of the platform. It takes in input for the
     * user and passes it on to the game logic. Hard-coded actions include:
     * quit, help, inventory. Quit will entirely exit out of the program; help
     * provide descriptions on both the hard-coded user commands and the
     * game-file-dependent commands; inventory lists all of the items the
     * player currently has. The input does not have to make sense as the
     * function only passes it on to executeAction(), which then handles it
     * appropriately.
     *
     */
    public void initUI()
    {
       System.out.println("The ConsoleUI has been initialized.");
    }

    /**
     * Prints a help screen to the console that also lists the available
     * user commands for both the game and the current room.
     */
    private void printHelp()
    {
        System.out.println("ConsoleUI printHelp method has been called.");
    }


    /**
     * Retrieves the player's inventory and prints it to the screen in the
     * form of a list
     */
    private void printInventory()
    {
        System.out.println("ConsoleUI printInventory method has been called.");
    }


    /**
     * Cleans up an inputed string by removing trailing white and
     * making each letter lower-cased. This is useful for making
     * input more generic so that later functions do not have to handle
     * its formatting at a later date.
     *
     * @param userInput the inputed string to be cleaned
     * @return the cleaned-up version of the input
     */
    private static String cleanUpInput(String userInput)
    {
        return userInput;
    }


    /**
     * Prints the inputed text to the console. This is mostly used by other
     * objects to write to this user interface.
     *
     * @param text the desired text to be sent to the console
     */
    public void displayText(String text) 
    {
        System.out.println("ConsoleUI is now displaying the text:" + text);
    }

}
