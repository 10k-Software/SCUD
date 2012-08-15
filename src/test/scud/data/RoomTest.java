package scud.data;

import java.util.ArrayList;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Chan
 */
public class RoomTest extends TestCase{

    public RoomTest() {
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
     * Test of addAction method, of class Room.
     */
    public void testAddAction() {
        System.out.println("addAction");
        Room instance = new Room();
        
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        
        instance.addAction(1);
        expResult.add(1);
        
        ArrayList<Integer> result = instance.getActions();
        
        assertEquals(expResult, result);
        instance.addAction(2);
        expResult.add(2);
        
        result = instance.getActions();
        
        assertEquals(expResult, result);
        instance.addAction(3);
        expResult.add(3);
        
        result = instance.getActions();
        
        assertEquals(expResult, result);
        instance.addAction(1);
        expResult.add(1);
        
        result = instance.getActions();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addItem method, of class Room.
     */
    public void testAddItem() {
        System.out.println("addItem");
        Room instance = new Room();
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        
        instance.addItem(1);
        expResult.add(1);
        
        ArrayList<Integer> result = instance.getItems();
        
        assertEquals(expResult, result);
        instance.addItem(2);
        expResult.add(2);
        
        result = instance.getItems();
        
        assertEquals(expResult, result);
        instance.addItem(3);
        expResult.add(3);
        
        result = instance.getItems();
        
        assertEquals(expResult, result);
        instance.addItem(1);
        expResult.add(1);
        
        result = instance.getItems();
        
        assertEquals(expResult, result);
    }
}