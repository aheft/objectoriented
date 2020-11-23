package rogue;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A room within the dungeon - contains monsters, treasure, doors out, etc.
 */
public class Room {

  private int width;
  private int height;
  private int id;
  private ArrayList<Item> roomItems = new ArrayList<Item>();
  private Player player;
  private String direction;
  private boolean start;
  private String name;
  private String symbol;
  private HashMap doors = new HashMap();
  private ArrayList<ArrayList<String>> mapOfRoom = new ArrayList<ArrayList<String>>();

  // Default constructor

  /**
   * Default constructor for Room class.
   */
  public Room() {
    this.width = 0;
    this.height = 0;
    this.id = 0;
    this.start = true;
    this.direction = "South";
  }

  /**
   * Room constructor setting all variables of a room.
   * @param roomwidth
   * @param roomheight
   * @param roomid
   * @param roomstart
   * @param roomdirection
   */
  public Room(int roomwidth, int roomheight, int roomid, boolean roomstart, String roomdirection) {
    this.width = roomwidth;
    this.height = roomheight;
    this.id = roomid;
    this.start = roomstart;
    this.direction = roomdirection;
  }

  /**
   * Copies all parts of a room.
   * @return Returns copy of the room.
   */
  public Room copyRoom() {
    Room copy = new Room(this.width, this.height, this.id, this.start, this.direction);
    Collections.copy(copy.roomItems, this.roomItems);
    copy.doors.putAll(this.doors);
    return copy;
  }

  /*
   * public void setMapOfRoom(RogueParser()){
   *
   * }
   */
  // Required getter and setters below

  /**
   * Gets width of the room.
   * @return Returns width of the room.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Sets width of the room.
   * @param newWidth
   */
  public void setWidth(int newWidth) {
    this.width = newWidth;
  }

  /**
   * Gets height of the room.
   * @return Returns height of the room.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Sets height of the room.
   * @param newHeight
   */
  public void setHeight(int newHeight) {
    this.height = newHeight;
  }

  /**
   * Gets ID of the room.
   * @return Returns the ID of the room.
   */
  public int getId() {
    return this.id;
  }

  /**
   * Sets the ID of the room.
   * @param newId
   */
  public void setId(int newId) {
    this.id = newId;
  }

  /**
   * Gets all of the items in the room.
   * @return Returns all of the items in the room.
   */
  public ArrayList<Item> getRoomItems() {
    return this.roomItems;
  }

  /**
   * Compares locations of one item with another to ensure they are not the same.
   * @param a
   * @param b
   * @return Returns True if locations are the same, and false if not.
   */
  public boolean compareItems(Item a, Item b) {
    Point p1 = a.getXyLocation();
    Point p2 = b.getXyLocation();
    if (p1.x == p2.x && p1.y == p2.y) {
      return true;
    }
    return false;
  }

  /**
   * Checks the room to see if it contains an item.
   * @param a
   * @return Returns true if the room contains the item, and false if it doesn't.
   */
  public boolean contains(Item a) {
    for (int i = 0; i < this.roomItems.size(); i++) {
      if (this.compareItems(this.roomItems.get(i), a)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks to see if a room is empty.
   * @param x
   * @param y
   * @return Returns true if the room is empty and false if not.
   */
  public boolean isEmpty(int x, int y) {
    for (Item i : this.roomItems) {
      Point pt = i.getXyLocation();
      if (x == pt.x && y == pt.y) {
        return false;
      }
    }
    Point playerPt = this.player.getXyLocation();
    if (x == playerPt.x && y == playerPt.y) {
      return false;
    }
    return true;
  }

  /**
   * Finds an empty position for an item placed on top of another item.
   * @return Returns the empty position.
   */
  public Point findEmptyPosition() {
    for (int i = 1; i < this.width - 1; i++) {
      for (int j = 1; j < this.height - 1; j++) {
        if (this.isEmpty(i, j)) {
          return new Point(i, j);
        }
      }
    }
    return new Point(-1, -1);
  }

  /**
   * Adds an item to a room at a specified location.
   * @param toAdd
   * @throws ImpossiblePositionException
   * @throws NoSuchItemException
   */
  public void addItem(Item toAdd) throws ImpossiblePositionException, NoSuchItemException {
    Point pt = toAdd.getXyLocation();
    try {
      if (pt.x <= 0 || pt.x >= this.width || pt.y <= 0 || pt.y >= height || this.contains(toAdd)) {
        throw new ImpossiblePositionException("Item placed out of bounds");
      } else {
        this.roomItems.add(toAdd);
      }
    } catch (ImpossiblePositionException exception) {
      pt = findEmptyPosition();
      toAdd.setXyLocation(pt);
      this.roomItems.add(toAdd);
    }
  }

  /**
   * Sets all items in a room.
   * @param newRoomItems
   * @throws ImpossiblePositionException
   */
  public void setRoomItems(ArrayList<Item> newRoomItems) throws ImpossiblePositionException {
    for (int i = 0; i < newRoomItems.size(); i++) {
      Item item = newRoomItems.get(i);
      Point pt = item.getXyLocation();
      if (pt.x <= 0 || pt.x >= this.width || pt.y <= 0 || pt.y >= this.height || this.contains(item)) {
        throw new ImpossiblePositionException("Item placed out of bounds");
      }

    }
    Collections.copy(this.roomItems, newRoomItems);
  }

  /**
   * Gets the player.
   * @return Returns the player.
   */
  public Player getPlayer() {
    return this.player;
  }

  /**
   * Sets the player.
   * @param newPlayer
   */
  public void setPlayer(Player newPlayer) {
    this.player = newPlayer;
  }

  /**
   * Sets the name of the symbols in the room.
   * @param roomname
   */
  public void setSymbolName(String roomname) {
    this.name = roomname;
  }

  /**
   * Gets the name of the symbols in the room.
   * @return Returns the names of the symbols in the room.
   */
  public String getSymbolName() {
    return this.name;
  }

  /**
   * Creates the map of symbols.
   * @param roomsymbol
   */
  public void setSymbolMap(String roomsymbol) {
    this.symbol = roomsymbol;
  }

  /**
   * Gets the map of symbols.
   * @return Returns the map of symbols.
   */
  public String getSymbolMap() {
    return this.symbol;
  }

  /**
   * Gets the direction of the door.
   * @param roomdirection
   * @return Returns the direction of the door.
   */
  public int getDoor(String roomdirection) {
    return (int) this.doors.get(roomdirection);
  }

  /**
   * Gets the direction of a door.
   * @return Returns the direction of the door.
   */
  public String getDirection() {
    return this.direction;
  }

  /**
   * Sets the direction of the door.
   * @param roomdirection
   */
  public void setDirection(String roomdirection) {
    this.direction = roomdirection;
  }

  /*
   * direction is one of NSEW location is a number between 0 and the length of the
   * wall
   */

   /**
    * Sets variables of a door.
    * @param roomdirection
    * @param location
    */
  public void setDoor(String roomdirection, int location) {
    this.doors.put(roomdirection, location);
  }

  /**
   * Checks if the player is in the room at the start.
   * @return Returns true if the player is in the room and false if not.
   */
  public boolean isPlayerInRoom() {
    return this.start;
  }

  /**
   * Sets the start variable to true or false.
   * @param roomstart
   */
  public void setBoolean(boolean roomstart) {
    this.start = roomstart;
  }

  /**
   * Produces a string that can be printed to produce an ascii rendering of the
   * room and all of its contents.
   *
   * @return (String) String representation of how the room looks
   */
  public String displayRoom() {
    StringBuilder str = new StringBuilder();
    char[][] arr = new char[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      ArrayList<String> rowInRoom = new ArrayList<String>();
      for (int j = 0; j < this.width; j++) {

        if (this.getDoor("N") == j && i == 0) {
          rowInRoom.add(j, "+");
        } else if (this.getDoor("S") == j && i == this.height - 1) {
          rowInRoom.add(j, "+");
        } else if (this.getDoor("W") == i && j == 0) {
          rowInRoom.add(j, "+");
        } else if (this.getDoor("E") == i && j == this.width - 1) {
          rowInRoom.add(j, "+");
        } else if (i == 0 || i == this.height - 1) {
          rowInRoom.add(j, "-");
        } else if (j == 0 || j == this.width - 1) {
          rowInRoom.add(j, "|");
        } else if (this.isPlayerInRoom() && i == 1 && j == 1) {
          rowInRoom.add(j, "@");
        } else {
          rowInRoom.add(j, ".");
        }
        for (int k = 0; k < roomItems.size(); k++) {
          if ((int) roomItems.get(k).getXyLocation().getX() == j
              && (int) roomItems.get(k).getXyLocation().getY() == i) {
            rowInRoom.add(j, "*");
          }
        }
      }
      this.mapOfRoom.add(rowInRoom);
    }

    for (int i = 0; i < this.mapOfRoom.size(); i++) {
      ArrayList<String> currentRow = this.mapOfRoom.get(i);
      for (int j = 0; j < currentRow.size(); j++) {
        char[] stringArray = currentRow.get(j).toCharArray();
        str.append(stringArray);
      }
      str.append("\n");
    }
    return str.toString();
  }
}
