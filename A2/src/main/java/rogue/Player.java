package rogue;

import java.awt.Point;

/**
 * The player character.
 */
public class Player {
    private String name;
    private Point newXyLocation;
    private Room newRoom;

    // Default constructor

    /**
     * Default constructor for Player class.
     */
    public Player() {
        this.name = "AJ";
        this.newXyLocation = new Point();
        this.newRoom = new Room();
    }

    /**
     * Player constructor setting name, location and room.
     * @param playername
     */
    public Player(String playername) {
        this.name = playername;
        this.newXyLocation = new Point();
        this.newRoom = new Room();
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
     * @param playernewName
     */
    public void setName(String playernewName) {
        this.name = playernewName;
    }

    /**
     * Gets location on X and Y axes of the player.
     * @return Returns the player's location.
     */
    public Point getXyLocation() {
        return newXyLocation;
    }

    /**
     * Sets the location of the player.
     * @param playernewXyLocation
     */
    public void setXyLocation(Point playernewXyLocation) {
        this.newXyLocation = playernewXyLocation;
    }

    /**
     * Gets the current room of the player.
     * @return Returns the current room of the player.
     */
    public Room getCurrentRoom() {
        return this.newRoom;
    }

    /**
     * Sets current room of the player.
     * @param playernewRoom
     */
    public void setCurrentRoom(Room playernewRoom) {
        this.newRoom = playernewRoom;
    }
}
