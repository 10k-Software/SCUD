
package scud.app;

import java.util.ArrayList;
import java.util.Scanner;
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
        gameLogic = logic;
        scanner = new Scanner(System.in);
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
        // START with "look" command 
        String input = "look";
        // IS there more to read? Not right now.
        boolean moreToRead = false;
        // PRINT the title screen
        displayText(ScudApp.getTitle());

        // WAIT until the user hits enter to continue
        System.out.println("\n\n\n\t\t       Press Enter to Continue\n");
        scanner.nextLine();

        // WHILE the user does not want to quit
        while (!input.equals("quit"))
        {
            // IF the user wants help
            if (input.equals("help") && !moreToRead)
            {
                // PRINT the help screen
                this.printHelp();
            }
            // ELSE IF the user wants to see their inventory
            else if (input.equals("inventory") && !moreToRead)
            {
                // PRINT the inventory screen
                this.printInventory();
            }
            else
            {
                // SEND the input to the game logic and let it handle it
                moreToRead = gameLogic.executeAction(input, this);

                // IF there is more text for the game logic to print
                if(moreToRead)
                {
                    // Any extra commands will not be handled until
                    // the rest of the text needed to be printed by
                    // the game logic is actually printed. 
                    // WAIT to let the user have a chance to 
                    // read the description, and when they 
                    // press enter, even if they type in another command, 
                    // more text will be printed, and the new command will
                    // ignored. Excess commands will NOT be saved.
                    System.out.println("Press Enter to Continue.");
                }
                else
                {
                    // The UI can accept and handle new commands now
                    // Let the user know that more input will be accepted
                    System.out.print(" > ");
                }
            }

            // RETRIEVE user input
            input = scanner.nextLine();
            // CLEAN up the user input so that it can be easily verified
            input = cleanUpInput(input);
        }

        System.out.println("\nThank you for playing!\n");
    }

    /**
     * Prints a help screen to the console that also lists the available
     * user commands for both the game and the current room.
     */
    private void printHelp()
    {
        // PRINT out the help text
        String helpText = "\nWelcome to Project SCUD! To help you play this "
        +"user-created game, the following commands may be used in any room:\n"
        +"\nhelp: show the help screen" 
        +"\ninventory: show the inventory screen"
        +"\nquit: exit the game. The game will not be saved\n\n"
        +"The following commands are specific to this room:\n\n";

        System.out.println(helpText);

        // RETRIEVE the list of actions from the game logic
        ArrayList<String> actionList = gameLogic.getActionNames();

        // FOR each action in the list of available actions
        for (String actionText: actionList)
        {
            // FORMAT the action string into a list item and print it
            actionText = actionText + "\n";
            System.out.println(actionText);

        }
        
        System.out.print("look\n\n > ");

    }


    /**
     * Retrieves the player's inventory and prints it to the screen in the
     * form of a list
     */
    private void printInventory()
    {
        // RETRIEVE the list of inventory items from the game logic
        ArrayList<String> inventList = gameLogic.getInventory();

        System.out.println("\nBelow is your character's inventory list:\n");

        // FOR each inventory item in the list
        for (String inventText: inventList)
        {
            // FORMAT the item string into a list item and print it
            inventText = "-" + inventText + "\n";
            System.out.println(inventText);

        }
        System.out.print("\n > ");
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
        // REMOVE leading and trailing whitespace
        userInput = userInput.trim();
        // FORMAT the input to be all lower case
        userInput = userInput.toLowerCase();

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
        System.out.println(text);
    }

}
