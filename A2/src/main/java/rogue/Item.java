package rogue;

import java.awt.Point;

/**
 * A basic Item class; basic functionality for both consumables and equipment.
 */
public class Item {
    private int id;
    private String name;
    private String type;
    private Point xyLocation;
    private Character newDisplayCharacter;
    private String newDescription;
    private Room newCurrentRoom;

    // Constructors
    /**
     * Default constructor for Item class.
     */
    public Item() {
        this.id = 1;
        this.name = "AJ";
        this.type = "";
        this.xyLocation = new Point();
    }

    /**
     * Initializes constructor for Item class.
     * @param itemID
     * @param itemname
     * @param itemtype
     * @param itemxyLocation
     */
    public Item(int itemID, String itemname, String itemtype, Point itemxyLocation) {
        this.id = itemID;
        this.name = itemname;
        this.type = itemtype;
        this.xyLocation = itemxyLocation;
    }

    /**
     * Creates a copy of an item.
     * @return Returns copy of an item.
     */
    public Item copy() {
        Item copy = new Item(this.id, this.name, this.type, this.xyLocation);
        return copy;
    }

    // Getters and setters

    /**
     * Gets ID of room.
     * @return Returns ID of room.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets ID of room.
     * @param itemid
     */
    public void setId(int itemid) {
        this.id = itemid;
    }

    /**
     * Gets name of player.
     * @return Returns name of player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name of player.
     * @param itemname
     */
    public void setName(String itemname) {
        this.name = itemname;
    }

    /**
     * Gets type variable.
     * @return Returns type variable.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type variable.
     * @param itemtype
     */
    public void setType(String itemtype) {
        this.type = itemtype;
    }

    /**
     * Initializes character display on map.
     * @return Returns character display on map.
     */
    public Character getDisplayCharacter() {
        return newDisplayCharacter;
    }

    /**
     * Sets new character display on map.
     * @param itemnewDisplayCharacter
     */
    public void setDisplayCharacter(Character itemnewDisplayCharacter) {
        this.newDisplayCharacter = itemnewDisplayCharacter;
    }

    /**
     * Gives items a description.
     * @return Returns item description.
     */
    public String getDescription() {
        return newDescription;
    }

    /**
     * Sets item descrption for each item.
     * @param itemnewDescription
     */
    public void setDescription(String itemnewDescription) {
        this.newDescription = itemnewDescription;
    }

    /**
     * Gets X and Y locations for all objects on map.
     * @return Returns X and Y location of object.
     */
    public Point getXyLocation() {
        return xyLocation;
    }

    /**
     * Sets X and Y location of an object.
     * @param itemnewXyLocation
     */
    public void setXyLocation(Point itemnewXyLocation) {
        this.xyLocation = itemnewXyLocation;
    }

    /**
     * Gets the current room of the player and what is in the room.
     * @return Returns player's current room.
     */
    public Room getCurrentRoom() {
        return newCurrentRoom;
    }

    /**
     * Sets current room for player.
     * @param itemnewCurrentRoom
     */
    public void setCurrentRoom(Room itemnewCurrentRoom) {
        this.newCurrentRoom = itemnewCurrentRoom;
    }
}
