package scud.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The EnvironmentLibrary class represents a snapshot of the current game
 * environment. It contains all the information for the current state of the
 * player and current room, each of which are indexed into every Room, 
 * Item, and Action in the game. Rooms, Items, and Actions can be accessed 
 * from the library based on unique ID numbers.
 * 
 * @author Andrew Chan
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Andrew Chan added algorithm pseudocode

public class EnvironmentLibrary
{
    /**
     * Index of all the rooms, which are identified by unique IDs so rooms
     * can be used interchangeably.
     */
    private HashMap<Integer, Room> rooms;
    
    /**
     * Index of all the items, which are identified by unique IDs so items
     * can be used interchangeably.
     */
    private HashMap<Integer, Item> items;
    
    /**
     * Index of all the rooms, which are identified by unique IDs so rooms
     * can be used interchangeably.
     */
    private HashMap<Integer, Action> actions;
    
    /**
     * The current player that the user controls
     */
    private Player currentPlayer;
    
    /**
     * The current room the player occupies
     */
    private Room currentRoom;
    
    /**
     * Constructs a new EnvironmentLibrary.
     */
    public EnvironmentLibrary()
    {
        //INITIALIZE collections for rooms, items, and actions
        rooms = new HashMap<Integer, Room>();
        items = new HashMap<Integer, Item>();
        actions = new HashMap<Integer, Action>();
        currentRoom = null;
        currentPlayer = new Player();
    }
    
    /**
     * Adds a new Room to the library
     * 
     * @param id the Room index
     * @param room the Room object
     */
    public void addRoom(Integer id, Room room)
    {
        //ADD OR REPLACE specified room in room collection
        rooms.put(id, room);
    }
    
    /**
     * Adds a new Item to the library
     * 
     * @param id the Item index
     * @param item the Item object
     */
    public void addItem(Integer id, Item item)
    {
        //ADD OR REPLACE specified item in item collection
        items.put(id, item);
    }
    
    /**
     * Adds a new Action to the library
     * 
     * @param id the Action index
     * @param action the Action object
     */
    public void addAction(Integer id, Action action)
    {
        //ADD OR REPLACE specified action in action collection
        actions.put(id, action);
    }
    
    /**
     * Requests a current Room from the environment
     * 
     * @return the Room object
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Requests a Room from the library
     * 
     * @param id the Room index
     * @return the Room object
     */
    public Room getRoom(Integer id)
    {
        return rooms.get(id);
    }
    
    /**
     * Requests an Item from the library
     * 
     * @param id the Item index
     * @return the Item object
     */
    public Item getItem(Integer id)
    {
        return items.get(id);
    }
    
    /**
     * Requests an Action from the library
     * 
     * @param id the Action index
     * @return the Action object
     */
    public Action getAction(Integer id)
    {
        return actions.get(id);
    }
    
    /**
     * Moves the player to the specified room
     * 
     * @param nextRoom the room to move to
     */
    public void moveRoom(Room nextRoom)
    {
        //IF the specified room exists
        if (nextRoom != null)
        {
            //SET the current room to the specified room
            currentRoom = nextRoom;
        }
    }
    
    /**
     * Requests a list of Actions from the current room
     * 
     * @return a List of Actions
     */
    public ArrayList<Action> getActionList()
    {
        // A new list of actions
        ArrayList<Action> actionsList = new ArrayList<Action>();
        // RETRIVE the list of actions for the current room
        ArrayList<Integer> actionIds = currentRoom.getActions();
        
        //FOR EACH action index in the current room
        for(Integer id : actionIds)
        {
            //ADD the action object to a collection
            actionsList.add(getAction(id));
        }
        return actionsList;
    }
    
    /**
     * Requests the current Player
     * 
     * @return the current Player
     */
    public Player getPlayer()
    {
        return currentPlayer;
    }
}
