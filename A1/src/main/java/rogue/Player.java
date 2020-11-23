package rogue;
import java.util.ArrayList;
import java.awt.Point;
/**
 * The player character
 */
public class Player {
    private String name;
    private Point newXyLocation;
    private Room newRoom;

    // Default constructor
    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Point getXyLocation() {
        return newXyLocation;
    }

    public void setXyLocation(Point newXyLocation) {
        this.newXyLocation = newXyLocation;
    }

    public Room getCurrentRoom() {
        return this.newRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.newRoom = newRoom;
    }
}
