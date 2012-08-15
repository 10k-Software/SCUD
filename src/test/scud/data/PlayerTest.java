/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scud.data;

import java.util.ArrayList;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Chan
 */
public class PlayerTest extends TestCase{

    public PlayerTest() {
    }

    public static void setUpClass() throws Exception {
    }

    public static void tearDownClass() throws Exception {
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    /**
     * Test of giveItem method, of class Player.
     */
    public void testGiveItem()
    {
        System.out.println("giveItem");
        Player instance = new Player();
        ArrayList<Integer> expectedInventory = new ArrayList<Integer>();
        
        instance.giveItem(1);
        expectedInventory.add(1);
        
        instance.giveItem(2);
        expectedInventory.add(2);
        
        instance.giveItem(1);
        expectedInventory.add(1);
        
        assertEquals(expectedInventory, instance.getInventory());
    }

    /**
     * Test of giveItems method, of class Player.
     */
    public void testGiveItems() {
        System.out.println("giveItems");
        Player instance = new Player();
        ArrayList<Integer> expectedInventory = new ArrayList<Integer>();
        
        expectedInventory.add(1);
        expectedInventory.add(2);
        expectedInventory.add(1);
        
        instance.giveItems(expectedInventory);
        
        assertEquals(expectedInventory, instance.getInventory());
        
        instance.giveItems(expectedInventory);
        expectedInventory.add(1);
        expectedInventory.add(2);
        expectedInventory.add(1);
        
        assertEquals(expectedInventory, instance.getInventory());
    }

    /**
     * Test of takeItems method, of class Player.
     */
    public void testTakeItems()
    {
        System.out.println("takeItems");
        Player instance = new Player();
        ArrayList<Integer> expectedInventory = new ArrayList<Integer>();
        ArrayList<Integer> removeItems = new ArrayList<Integer>();
        
        removeItems.add(1);
        removeItems.add(2);
        
        expectedInventory.add(1);
        instance.giveItem(1);
        
        instance.takeItems(removeItems);
        assertEquals(expectedInventory, instance.getInventory());
        
        instance.giveItem(2);
        instance.takeItems(removeItems);
        expectedInventory.clear();
        
        assertEquals(expectedInventory, instance.getInventory());
    }

    /**
     * Test of hasItems method, of class Player.
     */
    public void testHasItems() {
        System.out.println("hasItems");
        Player instance = new Player();
        ArrayList<Integer> itemList = new ArrayList<Integer>();
        ArrayList<Integer> testItems = new ArrayList<Integer>();
        
        itemList.add(1);
        itemList.add(2);
        
        instance.giveItems(itemList);
        
        assertTrue(instance.hasItems(itemList));
        
        itemList.add(3);
        
        assertFalse(instance.hasItems(itemList));
    }
}