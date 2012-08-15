package scud.logic;

import java.net.URL;
import java.util.ArrayList;
import scud.parser.LevelParser;
import scud.app.ScudUI;
import scud.data.Action;
import scud.data.EnvironmentLibrary;
import scud.data.Item;


/**
* GameLogic is a game-logic-processing engine. It takes
* a text action such as "search chest" and evaluates the corresponding
* action as defined in the game data file. It then enacts the results of
* those actions and reports back to the player the results in text.
* Undefined commands are replied
* to with the default action-failed response.
*<p>
* The game logic queries the
* EnvironmentLibrary for data about the world when executing actions
* and passes objects such as the items to give to the player back into the
* EnvironmentLibrary so the player now has them.
* @author Nick Artman
* @version 0.3
* @.date 2008-10-12
*/
//Version History
//  10/16/2008 Nick Artman added algorithm pseudocode

public class GameLogic
{
    /**
     * The environment library holds all the data about the world the player
     * is in, including the locations and items that exist, and what the player
     * can do and the items he currently possesses.
     */
    private EnvironmentLibrary lib;
    
   /**
    * The default game file
    */
    private static final String kDEFAULTFILE = "/scud/resources/Testlevel.xml";

    /**
     * The storage of text waiting to be printed to the user interface.
     * Whenever the player does something, the resulting text that is
     * going to be displayed to them is stored within the print queue, so that
     * only one chunk of text from the queue is displayed at a time,
     * making reading large blocks of text easier on the player.
     */
    private ArrayList<String> printQueue = new ArrayList<String>();

   /**
    * Constructs a new GameLogic with the specified xml file containing all
    * the game information (see included testlevel.xml for example of a proper
    * game world file).
    *
    * @param inputFileName the name of the file to generate the game world
    * from.
    */
    public GameLogic(String inputFileName)
    {
        // CREATE the environment library
        LevelParser parser = new LevelParser();

        // PROPAGATE the data into the library from the input file
        try
        {
            if(inputFileName == null)
            {
                URL file = getClass().getResource(kDEFAULTFILE);
                this.lib = parser.generateWorld(file);
            }
            else
            {
                this.lib = parser.generateWorld(new URL("file:" + inputFileName));
            }
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
           System.exit(-1);
        }
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

        // YIELDS true if there is more text left to be printed after this is
        // called
        boolean moreText = true;


        // IF there's nothing in the print queue
        if (printQueue.isEmpty())
        {
            // EXECUTE an action
            this.evaluateAction(actionText);
        }

        // IF there is text left that needs to be printed
        if(!printQueue.isEmpty())
        {
            // DISPLAY the next chunk of text to the user
            userInterface.displayText(popPrintQueue());

            // IF the print queue has now been emptied
            if (this.printQueue.size() == 0)
            {
                // RETURN false, as there is no more text to print
                moreText = false;
            }
        }

        return moreText;
    }


    /**
     * Evaluates given text to determine if it specifies a valid action for the
     * current room, and if so, does the action (via doAction).
     *
     * @param actionText The text name of the action, such as "search chest"
    */
    private void evaluateAction(String actionText) 
    {
        
        // The action being evaluated
        Action action;
        // All of the valid actions for the room
        ArrayList<Action> validActions;        
        // The text names of all the actions available in the current room
        ArrayList<String> validActionNames;
        // Used to match an action name with the associated object
        int indexOfCurrentAction;

        // IF the user looks around the room
        if (actionText.equals("look"))
        {
            this.addTextToPrintQueue(
            this.lib.getCurrentRoom().getDescription());
        }
        // IF the string is neither empty nor null
        else if (actionText != null || actionText.equals(""))
        {
            
            // GET a list of the actions a user can do in the current room
            validActions = this.lib.getActionList();

            // CONVERT the list of actions into just their names (what the user
            // would type)
            validActionNames = this.getActionNames();

            // CONVERT the current action from a name into an action object
            indexOfCurrentAction = validActionNames.indexOf(actionText);

            // IF the action the user entered is valid
            if (indexOfCurrentAction != -1)
            {
                action = validActions.get(indexOfCurrentAction);
                // CALL doAction with action obtained, which is valid
                this.doAction(action);
            }
            // ELSE print an error message
            else
            {
                this.addTextToPrintQueue("You try to "
                + actionText 
                + " but fail miserably. Why don't you go cry about it?\n");
            }
        }
    }

   /**
    * Executes an Action, including checking for items, giving/taking
    * items, and then going on to the correct action
    *
    * @param action the action to be fulfilled
    */
    private void doAction(Action action)
    {
        // The items required to complete the action
        ArrayList<Integer> requiredItems;
        // Items the player will be given if the player completes the action
        ArrayList<Integer> itemsAdded;
        // Items the player loses
        ArrayList<Integer> itemsRemoved;
        // Stores the ID of the room to move the player to [for lookup]
        Integer roomToMoveToID;
        

        // GET the items required for the action
        requiredItems = action.getItemsRequired();

        // IF the item check passes or there is no item check
        if (requiredItems == null || lib.getPlayer().hasItems(requiredItems))
        {

            // ENQUEUE the action's description
            this.addTextToPrintQueue(action.getDescription());

            // ADD any items the player gains with this action to their
            // inventory
            itemsAdded = action.getItemsAdded();
            // IF there are items to give the player from this action
            if (itemsAdded != null)
            {
                lib.getPlayer().giveItems(itemsAdded);
            }

            // REMOVE any items the player loses with this action 
            // (if available)
            itemsRemoved = action.getItemsRemoved();
            // IF there are items to take from the player due to this action
            if (itemsRemoved != null)
            {
                lib.getPlayer().takeItems(itemsRemoved);
            }

            // MOVE the player if necessary
            roomToMoveToID = action.getMove();
            // IF the player should be moved as a result of this action
            if (roomToMoveToID != null)
            {
                // CONVERT the room ID into a room object and move if necessary
                lib.moveRoom(lib.getRoom(roomToMoveToID));
                // ENQUEUE the room description
                this.addTextToPrintQueue(
                    this.lib.getRoom(roomToMoveToID).getDescription());
            }
            
            // IF there is a next action in the event of a successful action
            if (action.getSuccessAction() != null)
            {
                // LOOK up the next action to perform (by ID) and do it
                this.doAction(this.lib.getAction(action.getSuccessAction()));
            }
        }
        // ELSE the user failed the item check
        else if (action.getFailureAction() != null)
        {
            // GET the next action to perform in an action failure and do it
            this.doAction(this.lib.getAction(action.getFailureAction()));
        }
    }


   /**
    * Lists all the possible actions in the current room
    *
    * @return a list of actions possible in the current room
    */
    public ArrayList<String> getActionNames()
    {
        // The current action being processed
        ArrayList<Action> actions;
        // List of all the action names
        ArrayList<String> actionNames = new ArrayList<String>();

        // GET the list of all the action objects
        actions = this.lib.getActionList();
        
        // CHECK that the list is not null
        if (actions == null) 
        {
            actionNames.add("Action list is NULL");
        }
        
        // GET a list of all the action names
        for(Action currAction : actions)
        {
            
            // IF the action is null, note that where the name would be
            if (currAction == null) 
            {
                actionNames.add("NULL ACTION");
            }
            // ELSE IF the action's name is null
            else if (currAction.toString() == null)
            {
                // MAKE a note that it is null
                actionNames.add("NULL ACTION NAME\n");
            }
            // ELSE add the action name to the list
            else
            {
                actionNames.add(currAction.toString());
            }
        }

        return actionNames;
    }

   /**
    * Lists all the items in the player's inventory
    *
    * @return a list of inventory item names
    */
    public ArrayList<String> getInventory()
    {
        // The currently executing item
        ArrayList<Integer> itemIDs;
        // The text list of the item names
        ArrayList<String> itemNames = new ArrayList<String>();
        // Current item being processed
        Item currentItem;

        // GET the inventory item list
        itemIDs = this.lib.getPlayer().getInventory();

        // FOR each item in the list
        // GET a list of all of the item names
        for(Integer currItemID : itemIDs)
        {
            currentItem = this.lib.getItem(currItemID);

            // IF the item does not exist
            if (currentItem == null)
            {
                // NOTE that where its name would be
                itemNames.add("NULL ITEM");
            }
            // IF the item name does not exist, print an error for its name
            else if (currentItem.getName() == null)
            {
                itemNames.add("NULL ITEM NAME");
            }
            // IF the item exists and is named
            else
            {
                // PUT its name in the list of inventory item names
                itemNames.add(currentItem.getName());
            }
        }

        return itemNames;
    }

   /**
    * Adds a chunk of text to the printing queue
    *
    * @param text a block of text to add to end of the print queue
    */
    private void addTextToPrintQueue(String text) 
    {

        // Temporarily-used array that stores the chunks
        // to add to the queue after they're split up
        String[] textChunks;

        // The last chunk of text in the queue
        String lastItemInQueue;

        // Used in the for loop that puts the elements of the
        // textChunks array into an resizeable array
        int currentChunkNum = 0;
        
        // IF the text passed in is null
        if (text == null)
        {
            // CONVERT it to blank text instead
            text = "";
        }

        // IF the print queue isn't empty
        if(printQueue.size() > 0)
        {
            // REMOVE the last item in the list and add the new text to it
            lastItemInQueue = this.printQueue.get(printQueue.size() - 1) 
                + text;
            this.printQueue.remove(printQueue.size() - 1);
        }
        else
        {
            lastItemInQueue = text;
        }

        // SPLIT the text into chunks
        textChunks = lastItemInQueue.split("\\[wait\\]");

        // ADD text chunks to an resizeable array so they can be added
        // to the print queue more easily
        ArrayList<String> chunks = new ArrayList<String>();
        // FOR each chunk of text
        for(currentChunkNum = 0; currentChunkNum < textChunks.length;
        currentChunkNum++)
        {
            // PUT it into the resizeable array
            chunks.add(textChunks[currentChunkNum]);
        }
        
        // ADD all the new chunks to the queue
        this.printQueue.addAll(chunks);
    }

   /**
    * Pops the next block of text to print off the print queue
    *
    * @return the block of text that should be printed next
    */
    private String popPrintQueue()
    {
        String poppedText;

        // POP the item off of the head of the list
        poppedText = this.printQueue.get(0);
        this.printQueue.remove(0);

        return poppedText;
    }
}
