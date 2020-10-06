package rogue;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.awt.Point;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class A1Solution{

    public static void main(String[] args) { 
        // Hardcoded configuration file location/name
        String configurationFileLocation = "fileLocations.json";  //please don't change this for this version of the assignment
        
 // reading the input file locations using the configuration file
        JSONParser parser = new JSONParser();
        String rooms = new String();
        String symbols = new String();
        try {

            Object obj = parser.parse(new FileReader(configurationFileLocation));
            JSONObject configurationJSON = (JSONObject) obj;
            
            rooms = configurationJSON.get("Rooms").toString();
            symbols = configurationJSON.get("Symbols").toString();
            


            // Extract the Rooms value from the file to get the file location for rooms
            

            // Extract the Symbols value from the file to get the file location for symbols-map

            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }

// instantiate a new Rogue object and call methods to do the required things
        
        ArrayList<Item> allItems = new ArrayList<Item>();
        Rogue r = new Rogue();
        Player p = new Player();
        p.setName("Megh");
        r.setPlayer(p);
        r.createRooms(rooms);
        r.setSymbols(symbols);
        allItems = r.getItems();
        ArrayList<Room> allRooms = r.getRooms();

        System.out.println(r.displayAll());
        
    }


}