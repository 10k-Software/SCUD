package scud.app;


/**
 * ScudUI represent the ideal user interface for the program Project SCUD.
 * Each implemented user interface should follow this interface in order
 * to properly function with the ScudApp and GameLogic classes. No matter how 
 * the user interface is implemented, once it is constructed and initialized 
 * with its initUI() function, it will handle the user-level gameplay from then 
 * on.
 * 
 * By using the ScudUI interface, the logic of the program becomes independent
 * of the user interface. The user-interface objects can be called the same way,
 * yet can handle the required task without an excess of code overhead.
 * 
 * @author Lisa Hunter, Jason Swalwell
 * @version 0.3
 * @.date 2008-10-12
 */
//Version History

public interface ScudUI 
{

    /**
     * Sets up the user interface and runs the Project SCUD
     * program. Once called, it takes control of the program and does not 
     * stop until the user quits. There is no specified way to quit the game;
     * for example, a console user interface could use a "quit" command, 
     * while a graphical user interface could use a quit button.
     */
    void initUI();
    
    /**
     * Displays the inputed text
     * 
     * @param text the desired text to send to the UI
     */
    void displayText(String text);
    
    
}
