/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scud.data;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andrew Chan
 */
public class EnvironmentLibrary {
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
        
        Action newAction = new Action();
        newAction.setId(1);
        newAction.setName("fall down");
        newAction.setDescription("You fall down.");
        newAction.setMove(2);
        this.addAction(1, newAction);
        
        newAction = new Action();
        newAction.setId(2);
        newAction.setName("get cake");
        newAction.setDescription("You pick up the cake.");
        newAction.addItemAdded(1);
        this.addAction(2, newAction);
        
        newAction = new Action();
        newAction.setId(3);
        newAction.setName("eat cake");
        newAction.setDescription("You eat the cake.");
        newAction.addItemRequired(1);
        newAction.addItemRemoved(1);
        newAction.setSuccessAction(4);
        this.addAction(3, newAction);
        
        newAction = new Action();
        newAction.setId(4);
        newAction.setName("death");
        newAction.setDescription("You die.");
        newAction.setMove(3);
        this.addAction(4, newAction);
        
        Item newItem = new Item();
        newItem.setId(1);
        newItem.setName("Cake");
        newItem.setDescription("Delicious cake.  You must eat it.");
        this.addItem(1, newItem);
        
        Room newRoom = new Room();
        newRoom.setId(1);
        newRoom.setDescription("You see nothing");
        newRoom.addAction(1);
        this.addRoom(1, newRoom);
        currentRoom = newRoom;
        
        newRoom = new Room();
        newRoom.setId(2);
        newRoom.setDescription("A large pit. There's no way out.");
        newRoom.addAction(2);
        newRoom.addAction(3);
        newRoom.addItem(1);
        this.addRoom(2, newRoom);
        
        newRoom = new Room();
        newRoom.setId(3);
        newRoom.setDescription("You are dead");
        this.addRoom(3, newRoom);
        
        
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
