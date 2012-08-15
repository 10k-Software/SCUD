/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scud.parser;

import java.io.FileNotFoundException;
import java.net.URL;
import junit.framework.TestCase;
import scud.data.EnvironmentLibrary;

/**
 *
 * @author Chris Gibson
 */
public class LevelParserTest extends TestCase
{

    private LevelParser parser;
    private String curDir;
    /**
     * Called before every test is run
     */
    public void setUp()
    {
        parser = new LevelParser();
        curDir = System.getProperty("user.dir");
    }

    /**
     * Called after every test is run
     */
    public void tearDown()
    {
    }

    /**
     * Test behavior of level parser when given invalid file locations.
     */
    public void testInvalidFile() throws Exception
    {
        System.out.println("testInvalidFileLoc");
        EnvironmentLibrary lib = null;
        
        try
        {
            lib = parser.generateWorld(new URL("file:test/data/not-a-file.xml"));
        }
        catch (Exception ex)
        {
            assertTrue("invalid file", ex instanceof FileNotFoundException);
        }
        assertNull("null return from generateWorld", lib);
    }
    
    /**
     * Test level parser's nominal behavior under normal conditions.
     */
    public void testValidFile() throws Exception
    {
        System.out.println("testValidFile");
        EnvironmentLibrary lib = null;
        
        try
        {
            lib = parser.generateWorld(new URL("file:test/data/validSimple.xml"));
        }
        catch (Exception ex)
        {
            assertTrue("exception thrown", false);
        }
        assertNotNull("not null output", lib);
    }

    /**
     * Test the output of the level parser in nominal conditions.
     */
    public void testValidOutput() throws Exception
    {
        System.out.println("testValidOutput");
        EnvironmentLibrary lib = null;
        
        try
        {
            lib = parser.generateWorld(new URL("file:test/data/validSimple.xml"));
        }
        catch (Exception ex)
        {
            assertTrue("exception thrown", false);
        }
        
        assertNotNull("get room", lib.getRoom(0));
        assertNotNull("get item", lib.getItem(0));
        assertNotNull("get action", lib.getAction(0));
        assertNotNull(lib.getCurrentRoom());
        assertEquals(lib.getCurrentRoom(), lib.getRoom(0));
    }
}