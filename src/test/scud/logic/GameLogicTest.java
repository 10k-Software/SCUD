package scud.logic;

import junit.framework.TestCase;
import scud.app.ScudUI;
import java.util.ArrayList;
import scud.app.BlankUI;

/**
*
* @author Nick Artman
*/
public class GameLogicTest extends TestCase
{
    private GameLogic gameLogic;
    private ScudUI userInterface;

    public GameLogicTest()
    {

    }

    public void setUp()
    {
        gameLogic = new GameLogic("test/data/Simplelevel.xml");

        // TEST an invalid action, and ensure it prints a message and doesn't
        // throw an exception
        System.out.println("executeAction");
        String invalidActionText = "Execute an invalid action";

        userInterface = new BlankUI();
        boolean expResult = false;
        boolean result = false;

        /*
         * Set up test 1: test an invalid action
         */
        try
        {
            result = gameLogic.executeAction("failedAction", userInterface);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("Threw an error while displaying an invalid command message");
        }


        /*
         * Set up test 2: test an action that results in a room move
         */
        String actionText = "fall down";

        // ensure no errors are throne. the following tests depend on this
        // one succeeding to be valid.
        try
        {
            result = gameLogic.executeAction(actionText, userInterface);
        }
        catch (Exception e)
        {
            fail("Threw an error while executing a move as part of an action");
        }

        /*
         * Setup test 3: test an action that gives the player an item
         */
        actionText = "get cake";
        // now try to get the cake in the room, thus testing item aquiring
        try
        {
            result = gameLogic.executeAction(actionText, userInterface);
        }
        catch (Exception e)
        {
            fail("Threw an error while trying to get an item via an action");
        }
    }

    public void tearDown()
    {
    }



    /**
    * Test of getInventory, makes sure no errors are thrown for empty list of
    * items
    */
    public void testExecuteAction()
    {
        System.out.println("getInventory");
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = null;
        //the returned list should contain one item, called "Fake item"
        
        expResult.add("NULL ITEM NAME");
        expResult.add("NULL ITEM");

        /*
         * Test 1: test an action that results an item being used
         * AND a room move, then check that the item was taken away.
         */

        String actionText = "eat cake";
        try
        {
            gameLogic.executeAction(actionText, userInterface);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("threw an error while trying to use item");
        }


        try {
	        result = gameLogic.getInventory();
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("No exceptions should be thrown here");
        }


        assertEquals(expResult, result);
    }

    /*
    * Tests to make sure actions are properly executed and no errors are thrown.
    */
    public void testGetInventory()
    {

        ArrayList<String> inventory = null;
        ArrayList<String> expectedInventory = new ArrayList<String>();

        //we expect one item, the Cake
        expectedInventory.add("Cake");
        expectedInventory.add("NULL ITEM NAME");
        expectedInventory.add("NULL ITEM");

        try {
            inventory = gameLogic.getInventory();
        }
        catch (Exception e) {
            fail("threw an exception while getting the player's inventory");
        }


        assertEquals("Inventories were not equal",expectedInventory,inventory);
    }
    
    /**
    * Test of getActionNames, makes sure no errors are thrown for empty list of
    * actions
    */
    public void testGetActionNames()
    {
        System.out.println("getActionNames");
        ArrayList<String> result = null;

        /*
         * Test 1: have the user get the names of the actions
         * in the room and make sure that works.
         */
        try {
        	result = gameLogic.getActionNames();}
        catch (Exception e) {
            fail("No exceptions should be thrown getting the action list");
        }


        assertTrue(result.contains("eat cake") && result.contains("get cake") &&
                result.contains("NULL ACTION NAME\n") && 
                result.contains("NULL ACTION"));
    }}