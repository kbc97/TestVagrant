package com.TestVagrant.com.Common;

import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.junit.Assert;
import static org.testng.Assert.assertTrue;

public class Common {

    //    Read the data from the json and return it as ArrayList
    public JSONArray readJson(String str) {
        JSONParser parser = new JSONParser(); // to read the file
        JSONArray players = null; // to store the JSONArray of all players
        try {
            Object obj = parser.parse(new FileReader("C:/Automation Learning/TestVagrant/src/test/resources/uploads/" + str));
            JSONObject jsonObject = (JSONObject) obj; // converting it into Json Object
            String name = (String) jsonObject.get("name");
            String location = (String) jsonObject.get("location");
            players = (JSONArray) jsonObject.get("player"); // Store the JSONArray separately

//            Printing Team Name and Location
            System.out.println("Team Name: " + name);
            System.out.println("Location: " + location);
            for (Object player : players) {
                System.out.println(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return players; // Return the final ArrayList created
    }

    //    Count the total number of foreign players in Team and return the count
    public int countPlayers(JSONArray rcbTeam, String condition) {
        switch (condition.toLowerCase()) {
            case "foreign":
                return countNumberOfForeignPLayers(rcbTeam);
            case "wicket keeper":
                return countNumberOfWicketKeepers(rcbTeam);
            default:
                assertTrue(false, "Key: " + condition + " did not match");
                return 0;
        }
    }

    private int countNumberOfWicketKeepers(JSONArray rcbTeam) {
        int count = 0;
        for (Object player : rcbTeam) { // iterate each JSONObject from given JSONArray
            String playerRole = (String) ((JSONObject) player).get("role"); // Store the role value for each Player

//            Check for the player who is a wicket keeper
            if (playerRole.contains("Wicket-keeper")) { // key match for "wicket-keeping" role
                count++; // If the player role contains wicket-keeping increase the count
            }
        }
        System.out.println("Count of Wicket-Keepers from JSON file: " + count);
        return count;
    }

    private int countNumberOfForeignPLayers(JSONArray rcbTeam) {
        int count = 0;
        String country = "India";
        for (Object player : rcbTeam) { // iterate each JSONObject from given JSONArray
            String playerCountry = (String) ((JSONObject) player).get("country"); // Store the country value for each Player

//            Check for the player who is foreigner
            if (!playerCountry.equalsIgnoreCase(country)) {
                count++; // If the player is foreigner increase the count
            }
        }
        System.out.println("Count of Foreign Players from JSON file: " + count);
        return count;
    }
}
