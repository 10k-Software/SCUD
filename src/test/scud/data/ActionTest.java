package scud.data;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author Andrew Chan
 */
public class ActionTest extends TestCase
{

    public ActionTest()
    {
        
    }

    /**
     * Test of addItemAdded method, of class Action.
     */
    public void testAddItemAdded() {
        System.out.println("addItemAdded");
        Action instance = new Action();
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        
        instance.addItemAdded(1);
        expResult.add(1);
        
        ArrayList<Integer> result = instance.getItemsAdded();
        
        assertEquals(expResult, result);
        instance.addItemAdded(2);
        expResult.add(2);
        
        result = instance.getItemsAdded();
        
        assertEquals(expResult, result);
        instance.addItemAdded(3);
        expResult.add(3);
        
        result = instance.getItemsAdded();
        
        assertEquals(expResult, result);
        instance.addItemAdded(1);
        expResult.add(1);
        
        result = instance.getItemsAdded();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addItemRemoved method, of class Action.
     */
    public void testAddItemRemoved() {
        System.out.println("addItemRemoved");
        Action instance = new Action();
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        
        instance.addItemRemoved(1);
        expResult.add(1);
        
        ArrayList<Integer> result = instance.getItemsRemoved();
        
        assertEquals(expResult, result);
        instance.addItemRemoved(2);
        expResult.add(2);
        
        result = instance.getItemsRemoved();
        
        assertEquals(expResult, result);
        instance.addItemRemoved(3);
        expResult.add(3);
        
        result = instance.getItemsRemoved();
        
        assertEquals(expResult, result);
        instance.addItemRemoved(1);
        expResult.add(1);
        
        result = instance.getItemsRemoved();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addItemRequired method, of class Action.
     */
    public void testAddItemRequired() {
        System.out.println("addItemRequired");
        Action instance = new Action();
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        
        instance.addItemRequired(1);
        expResult.add(1);
        
        ArrayList<Integer> result = instance.getItemsRequired();
        
        assertEquals(expResult, result);
        instance.addItemRequired(2);
        expResult.add(2);
        
        result = instance.getItemsRequired();
        
        assertEquals(expResult, result);
        instance.addItemRequired(3);
        expResult.add(3);
        
        result = instance.getItemsRequired();
        
        assertEquals(expResult, result);
        instance.addItemRequired(1);
        expResult.add(1);
        
        result = instance.getItemsRequired();
        
        assertEquals(expResult, result);
    }
}