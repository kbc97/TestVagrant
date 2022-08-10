package com.TestVagrant.com.Common;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class Common extends BasePage {

//    Read the data from the json and return it as ArrayList
    public ArrayList readJson(String str) {
        JSONParser parser = new JSONParser(); // to read the file
        ArrayList<String> playerString = null; // return ArrayList
        try {
            Object obj = parser.parse(new FileReader("C:/Automation Learning/TestVagrant/src/test/resources/uploads/" + str));
            JSONObject jsonObject = (JSONObject) obj; // converting it into Json Object
            String name = (String) jsonObject.get("name");
            String location = (String) jsonObject.get("location");
            JSONArray players = (JSONArray) jsonObject.get("player"); // Seperating the JSONArray from the Main JSON Object

//            Printing Team Name and Location
            System.out.println("Team Name: " + name);
            System.out.println("Location: " + location);

            playerString = new ArrayList<>(); // create object for ArrayList

            for (Object player : players) { // traverse through each Object from the JSONArray
                playerString.add((String) player); // convert Object to String and add it to ArrayList of String type
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerString; // Return the final ArrayList created
    }
}
