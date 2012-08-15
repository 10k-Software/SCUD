package scud.data;

import java.util.ArrayList;
import junit.framework.TestCase;


/**
 *
 * @author Andrew Chan
 */
public class EnvironmentLibraryTest extends TestCase
{

    public EnvironmentLibraryTest()
    {
    }
    public static void setUpClass() throws Exception
    {
    }

    public static void tearDownClass() throws Exception
    {
    }

    public void setUp()
    {
    }

    public void tearDown()
    {
    }

    /**
     * Test of addRoom method, of class EnvironmentLibrary.
     */
    public void testAddRoom()
    {
        System.out.println("addRoom");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Room addedRoom = new Room();
        addedRoom.setId(1);
        
        instance.addRoom(1, addedRoom);
        
        Room requestRoom = instance.getRoom(1);
        
        assertEquals(requestRoom, addedRoom);
        
        addedRoom = new Room();
        addedRoom.setId(2);
        
        instance.addRoom(2, addedRoom);
        
        requestRoom = instance.getRoom(2);
        
        assertEquals(requestRoom, addedRoom);
        
        addedRoom = new Room();
        addedRoom.setId(3);
        
        instance.addRoom(1, addedRoom);
        
        requestRoom = instance.getRoom(1);
        
        assertEquals(requestRoom, addedRoom);
    }

    /**
     * Test of addItem method, of class EnvironmentLibrary.
     */
    public void testAddItem()
    {
        System.out.println("addItem");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Item addedItem = new Item();
        addedItem.setId(1);
        
        instance.addItem(1, addedItem);
        
        Item requestItem = instance.getItem(1);
        
        assertEquals(requestItem, addedItem);
        
        addedItem = new Item();
        addedItem.setId(2);
        
        instance.addItem(2, addedItem);
        
        requestItem = instance.getItem(2);
        
        assertEquals(requestItem, addedItem);
        
        addedItem = new Item();
        addedItem.setId(3);
        
        instance.addItem(1, addedItem);
        
        requestItem = instance.getItem(1);
        
        assertEquals(requestItem, addedItem);
    }

    /**
     * Test of addAction method, of class EnvironmentLibrary.
     */
    public void testAddAction()
    {
        System.out.println("addAction");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Action addedAction = new Action();
        addedAction.setId(1);
        
        instance.addAction(1, addedAction);
        
        Action requestAction = instance.getAction(1);
        
        assertEquals(requestAction, addedAction);
        
        addedAction = new Action();
        addedAction.setId(2);
        
        instance.addAction(2, addedAction);
        
        requestAction = instance.getAction(2);
        
        assertEquals(requestAction, addedAction);
        
        addedAction = new Action();
        addedAction.setId(3);
        
        instance.addAction(1, addedAction);
        
        requestAction = instance.getAction(1);
        
        assertEquals(requestAction, addedAction);
    }
    
    /**
     * Test of moveRoom method, of class EnvironmentLibrary.
     */
    public void testMoveRoom()
    {
        System.out.println("moveRoom");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        /* Has not been set yet.  No default */
        assertNull(instance.getCurrentRoom());
        
        Room nextRoom = new Room();
        nextRoom.setId(1);
        instance.moveRoom(nextRoom);
        Room currentRoom = instance.getCurrentRoom();
        assertEquals(currentRoom, nextRoom);
        
        instance.moveRoom(null);
        currentRoom = instance.getCurrentRoom();
        assertEquals(currentRoom, nextRoom);
    }
    
    /**
     * Test of player class.
     */
    public void testPlayer()
    {
        System.out.println("testPlayer");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Player player = instance.getPlayer();
        assertNotNull("Player instance", player);
        
        ArrayList<Integer> inventory = player.getInventory();
        assertNotNull("Inventory instance", inventory);
        assertEquals("Inventory Size", 0, inventory.size());
    }
    
    /**
     * Test of empty action list for given room.
     */
    public void testEmptyActionList()
    {
        System.out.println("testEmptyActionList");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Room room = new Room();
        room.setId(1);
        instance.addRoom(1, room);
        instance.moveRoom(room);
        assertNotNull(instance.getActionList());
    }
    
    /**
     * Test of action list for given room.
     */
    public void testNonEmptyActionList()
    {
        System.out.println("testNonEmptyActionList");
        EnvironmentLibrary instance = new EnvironmentLibrary();
        
        Action action = new Action();
        action.setId(1);
        action.setName("name");
        action.setDescription("Some description");
        instance.addAction(1, action);
        
        Room room = new Room();
        room.setId(1);
        room.addAction(1);
        instance.addRoom(1, room);
        instance.moveRoom(room);
        assertEquals(1, instance.getActionList().size());
    }
}