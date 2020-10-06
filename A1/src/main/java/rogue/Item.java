package rogue;
import java.awt.Point;

/**
 * A basic Item class; basic functionality for both consumables and equipment
 */
public class Item  {
    private int id;
    private String name;
    private String type;
    private Point xyLocation;
    private Character newDisplayCharacter;
    private String newDescription;
    private Room newCurrentRoom;


    //Constructors
    public Item() {
        
    }

    public Item(int id, String name, String type, Point xyLocation) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.xyLocation = xyLocation;
    }
    
    // Getters and setters


    public int getId() {
        return this.id;
       
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;

    }


    public void setType(String type) {
        this.type = type;
    }
    

    public Character getDisplayCharacter() {
        return newDisplayCharacter;
        
    }


    public void setDisplayCharacter(Character newDisplayCharacter) {
        this.newDisplayCharacter = newDisplayCharacter;
    }


    public String getDescription() {
        return newDescription;
     
    }


    public void setDescription(String newDescription) {
        this.newDescription = newDescription;
    }


    public Point getXyLocation() {
        return xyLocation;  
     
    }

    
    public void setXyLocation(Point newXyLocation) {
        this.xyLocation = newXyLocation;
    }


    public Room getCurrentRoom() {
        return newCurrentRoom;
        
    }


    public void setCurrentRoom(Room newCurrentRoom) {
        this.newCurrentRoom = newCurrentRoom;
    }
}
