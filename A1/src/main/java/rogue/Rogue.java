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

import java.util.Iterator;


public class Rogue{

    private Player thePlayer;
    private ArrayList<Room> room = new ArrayList<Room>();
    private ArrayList<Item> item = new ArrayList<Item>();
    private Player player;



    public void setPlayer(Player thePlayer){
        this.thePlayer = thePlayer;
    }


    public void setSymbols(String filename){
        /*JSONParser parser = new JSONParser();
        String name = "", symbol = "";
        this.item = new ArrayList<Item>();
        try {
            Object symbolsObject = parser.parse(new FileReader(filename));
            JSONObject symbols2 = (JSONObject) symbolsObject;

            for (Object item : (JSONArray) symbols2.get("symbols")) {
                Item i = new Item();
                JSONObject jsonItem = (JSONObject) item;
                name = jsonItem.get("name").toString();
                symbol = jsonItem.get("symbol").toString();
                i.setName(name);
                i.setType(symbol);
                this.item.add(i);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
        }  */
    }

    public ArrayList<Room> getRooms(){
        return this.room;

    }

    public ArrayList<Item> getItems(){
        return this.item;

    }
    public Player getPlayer(){
        return this.player;

    }

    public void createRooms(String filename){
        int height = 0, width = 0, id = 0, id2 = 0, id4 = 0;
        String name = "", type = "";

        String dir = "";
        boolean start = true;
        
        JSONParser parser = new JSONParser();

        try {
            Object roomObject = parser.parse(new FileReader(filename));
            JSONObject rooms2 = (JSONObject) roomObject;

            
            for (Object room : (JSONArray) rooms2.get("room")) {
                Room r = new Room();
                JSONObject jsonRoom = (JSONObject) room;
                height = Integer.parseInt(jsonRoom.get("height").toString());
                width = Integer.parseInt(jsonRoom.get("width").toString());
                id = Integer.parseInt(jsonRoom.get("id").toString());
                start = Boolean.parseBoolean(jsonRoom.get("start").toString());
                r.setHeight(height);
                r.setWidth(width);
                r.setId(id);
                r.setBoolean(start); 

                for (Object door : (JSONArray) jsonRoom.get("doors")) {
                    JSONObject jsonDoor = (JSONObject) door;
                    dir = jsonDoor.get("dir").toString();
                    id2 = Integer.parseInt(jsonDoor.get("id").toString());
                    r.setDoor(dir, id2);
                    r.setDirection(dir);
                    
                }  
                
                for (Object loot : (JSONArray) jsonRoom.get("loot")) {
                    Item it = new Item();
                    JSONObject jsonL = (JSONObject) loot;
                    int x = Integer.parseInt(jsonL.get("x").toString());
                    int y = Integer.parseInt(jsonL.get("y").toString());
                    int id3 = Integer.parseInt(jsonL.get("id").toString());
                    Point xy = new Point(x,y);
                    it.setId(id3);
                    it.setXyLocation(xy);
                    r.getRoomItems().add(it);

                }
                this.room.add(r);
                
                    
            }
            
            for (Object items : (JSONArray) rooms2.get("items")) {
                Item i1 = new Item();
                JSONObject jsonItem = (JSONObject) items;
                id4 = Integer.parseInt(jsonItem.get("id").toString());
                name = jsonItem.get("name").toString();
                type = jsonItem.get("type").toString();
                i1.setId(id4);
                i1.setName(name);
                i1.setType(type);

                this.item.add(i1);

            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
    }
    public String displayAll() {
        String s = "";
        for (int i = 0; i < this.room.size(); i++) {
            s += "room: " + (i + 1) + "\n" + this.room.get(i).displayRoom();
        }
        return s;
    }
    
}