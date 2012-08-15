package scud.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import scud.data.Action;
import scud.data.EnvironmentLibrary;
import scud.data.Item;
import scud.data.Room;

/**
 * The Level Parser is a helper class that handles the parsing of level 
 * xml files and oversees the generation of the EnvironmentLibrary instance.  
 * Given definitions of rooms, items, and actions, LevelParser
 * will fill the EnvironmentLibrary with the level's respective Room, Action 
 * and Item object instances.
 * 
 * @author Chris Gibson
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Chris Gibson added algorithm pseudocode
public class LevelParser
{

    /**
     * The environment library to be built
     */
    private EnvironmentLibrary library;  
    
    /**
     * The document being parsed
     */
    private Document xmlDoc;            
    
    /**
     * Initial room to begin in
     */
    private Integer kINITIALROOM = 0;   
    
    /**
     * Current document tag being handled
     */
    private Node currentNode;           
    
    /**
     * Index to node being parsed currently
     */
    private int currentNodeIndex = 0; 
    
    /**
     * Constructs a new LevelParser
     */
    public LevelParser()
    {

    }
    
    /**
     * Assumes a default xml file included within the jar to run and creates an  
     * Environment Library including rooms, items and actions included within
     * the file.
     * 
     * The method fails if the file is not a valid XML file, if the file does not
     * exist, or if the user does not have permissions to read from the level
     * file.
     * 
     * @param levelFile location of level xml file
     * @return the compiled EnvironmentLibrary instance
     * @throws FileNotFoundException, ParserConfigurationException, 
     *         SAXException, IOException
     */
    public EnvironmentLibrary generateWorld()
            throws FileNotFoundException, ParserConfigurationException, 
            SAXException, IOException
    {
        return null;
    }
    
    /**
     * Takes in an xml level file and generates the Room, Item and Action
     * equivalents.
     * 
     * The method fails if the file is not a valid XML file, if the file does not
     * exist, or if the user does not have permissions to read from the level
     * file.
     * 
     * @param levelFile location of level xml file
     * @return the compiled EnvironmentLibrary instance
     * @throws FileNotFoundException, ParserConfigurationException, 
     *         SAXException, IOException
     */
    public EnvironmentLibrary generateWorld(URL levelFile) 
            throws FileNotFoundException, ParserConfigurationException, 
            SAXException, IOException, URISyntaxException
    {   
        // INITIALIZE the library
        library = new EnvironmentLibrary();    

        // CREATE a document builder factory
        DocumentBuilderFactory factory = 
                DocumentBuilderFactory.newInstance();

        // Let the factory know we don't want to validate the xml file
        factory.setValidating(false);

        // PARSE the given XML document and place it within 
        // a Document object
        xmlDoc =  factory.newDocumentBuilder()
                .parse(levelFile.toURI().toString());

        // RESET current node index
        currentNodeIndex = 0;

        // GENERATE all rooms and add them to the library
        parseRooms();

        // GENERATE all actions and add them to the library
        parseActions();

        // GENERATE all items and add them to the library
        parseItems();        

        // SET the game to the starting room
        library.moveRoom(library.getRoom(kINITIALROOM));
        return library;
    }
    
    /**
     * Retrieves all 'room' tags within the root of the xml document and places
     * all defined game rooms into the environment library
     */
    private void parseRooms()
    {
        // FIND a list of room tags within the root
        NodeList roomList = xmlDoc.getElementsByTagName("room");

        // ITERATE through each tag within the room tags
        while((currentNode = roomList.item(currentNodeIndex)) != null)
        {
            Room room = new Room();
            // ACQUIRE the id of the room and create a new room
            Node idNode = currentNode.getAttributes().getNamedItem("id");
            room.setId(Integer.parseInt(idNode.getTextContent()));

            NodeList attributes = currentNode.getChildNodes();
            // FILL the room object with the given attribute value
            for(int attIndex = 0; attIndex < attributes.getLength(); attIndex++)
            {
                // ACQUIRE the current attribute name
                String name = attributes.item(attIndex).getNodeName();
                // ACQUIRE the current attribute text
                String text = attributes.item(attIndex).getTextContent();
                // IF the attribute tag is defining a description
                if(name.equals("description"))
                {
                    room.setDescription(text);
                }
                // IF the attribute defines an action to be done
                else if(name.equals("do_action"))
                {
                    room.addAction(Integer.parseInt(text));
                }
                // IF the attribute defines an item to be included in the room
                else if(name.equals("inc_item"))
                {
                    room.addItem(Integer.parseInt(text));
                }
            }
            // INSERT the room into the data manager
            library.addRoom(room.getId(), room);

            // INCREMENT to the next room node
            currentNodeIndex++;
        }
    }
    
    /**
     * Retrieves all 'action' tags within the root of the xml document and 
     * places all scripted game actions into the environment library.
     */
    private void parseActions()
    {
        // RESET current node index
        currentNodeIndex = 0;
        // FIND a list of action tags within the root
        NodeList actionList = xmlDoc.getElementsByTagName("action");

        // ITERATE through each tag within the action tags
        while((currentNode = actionList.item(currentNodeIndex)) != null)
        {
            Action action = new Action();

            // ACQUIRE the id of the room and create a new action instance
            Node idNode = currentNode.getAttributes().getNamedItem("id");
            action.setId(Integer.parseInt(idNode.getTextContent()));

            NodeList attributes = currentNode.getChildNodes();
            // FILL the action object with the given attribute value
            for(int attIndex = 0; attIndex < attributes.getLength(); attIndex++)
            {
                // ACQUIRE the current attribute name
                String name = attributes.item(attIndex).getNodeName();
                // ACQUIRE the current attribute text
                String text = attributes.item(attIndex).getTextContent();
                // IF the tag is describing the action
                if(name.equals("description"))
                {
                    action.setDescription(text);
                }
                // IF the tag is stating an included success action
                else if(name.equals("success"))
                {
                    action.setSuccessAction(Integer.parseInt(text));
                }
                // IF the tag describes a player movement
                else if(name.equals("move"))
                {
                    action.setMove(Integer.parseInt(text));
                }
                // IF the tag adds an item
                else if(name.equals("add_item"))
                {
                    action.addItemAdded(Integer.parseInt(text));
                }
                // IF the tag removes an item
                else if(name.equals("remove_item"))
                {
                    action.addItemRemoved(Integer.parseInt(text));
                }
                // IF the tag permits a required item
                else if(name.equals("require_item"))
                {
                    action.addItemRequired(Integer.parseInt(text));
                }
                // IF the tag states a failure action
                else if(name.equals("failure"))
                {
                    action.setFailureAction(Integer.parseInt(text));
                }
                // IF the tag states the name of the action
                else if(name.equals("name"))
                {
                    action.setName(text);
                }
            }
            // INSERT the action into the data manager
            library.addAction(action.getId(), action);

            // INCREMENT to the next action node
            currentNodeIndex++;
        }
    }
    
    /**
     * Retrieves all 'item' tags within the root of the xml document and places
     * all game items into the environment library
     */
    private void parseItems()
    {
        // RESET current node index
        currentNodeIndex = 0;
        // FIND a list of item tags within the root
        NodeList itemList = xmlDoc.getElementsByTagName("item");

        // ITERATE through each tag within the item tags
        while((currentNode = itemList.item(currentNodeIndex)) != null)
        {
            Item item = new Item();
            // ACQUIRE the id of the item and create a new room instance
            Node idNode = currentNode.getAttributes().getNamedItem("id");
            item.setId(Integer.parseInt(idNode.getTextContent()));

            NodeList attributes = currentNode.getChildNodes();
            // FILL the item object with the given attribute value
            for(int attIndex = 0; attIndex < attributes.getLength(); attIndex++)
            {
                // ACQUIRE the current attribute name
                String name = attributes.item(attIndex).getNodeName();
                // ACQUIRE the current attribute text
                String text = attributes.item(attIndex).getTextContent();
                // IF the tag is describing the item
                if(name.equals("description"))
                {
                    item.setDescription(text);
                }
                // IF the tag is stating the item's official name
                else if(name.equals("name"))
                {
                    item.setName(text);
                }
            }
            // INSERT the item into the data manager
            library.addItem(item.getId(), item);

            // INCREMENT to the next item node
            currentNodeIndex++;
        }
    }
}
