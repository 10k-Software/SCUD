package scud.data;

import java.util.ArrayList;

/**
 * The Action class represents all move- and item-based actions in the game.
 * All 'scripted' action/reaction scenarios are abstracted by allowing for
 * situational actions to be executed based on required items and the room that
 * the player is currently in.
 *
 * Actions are called by the player by its name, and are nested in room objects
 * so that an action can exist in many rooms, and that the rooms themselves
 * are not limited to a specific numbers of actions (e.q. not just north, south,
 * east or west like some typical dungeon applications).
 *
 * @author Andrew Chan
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History
//  10/16/2008 Andrew Chan added algorithm pseudocode

public class Action
{

    /**
     * Unique index that identifies each discrete action
     */
    private Integer actionId;

    /**
     * Name of the Action
     */
    private String name;

    /**
     * Description of the action
     */
    private String description;

    /**
     * Index of the next room if the action is taken
     */
    private Integer nextRoom;

    /**
     * Index of the next action if the current action resulted in a success
     */
    private Integer successAction;

    /**
     * Index of the next action if the current action resulted in a failure
     */
    private Integer failureAction;

    /**
     * List of items to be given when the action resulted in a success
     * The Items to be added is a list of nonunique indexes to Items
     *  to allow for multiple duplicates of the same Item
     */
    private ArrayList<Integer> itemsAdded;

    /**
     * List of items to be taken when the action resulted in a success
     * The Items to be removed is a list of non-unique indexes to Items
     *  to allow for multiple duplicates of the same Item
     */
    private ArrayList<Integer> itemsRemoved;

    /**
     * List of items required for the action to succeed
     * The Items required is a list of non-unique indexes to Items
     *  to allow for multiple duplicates of the same Item
     */
    private ArrayList<Integer> itemsRequired;

    /**
     * Constructs a new action
     */
    public Action()
    {
        //INITIALIZE collections for items added
        itemsAdded = new ArrayList<Integer>();
        //INITIALIZE collections for items removed
        itemsRemoved = new ArrayList<Integer>();
        //INITIALIZE collections for items required
        itemsRequired = new ArrayList<Integer>();
        
    }

    /**
     * Saves the index of the Action
     *
     * @param id the Action index
     */
    public void setId(Integer id)
    {
        actionId = id;
    }

    /**
     * Requests the index of the Action
     *
     * @return the Action index
     */
    public Integer getId()
    {
        return actionId;
    }

    /**
     * Saves the name to the Action
     *
     * @param actionName the name of the Action
     */
    public void setName(String actionName)
    {
        name = actionName;
    }

    /**
     * Requests the name of the Action
     *
     * @return the Action name
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     * Saves the description of the Action
     *
     * @param desc the description of the Action
     */
    public void setDescription(String desc)
    {
        description = desc;
    }

    /**
     * Requests the description of the Action
     *
     * @return the Action description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Saves the next Room to move to
     *
     * @param id the index of the next Room
     */
    public void setMove(Integer id)
    {
        nextRoom = id;
    }

    /**
     * Requests the next Room to move to
     *
     * @return the index of the next Room
     */
    public Integer getMove()
    {
        return nextRoom;
    }

    /**
     * Saves the next Action taken upon success
     *
     * @param id the index of the next Action after success
     */
    public void setSuccessAction(Integer id)
    {
        successAction = id;
    }

    /**
     * Requests the next Action taken upon success
     *
     * @return the index of the next Action
     */
    public Integer getSuccessAction()
    {
        return successAction;
    }

    /**
     * Saves the next Action taken upon failure
     *
     * @param id the index of the next Action after failure
     */
    public void setFailureAction(Integer id)
    {
        failureAction = id;
    }

    /**
     * Requests the next Action taken upon failure
     *
     * @return the index of the next Action after failure
     */
    public Integer getFailureAction()
    {
        return failureAction;
    }

    /**
     * Adds an Item to the list of Items to be added upon success
     *
     * @param id the index of the Item to be added
     */
    public void addItemAdded(Integer id)
    {
        //ADD specified item to itemsAdded collection
        itemsAdded.add(id);
    }

    /**
     * Requests the list of Items to be added upon success
     *
     * @return the list of indexes to the Items to be added
     */
    public ArrayList<Integer> getItemsAdded()
    {
        return itemsAdded;
    }

    /**
     * Adds an Item to the list of Items to be removed upon success
     *
     * @param id the index of the Item to be removed
     */
    public void addItemRemoved(Integer id)
    {
        //ADD specified item to itemsRemoved collection
        itemsRemoved.add(id);
    }

    /**
     * Requests the list of Items to be removed upon success
     *
     * @return the list of indexes to the Items to be removed
     */
    public ArrayList<Integer> getItemsRemoved()
    {
        return itemsRemoved;
    }

    /**
     * Adds an Item to the list of Items required for the Action to succeed
     *
     * @param id the index of the Item required
     */
    public void addItemRequired(Integer id)
    {
        //ADD specified item to itemsRequired collection
        itemsRequired.add(id);
    }

    /**
     * Requests the list of Items required for the Action to succeed
     *
     * @return the list of indexes to the Items required
     */
    public ArrayList<Integer> getItemsRequired()
    {
        return itemsRequired;
    }
}
