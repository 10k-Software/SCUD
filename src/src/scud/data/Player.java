package scud.data;

import java.util.ArrayList;

/**
 * The Player class represents a single player with an inventory list of Items. 
 * In this implementation, there is only one player within a SCUD.  The player 
 * class separates the inventory from the EnvironmentManager class, and allows 
 * for player-specific methods (such as giving or taking many items)
 * 
 * @author Andrew Chan
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Andrew Chan added algorithm pseudocode

public class Player 
{
    
    /**
     * A list of items in the player's inventory
     * The inventory is a list of non-unique integers indexing to Items
     *  to allow for multiple duplicates of the same Item
     */
    private ArrayList<Integer> inventory;
    
    /**
     * Constructs a new Player
     */
    public Player()
    {
        //INITIALIZE player inventory
        inventory = new ArrayList<Integer>();
    }

    /**
     * Gives a single Item to the Player
     * 
     * @param item the Item index
     */
    public void giveItem(Integer item)
    {
        //ADD specified item into the inventory
        inventory.add(item);
    }

    /**
     * Gives multiple Items to the Player
     * 
     * @param itemList a List of Items
     */
    public void giveItems(ArrayList<Integer> itemList)
    {
        //ADD collection of items into the inventory
        inventory.addAll(itemList);
    }

    /**
     * Takes Items from the Player. It will fail if the Player 
     * does not have all of the items.
     * 
     * @param itemList a List of Items
     * @return success if the items were all taken
     */
    public boolean takeItems(ArrayList<Integer> itemList)
    {
        //INTIALIZE flag true if inventory contains all items in the itemList
        boolean hasAllItems = true;
        
        //FOR EACH item in the given itemList
        for (Integer item : itemList)
        {
            //IF the inventory does not contain the item
            if(!inventory.contains(item))
            {
                //TOGGLE flag, inventory does not contain all items
                hasAllItems = false;
            }
        }
        
        //IF the inventory contains all items
        if(hasAllItems)
        {
            //FOR EACH item in the item list
            for (Integer item : itemList)
            {
                //SUBTRACT item from the inventory
                inventory.remove(item);             
            }
        }
        return hasAllItems;
    }
    
    /**
     * Queries if the Player's inventory contains a single Item
     * 
     * @param item the Item index
     * @return success if Player has the item
     */
    public boolean hasItem(Integer item)
    {
        return inventory.contains(item);
    }
    
    /**
     * Queries if the Player's inventory contains Items
     * 
     * @param itemList a List of Items
     * @return success if the Player contains all the items
     */
    public boolean hasItems(ArrayList<Integer> itemList)
    {
        //INTIALIZE flag true if inventory contains all items in the itemList
        boolean hasAllItems = true;
        
        //FOR EACH item in the itemList
        for(Integer item: itemList)
        {
            //IF the inventory does not contain specified item
            if(!inventory.contains(item))
            {
                //TOGGLE flag, inventory does not contain all items
                hasAllItems = false;
            }
        }
        return hasAllItems;
    }

    /**
     * Requests the entire Player's inventory
     * 
     * @return a List of Items from the Player's inventory
     */
    public ArrayList<Integer> getInventory()
    {
        return inventory;
    }
}
