package rogue;
import java.util.ArrayList; 
import java.util.Map;
import java.awt.Point;


/**
 * A room within the dungeon - contains monsters, treasure,
 * doors out, etc.
 */
public class Room  {

  private int width;
  private int height;
  private int id;
  private ArrayList<Item> roomItems = new ArrayList<Item>();
  private Player player;
  private int northDoor = -1;
  private int southDoor = -1;
  private int eastDoor = -1;
  private int westDoor = -1;
  private String direction;
  private boolean start;
  private String name;
  private String symbol;

    // Default constructor
  public Room() {

  }
  public Room(int width, int height, int id, boolean start,  int location, String direction) {
    this.width = width;
    this.height = height;
    this.id = id;
    this.start = start;
    this.direction = direction;
  }

   // Required getter and setters below

  public int getWidth() {
    return this.width;
  }
 
  public void setWidth(int newWidth) {
    this.width = newWidth;
  }

 
  public int getHeight() {
    return this.height;
  }

  public void setHeight(int newHeight) {
    this.height = newHeight;
  }

  public int getId() {
    return this.id;
  }  

  public void setId(int newId) {
    this.id = newId;
  }

  public ArrayList<Item> getRoomItems() {
    return this.roomItems;
  }

  public void setRoomItems(ArrayList<Item> newRoomItems) {
    this.roomItems = roomItems;
  }

  public Player getPlayer() {
    return this.player;
  }

  public void setPlayer(Player newPlayer) {
    this.player = newPlayer;
  }

  public void setSymbolName(String name) {
    this.name = name;
  }

  public String getSymbolName() {
    return this.name;
  }

  public void setSymbolMap(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbolMap() {
    return symbol;
  }

  public int getDoor(String direction){
    if (direction.equals("N")) {
      return this.northDoor;
    } else if (direction.equals("S")) {
      return this.southDoor;
    } else if (direction.equals("E")) {
      return this.eastDoor;
    } else if(direction.equals("W")) {
      return this.westDoor;
    } else {
      return -1;
    }

  }
  public String getDirection() {
    return this.direction;
  }
  public void setDirection(String direction) {
    this.direction = direction;
  }

/*
direction is one of NSEW
location is a number between 0 and the length of the wall
*/

  public void setDoor(String direction, int location){
    if (direction.equals("N")) {
      this.northDoor = location;
    } else if (direction.equals("S")) {
      this.southDoor = location;
    } else if (direction.equals("E")) {
      this.eastDoor = location;
    } else if(direction.equals("W")) {
      this.westDoor = location;
    }
  }

  public boolean isPlayerInRoom() {
    return start;
  }

  public void setBoolean(boolean start) {
    this.start = start;
  }


   /**
    * Produces a string that can be printed to produce an ascii rendering of the room and all of its contents
    * @return (String) String representation of how the room looks
    */
  public String displayRoom() {
    String str = "";
    char[][] arr = new char [height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        
        if (northDoor == j && i == 0) {
          arr[i][j] = '+';
        } else if (southDoor == j && i == height-1) {
          arr[i][j] = '+';
        } else if(westDoor == i && j == 0) {
          arr[i][j] = '+';
        } else if(eastDoor == i && j == width-1) {
          arr[i][j] = '+';
        } else if (i == 0 || i == height-1) {
          arr[i][j] = '-';
        } else if (j == 0 || j == width-1) {
          arr[i][j] = '|';
        } else if(isPlayerInRoom() == true && i == 1 && j == 1) {
          arr[i][j] = '@';
        } else {
          arr[i][j] = '.';
        }
        for (int k = 0; k < roomItems.size(); k++) {
          if ((int)roomItems.get(k).getXyLocation().getX() == j && (int)roomItems.get(k).getXyLocation().getY() == i) {
            arr[i][j] = '*';
          }
        }
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        str += arr[i][j];
      }
      str += '\n';
    }
    return str;
  }
}
