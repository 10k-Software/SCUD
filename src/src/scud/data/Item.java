package scud.data;

/**
 * The Item class represents a game item with a name and description.  The Item 
 * includes a name, which is how the item is displayed, as well as a 
 * description which describes the item itself, and what it is. 
 * 
 * Items are often given or taken from the user depending on actions called.
 * Items are also required in order for certain actions to succeed, allowing
 * them to act as simple state-machines if need be.
 * 
 * @author Andrew Chan
 * @.date 2008-10-12
 * @version 0.3
 */
//Version History

public class Item 
{
    /**
     * Unique index that identifies each discrete Item
     */
    private Integer itemId;
    
    /**
     * The name of the Item
     */
    private String itemName;
    
    /**
     * The description of the Item
     */
    private String description;
    
    /**
     * Constructs a new Item.
     */
    public Item()
    {
        itemId = 0;
        itemName = null;
    }
    
    /**
     * Saves the unique index of the Item
     * 
     * @param id the Item index
     */
    public void setId(Integer id) 
    {
        itemId = id;
    }
    
    /**
     * Requests the index of the Item
     * 
     * @return the Item index
     */
    public Integer getId() 
    {
        return itemId;
    }

    /**
     * Saves the name of the Item
     * 
     * @param name the Item name
     */
    public void setName(String name) 
    {
        itemName = name;
    }
    
    /**
     * Requests the name of the Item
     * 
     * @return the Item name
     */
    public String getName() 
    {
        return itemName;
    }
    
    /**
     * Saves the description of the Item
     * 
     * @param desc the Item description
     */
    public void setDescription(String desc) 
    {
        description = desc;
    }
    
    /**
     * Requests the description of the Item
     * 
     * @return the Item description
     */
    public String getDescription() 
    {
        return description;
    }
}
