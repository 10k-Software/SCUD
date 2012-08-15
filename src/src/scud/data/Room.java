package scud.data;

import java.util.ArrayList;

/**
 * The Room class represents a special location or state that the player can be 
 * in during the game's main loop.  Rooms are technically abstractions of rooms 
 * in a building, but can also be used to represent a situation in which 
 * specific options or actions are available to the user; it does not need to 
 * be an actual room or dungeon.
 * 
 * The class handles all included actions, which represent all paths that a 
 * player may choose.
 * 
 * @author Andrew Chan
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Andrew Chan added algorithm pseudocode

public class Room 
{
    /**
     * Unique index that identifies each discrete Room
     */
    private Integer roomId;
    
    /**
     * Room description output that describes what is seen in the Room
     */
    private String description;
    
    /**
     * Actions that can be taken within the Room
     * The Room actions is a list of nonunique integers indexing to Actions
     *  to allow for multiple duplicates of the same Action
     */
    private ArrayList<Integer> actions;
    
    /**
     * Items contained within the Room
     * The Room items is a list of nonunique integers indexing to Items
     *  to allow for multiple duplicates of the same Item
     */
    private ArrayList<Integer> items;

    /**
     * Constructs a new Room
     */
    public Room() 
    {
        //INITIALIZE collections for actions and items within the room
        actions = new ArrayList<Integer>();
        items = new ArrayList<Integer>();
    }

    /**
     * Saves the unique index of the Room
     * 
     * @param id the Room index
     */
    public void setId(Integer id) 
    {
        roomId = id;
    }

    /**
     * Requests the unique index of the Room
     * 
     * @return the Room index
     */
    public Integer getId() 
    {
        return roomId;
    }

    /**
     * Saves the description of the Room
     * 
     * @param desc the Room description
     */
    public void setDescription(String desc) 
    {
        description = desc;
    }

    /**
     * Requests the description of the Room
     * 
     * @return the Room description
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * Adds an Action that can be taken within the Room
     * 
     * @param id the Action index
     */
    public void addAction(Integer id) 
    {
        //ADD specified action into collection of actions
        actions.add(id);
    }
    
    /**
     * Requests a list of all Actions that can be taken
     * 
     * @return a List of indexes of Actions
     */
    public ArrayList<Integer> getActions() 
    {
        return actions;
    }

    /**
     * Adds an Item into the Room
     * 
     * @param id the Item index
     */
    public void addItem(Integer id) 
    {
        //ADD specified item into collection of items
        items.add(id);
    }

    /**
     * Requests a list of all Items in the Room
     * 
     * @return a List of indexes of Items
     */
    public ArrayList<Integer> getItems() 
    {
        return items;
    }
}
