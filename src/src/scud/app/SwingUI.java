package scud.app;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.net.URL;

import java.util.ArrayList;
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
   private static final int kFHeight = 600;
   
   /**
    * The desired frame width
    */
   private static final int kFWidth = 650;
   
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
    * Button that causes the room's description to be displayed
    */
   private JButton lookButton;
   
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
      super("Project SCUD");
      this.gameLogic = gameLogic;

      URL imageURL = getClass().getResource("/scud/resources/10ksoft.png");
      // IF could not find image in jar
      if (imageURL == null)
      {
          teamLogo = new ImageIcon("10ksoft.png");
      }
      // ELSE image file found in jar
      else
      {
          teamLogo = new ImageIcon(imageURL);
      }

      textBox = new JTextPane();
      enterTextBox = new JTextField(kTextFieldLength);
      itemChoices = new JComboBox();
      
      northButton = new JButton("NORTH");
      southButton = new JButton("SOUTH");
      eastButton = new JButton("EAST");
      westButton = new JButton("WEST");
      useItemButton = new JButton("Use Item");
      enterButton = new JButton("Enter");
      continueButton = new JButton("Continue");
      helpButton = new JButton("Help");
      startButton = new JButton("Start Game");
      lookButton = new JButton("Look");
      
      eastPanel = new JPanel(new GridLayout(kRows, 0));
      westPanel = new JPanel(new GridLayout(kRows, 0));
      northPanel = new JPanel(new GridLayout(0, kCols));
      southPanel = new JPanel(new GridLayout(0, kCols));
      panBottom = new JPanel();
   }

   /**
    * Sets up the SwingUI and runs ProjectSCUD
    */
   public void initUI() 
   {
      // INITIALIZE the frame's layout
      initializeLayout();
      // ADD color to the frame
      addColor();
      // ADD the mouse listener
      addMouseListener();
      // ADD the action listener
      addActionListener();
      // SET size of frame
      setSize(kFWidth, kFHeight);
      // SET default operation to take when frame is closed
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      // BLOCK the user from editing the text box
      textBox.setEditable(false);
      // SET the font for the text box
      textBox.setFont(new Font("Courier", Font.PLAIN, kFontSize));
      
      itemChoices.addItem("No Item");
      
      // HIDE all buttons
      continueButton.setVisible(false);
      hideButtons();
      
      // Display title to player
      displayText(ScudApp.getTitle());
      setVisible(true);
   }

   /**
    * Displays the text to player via the text box
    * 
    * @param text text to be displayed to user
    */
   public void displayText(String text) 
   {
      // UPDATE the text box with the new description
      textBox.setText(text);
   }
   
    /**
     * Initializes the layout of the frame by adding all components
     */
   private void initializeLayout()
   {
      JPanel panCenter = new JPanel(new BorderLayout());
      
      // ADD the panels to the frame
      add(northPanel, BorderLayout.NORTH);
      add(panBottom, BorderLayout.SOUTH);
      add(eastPanel, BorderLayout.EAST);
      add(westPanel, BorderLayout.WEST);
      add(panCenter, BorderLayout.CENTER);
      panCenter.add(southPanel, BorderLayout.SOUTH);
      
      // ADD the buttons to their current position in the panel
      JPanel gridSpaceTakerUpper1 = new JPanel();
      JPanel gridSpaceTakerUpper2 = new JPanel();
      JPanel gridSpaceTakerUpper3 = new JPanel();
      JPanel gridSpaceTakerUpper4 = new JPanel();
      gridSpaceTakerUpper1.setBackground(Color.black);
      gridSpaceTakerUpper2.setBackground(Color.black);
      gridSpaceTakerUpper3.setBackground(Color.black);
      gridSpaceTakerUpper4.setBackground(Color.black);
      eastPanel.add(gridSpaceTakerUpper1);
      eastPanel.add(eastButton);
      westPanel.add(gridSpaceTakerUpper2);
      westPanel.add(westButton);
      northPanel.add(gridSpaceTakerUpper3);
      northPanel.add(northButton);
      southPanel.add(gridSpaceTakerUpper4);
      southPanel.add(southButton);
      
      // ADD the text boxes and the buttons
      panCenter.add(textBox, BorderLayout.CENTER);
      panBottom.add(itemChoices);
      panBottom.add(useItemButton);
      panBottom.add(lookButton);
      panBottom.add(enterTextBox);
      panBottom.add(enterButton);
      panBottom.add(helpButton);
      panBottom.add(continueButton);
      panBottom.add(startButton);
   }
   
   /**
    * Adds color to SwingUI
    */
   private void addColor()
   {

      // CREATE the borders for the buttons
      Border blueBorder = BorderFactory.createMatteBorder(kBorderThickness, 
           kBorderThickness, kBorderThickness, kBorderThickness, kBlueBorder);
      Border redBorder = BorderFactory.createMatteBorder(kBorderThickness, 
            kBorderThickness, kBorderThickness, kBorderThickness, kRedBorder);

      // SET the background color
      northPanel.setBackground(Color.black);
      southPanel.setBackground(Color.black);
      westPanel.setBackground(Color.black);
      eastPanel.setBackground(Color.black);
      panBottom.setBackground(Color.black);

      // SET the color of the buttons
      northButton.setBackground(kMyBlue);
      northButton.setForeground(Color.white);
      northButton.setBorder(blueBorder);
      southButton.setBackground(kMyBlue);
      southButton.setForeground(Color.white);
      southButton.setBorder(blueBorder);
      westButton.setBackground(kMyRed);
      westButton.setForeground(Color.white);
      westButton.setBorder(redBorder);
      eastButton.setBackground(kMyRed);
      eastButton.setForeground(Color.white);
      eastButton.setBorder(redBorder);
   }

   /**
    * Adds a mouse listener for each button
    */
   private void addMouseListener()
   {
      MouseAdapter mouseAdapter = new MouseAdapter()
      {
         public void mouseClicked(MouseEvent me)
         {
            JButton pressed = (JButton) me.getComponent();
            String buttonName = pressed.getText().toLowerCase().trim();
            // IF the player clicks the use item button
            if (buttonName.equals("use item"))
            {
               // GET the current selected item in the drop down bar
               String currentItem = (String) itemChoices.getSelectedItem();
               // IF the selected item is not "No Item"
               if (!currentItem.equals("No Item"))
               {
                  // EXECUTE the "use item" command
                  executeAction("use " + currentItem.toLowerCase());
               }
            }
            // ELSE IF the player clicks the enter button
            else if (buttonName.equals("enter"))
            {
               enterAction();
            }
            // ELSE IF the player clicks the help button
            else if (buttonName.equals("help"))
            {
               displayHelp();
            }
            // ELSE IF the player clicks the click to continue button
            else if (buttonName.equals("continue"))
            {
               executeAction("");
            }
            // ELSE IF the player clicks the start game or look around button
            else if (buttonName.equals("start game")  
                        || buttonName.equals("look"))
            {
               // SEND the action look to the gameLogic
               executeAction("look");
               // HIDE the start button
               startButton.setVisible(false);
            }
            // ELSE the player clicked a movement button
            else
            {
               executeAction("move " + buttonName);
            }
         }
      };

      // ADD the mouse listener to the buttons
      northButton.addMouseListener(mouseAdapter);
      southButton.addMouseListener(mouseAdapter);
      eastButton.addMouseListener(mouseAdapter);
      westButton.addMouseListener(mouseAdapter);
      useItemButton.addMouseListener(mouseAdapter);
      enterButton.addMouseListener(mouseAdapter);
      helpButton.addMouseListener(mouseAdapter);
      continueButton.addMouseListener(mouseAdapter);
      startButton.addMouseListener(mouseAdapter);
      lookButton.addMouseListener(mouseAdapter);
   }
   
   /**
    * Adds action listener to player input text box to listen if the
    * player presses enter
    */
   private void addActionListener()
   {
      enterTextBox.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent event)
         {
            enterAction();
         }
      });
   }
   

   /**
    * Calls executeAction with the text entered by the player if any,
    * else does nothing
    */
   private void enterAction()
   {
       String enteredText = enterTextBox.getText();
       // IF the player has entered some text, not an empty string
       if (!enteredText.equals(""))
       {
          // SEND the current user input to the gameLogic
          executeAction(enteredText);
          // CLEAR the user entered text box
          enterTextBox.setText("");
       }
   }
   
   /**
    * Displays the help message to the user
    */
   private void displayHelp()
   {
       String helpMessage = "Try one of the following actions\n\n";
       ArrayList<String> validActions = gameLogic.getActionNames();
       // FOR each valid action in the list
       for (String action: validActions)
       {
          // ADD each action to the help message
          helpMessage += action + "\n";
       }
       JOptionPane.showMessageDialog(this, helpMessage, 
                   "Help", JOptionPane.INFORMATION_MESSAGE, teamLogo);
   }
   
   /**
    * Hides all buttons except the continue button
    */
   private void hideButtons()
   {
      northButton.setVisible(false);
      southButton.setVisible(false);
      eastButton.setVisible(false);
      westButton.setVisible(false);
      useItemButton.setVisible(false);
      enterButton.setVisible(false);
      enterTextBox.setVisible(false);
      itemChoices.setVisible(false);
      helpButton.setVisible(false);
      lookButton.setVisible(false);
   }
   
   /**
    * Makes all buttons visible except the continue button
    */
   private void showButtons()
   {
      northButton.setVisible(true);
      southButton.setVisible(true);
      eastButton.setVisible(true);
      westButton.setVisible(true);
      useItemButton.setVisible(true);
      enterButton.setVisible(true);
      enterTextBox.setVisible(true);
      itemChoices.setVisible(true);
      helpButton.setVisible(true);
      lookButton.setVisible(true);
   }
   
   /**
    * Calls the gameLogic to execute the action given
    * 
    * @param action action to be executed
    */
   private void executeAction(String action) 
   {  
      // IF there is more text to print (executeAction returns boolean if true)
      if (gameLogic.executeAction(action, this))
      {
         // HIDE all buttons except the continue button
         hideButtons();
         continueButton.setVisible(true);
      }
      // ELSE there is no more text to print
      else
      {
         // SHOW all of the buttons except the continue button
         continueButton.setVisible(false);
         showButtons();
      }
      // UPDATE the inventory
      updateInventory();
   }
   
   /**
    * Updates the item drop down bar with latest inventory
    */
   private void updateInventory()
   {
      ArrayList<String> inventory = gameLogic.getInventory();
      
      itemChoices.removeAllItems();
      itemChoices.addItem("No Item");
      // FOR each item in the inventory
      for (String anItem: inventory)
      {
         // ADD the item to drop down bar
         itemChoices.addItem(anItem);
      }
   }
}
