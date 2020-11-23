package rogue;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Point;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Rogue {

    private RogueParser rogueParser;
    private ArrayList<Room> room;
    private ArrayList<Item> item;
    private Player player;

    public static final char UP = 'w';
    public static final char DOWN = 's';
    public static final char LEFT = 'a';
    public static final char RIGHT = 'd';

    /**
     * Default constructor for rogue class.
     */
    public Rogue() {
        this.room = new ArrayList<Room>();
        this.item = new ArrayList<Item>();
        this.rogueParser = new RogueParser();
    }

    /**
     * Constructor for rogue class.
     *
     * @param parser
     */
    public Rogue(RogueParser parser) {
        this.room = new ArrayList<Room>();
        this.item = new ArrayList<Item>();
        this.rogueParser = parser;
    }

    /**
     * Sets the player object for the game.
     *
     * @param thePlayer
     */
    public void setPlayer(Player thePlayer) {
        this.player = thePlayer;
    }

    /**
     * Sets symbols for the game.
     *
     * @param filename
     */
    public void setSymbols(String filename) {
        this.rogueParser = new RogueParser(filename);
    }

    /**
     * Gets rooms required for the game.
     *
     * @return Returns room gotten.
     */
    public ArrayList<Room> getRooms() {
        return this.room;
    }

    /**
     * Gets items required for the game.
     *
     * @return Returns items used in game.
     */
    public ArrayList<Item> getItems() {
        return this.item;
    }

    /**
     * Gets player used in game.
     *
     * @return returns player used in game.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the rogue parser used in game.
     *
     * @return Returns rogue parser for use in rogue.java.
     */
    public RogueParser getRogueParser() {
        return this.rogueParser;
    }

    /**
     * Creates all rooms used in game.
     *
     * @param filename
     */
    public void createRooms(String filename) {
        JSONParser parser = new JSONParser();
        try {
            Object roomObject = parser.parse(new FileReader(filename));
            JSONObject rooms2 = (JSONObject) roomObject;
            JSONArray roomArray = (JSONArray) rooms2.get("room");
            for (int i = 0; i < roomArray.size(); i++) {
                Room r = new Room();
                JSONObject jsonRoom = (JSONObject) roomArray.get(i);
                r.setHeight(Integer.parseInt(jsonRoom.get("height").toString()));
                r.setWidth(Integer.parseInt(jsonRoom.get("width").toString()));
                r.setId(Integer.parseInt(jsonRoom.get("id").toString()));
                r.setBoolean(Boolean.parseBoolean(jsonRoom.get("start").toString()));
                if (r.isPlayerInRoom()) {
                    player.setCurrentRoom(r);
                }
                JSONArray doorArray = (JSONArray) jsonRoom.get("doors");
                for (int j = 0; j < doorArray.size(); j++) {
                    JSONObject jsonDoor = (JSONObject) doorArray.get(j);
                    String dir = jsonDoor.get("dir").toString();
                    r.setDoor(dir, Integer.parseInt(jsonDoor.get("id").toString()));
                    r.setDirection(dir); }
                JSONArray lootArray = (JSONArray) jsonRoom.get("loot");
                for (int j = 0; j < lootArray.size(); j++) {
                    Item it = new Item();
                    JSONObject jsonL = (JSONObject) lootArray.get(j);
                    int x = Integer.parseInt(jsonL.get("x").toString());
                    int y = Integer.parseInt(jsonL.get("y").toString());
                    Point xy = new Point(x, y);
                    it.setId(Integer.parseInt(jsonL.get("id").toString()));
                    it.setXyLocation(xy);
                    r.getRoomItems().add(it); }
                this.room.add(r); }
            JSONArray itemsArray = (JSONArray) rooms2.get("items");
            for (int i = 0; i < itemsArray.size(); i++) {
                Item i1 = new Item();
                JSONObject jsonItem = (JSONObject) itemsArray.get(i);
                i1.setId(Integer.parseInt(jsonItem.get("id").toString()));
                i1.setName(jsonItem.get("name").toString());
                i1.setType(jsonItem.get("type").toString());
                this.item.add(i1); }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) { }
    }

    /**
     * Displays everything in the room.
     *
     * @return Returns the room.
     */
    public String displayAll() {
        String s = "";
        for (int i = 0; i < this.room.size(); i++) {
            s += "room: " + (i + 1) + "\n" + this.room.get(i).displayRoom();
        }
        return s;
    }

    /**
     * Gets the next displayed map.
     *
     * @return Returns next displayed map.
     */
    public String getNextDisplay() {
        return player.getCurrentRoom().displayRoom();
    }

    /**
     * Moves player.
     *
     * @param input
     * @return Returns a string stating where the player is moving.
     * @throws InvalidMoveException
     */
    public String makeMove(char input) throws InvalidMoveException {
        int x = (int) player.getXyLocation().getX();
        int y = (int) player.getXyLocation().getY();
        if (input == 'w') {
            if ((y - 1) < 0) {
                throw new InvalidMoveException("Up is out of bounds.");
            }
            Point wPoint = new Point(x, y - 1);
            player.setXyLocation(wPoint);
            return ("Moving Up");
        } else if (input == 'a') {
            if ((x - 1) < 0) {
                throw new InvalidMoveException("Left is out of bounds.");
            }
            Point aPoint = new Point(x - 1, y);
            player.setXyLocation(aPoint);
            return ("Moving Left");
        } else if (input == 's') {
            Point sPoint = new Point(x, y + 1);
            player.setXyLocation(sPoint);
            return ("Moving Down");
        } else if (input == 'd') {
            Point dPoint = new Point(x + 1, y);
            player.setXyLocation(dPoint);
            return ("Moving Right");
        }
        return "";
    }
}
