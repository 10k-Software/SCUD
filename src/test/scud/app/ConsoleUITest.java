package scud.app;

import scud.logic.GameLogic;

/**
 * ConsoleUITest tests part of the ConsoleUI functionality.
 * What is not tested within ConsoleUITest is tested via
 * input and output files handled within the integration
 * build script.
 * 
 * @author Lisa Hunter
 */
public class ConsoleUITest 
{

    private ConsoleUI console; 
    public ConsoleUITest() 
    {
        
    }

    public void setUp() 
    {
        console = new ConsoleUI(new GameLogic("Testlevel.xml"));
    }


    /**
     * Test of initUI method, of class ConsoleUI.
     */
    public void testInitUI() 
    {
        System.out.println("initUI");

        console.initUI();

    }

    /**
     * Test of displayText method, of class ConsoleUI.
     */
    public void testDisplayText() 
    {
        System.out.println("displayText");
        console.displayText("Here is some text for testDisplay");

    }

}
