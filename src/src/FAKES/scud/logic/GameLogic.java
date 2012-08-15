//FAKE
//FAKE
//FAKE
//FAKE

package scud.logic;

import java.util.ArrayList;
import scud.app.ScudUI;
/**
* FAKE Game Logic class
*/

public class GameLogic
{
   /**
    * Constructs a new GameLogic with the specified xml file containing all
    * the game information (see included testlevel.xml for example of a proper
    * game world file).
    *
    * @param inputFileName the name of the file to generate the game world
    * from.
    */
    public GameLogic(String Filename)
    {

    }


    /**
    * Executes an action by taking what the player typed in
    * to the prompt and turning it into an action from the
    * current game data file. If there is no action
    * in the current room for what the player entered
    * it will report that in the text it returns and
    * exit gracefully.
    *
    * @param actionText The name of the action ex: "search chest"
    * @param userInterface Either the console or graphical ui
    * so information from the action can be displayed to the user.
    *
    * @return a block of text describing the results of the player's action
    */
    public boolean executeAction(String actionText, ScudUI userInterface)
    {
        if (actionText.equals("return true"))
        {
            userInterface.displayText("There is more text to display");
            return true;
        }
        else
        {
            userInterface.displayText("The GameLogic executeAction was called with : " + actionText);
            return false;

        }
    }

    
   /**
    * Lists all the possible actions in the current room
    *
    * @return a list of actions possible in the current room
    */
    public ArrayList<String> getActionNames()
    {
        return new ArrayList<String>();
    }

   /**
    * Lists all the items in the player's inventory
    *
    * @return a list of inventory item names
    */
    public ArrayList<String> getInventory()
    {
        ArrayList<String> items = new ArrayList<String>();
        items.add("Fake item");
        return items;
    }

}

