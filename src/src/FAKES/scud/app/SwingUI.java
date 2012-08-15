package scud.app;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.ArrayList;

import scud.app.ScudUI;
import scud.logic.GameLogic;

/**
 * The SwingUI class is a graphical user interface for ProjectSCUD.
 * It displays text to the user via a text box and allows user interaction
 * via movement buttons, an item drop down bar, a place to enter text, and
 * a help button.
 * 
 * @author Jason Swalwell
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Jason Swalwell added algorithm pseudocode
public class SwingUI extends JFrame implements ScudUI
{

    /**
     * The serial ID
     */
   private static final long serialVersionUID = 1L;

   /**
    * The desired frame height
    */
   private static final int kFHeight = 610;
   
   /**
    * The desired frame width
    */
   private static final int kFWidth = 565;
   
   /**
    * The desired font size
    */
   private static final int kFontSize = 12;
   
   /**
    * The desired number of rows for a grid layout in a panel
    */
   private static final int kRows = 3;
   
   /**
    * The desired number of columns for a grid layout in a panel
    */
   private static final int kCols = 3;
   
   /**
    * The RGB color object for MyBlue
    */
   private static final Color kMyBlue = new Color(22, 22, 112);
   
   /**
    * The RGB color object for MyRed
    */
   private static final Color kMyRed = new Color(100, 0, 0);
   
   /**
    * The RGB color object for blueBorder
    */
   private static final Color kBlueBorder = new Color(176, 196, 222);
   
   /**
    * The RGB color object for MyRed
    */
   private static final Color kRedBorder = new Color(205, 92, 92);
   
   /**
   * The desired number of pixels deep the border surrounds the button
   */
   private static final int kBorderThickness = 2;
   
   /**
   * The desired number of columns for the TextField
   */
   private static final int kTextFieldLength = 15;
   
   /**
    * The text box that displays the game descriptions
    */
   private JTextPane textBox;
   
   /**
    * The text that accepts user input
    */
   private JTextField enterTextBox;
   
   /**
    * List of items that the player currently has
    */
   private JComboBox itemChoices;
   
   /**
    * Button that allows the player to attempt to travel north
    */
   private JButton northButton;
   
   /**
    * Button that allows the player to attempt to travel south
    */
   private JButton southButton;
   
   /**
    * Button that allows the player to attempt to travel west
    */
   private JButton westButton;
   
   /**
    * Button that allows the player to attempt to travel east
    */
   private JButton eastButton;
   
   /**
    * Button that allows the player to attempt to use an item
    */
   private JButton useItemButton;
   
   /**
    * Button that sends the player input to the game logic to be handled
    */
   private JButton enterButton;
   
   /**
    * Button that continues the game when pressed by the user
    */
   private JButton continueButton;
   
   /**
    * Button that provides an in-game help pop-up
    */
   private JButton helpButton;
   
   /**
    * Button that starts the game
    */
   private JButton startButton;
   
   /**
    * Panel containing the move east button
    */
   private JPanel eastPanel;
   
   /**
    * Panel containing the move west button
    */
   private JPanel westPanel;
   
   /**
    * Panel containing the move north button
    */
   private JPanel northPanel;
   
   /**
    * Panel containing the move south button
    */
   private JPanel southPanel;
   
   /**
    * Panel containing the use item button, enter text field and help button
    */
   private JPanel panBottom;
   
   /**
    * 10kSoft's team logo
    */
   private ImageIcon teamLogo;
   
   /**
    * Handles the functionality of the game
    */
   private GameLogic gameLogic;
   
   /**
    * Constructs a new frame to hold user interface components with the 
    * specified game logic and instantiates the frame components.
    * 
    * @param gameLogic the logic that will handle the game data
    */
   public SwingUI(GameLogic gameLogic)
   {
      
   }

   /**
    * Sets up the SwingUI and runs ProjectSCUD
    */
   public void initUI() 
   {
      
   }

   /**
    * Displays the text to player via the text box
    * 
    * @param text text to be displayed to user
    */
   public void displayText(String text) 
   {
      
   }
   
    /**
     * Initializes the layout of the frame by adding all components
     */
   private void initializeLayout()
   {
      
   }
   
   /**
    * Adds color to SwingUI
    */
   private void addColor()
   {

     
   }

   /**
    * Adds a mouse listener for each button
    */
   private void addMouseListener()
   {
      
    

     
   }
   
   /**
    * Adds action listener to player input text box to listen if the
    * player presses enter
    */
   private void addActionListener()
   {
      
   }
   

   /**
    * Calls executeAction with the text entered by the player if any,
    * else does nothing
    */
   private void enterAction()
   {
      
   }
   
   /**
    * Displays the help message to the user
    */
   private void displayHelp()
   {
       
   }
   
   /**
    * Hides all buttons except the continue button
    */
   private void hideButtons()
   {
      
   }
   
   /**
    * Makes all buttons visible except the continue button
    */
   private void showButtons()
   {
      
   }
   
   /**
    * Calls the gameLogic to execute the action given
    * 
    * @param action action to be executed
    */
   private void executeAction(String action) 
   {  
      
   }
   
   /**
    * Updates the item drop down bar with latest inventory
    */
   private void updateInventory()
   {
     
   }
}
