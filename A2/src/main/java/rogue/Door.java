package rogue;

import java.util.ArrayList;

public class Door {
    private ArrayList<Room> rooms;

    /**
     * Default constructor for door class.
     */
    public Door() {
        this.rooms = new ArrayList<Room>();
    }

    /**
     * Function connecting rooms to each other.
     * @param r
     */
    public void connectRoom(Room r) {
        this.rooms.add(r);
    }

    /**
     * Gets all rooms connected to each other.
     * @return Returns all rooms connected.
     */
    public ArrayList<Room> getConnectedRooms() {
        return this.rooms;
    }

    /**
     * Gets other rooms connected to current room.
     * @param currentRoom
     * @return Returns gotten room(s).
     */
    public Room getOtherRoom(Room currentRoom) {
        int id1 = currentRoom.getId();
        int id2 = this.rooms.get(0).getId();
        int id3 = this.rooms.get(1).getId();
        if (id1 != id2 && id1 != id3) {
            return null;
        } else if (id1 == id2) {
            return this.rooms.get(1);
        } else {
            return this.rooms.get(0);
        }
    }
}
