package com.TestVagrant.com.StepDefs;

import com.TestVagrant.com.Common.Common;
import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import java.lang.annotation.Annotation;
import static org.testng.Assert.assertTrue;

public class CommonStepDefs extends Common implements En {

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public JSONArray playerString = new JSONArray();
    public int playerCount;

    @Given("I read the {string} file")
    public void iReadTheRCBTeamJsonFile(String str) {
        Common commonObject = new Common(); // creating object for java class Common
        playerString = commonObject.readJson(str); // calling readJson method to read the data from json file and store
    }

    @When("I count the number of {string} players")
    public void iCountTheNumberOfPlayers(String str) {
        Common commonObject = new Common();
        playerCount = commonObject.countPlayers(playerString, str); // calling method to count the number of players for given condition
    }

    @Then("Total number of foreign players should match with number {int}")
    public void totalNumberOfForeignPlayersShouldMatchWithNumber(int foreignPlayerCount) {
        System.out.println("Expected count: " + foreignPlayerCount);
        System.out.println("JSON file count: " + playerCount);
//        Verify whether the count of foreign players in RCB Team matches the expected count
        assertTrue(foreignPlayerCount == playerCount, "EXPECTED foreign players: " +
                foreignPlayerCount + " but FOUND: " + playerCount);
    }

    @Then("Team should have atleast {int} wicket-keeper")
    public void teamShouldHaveAtleastWicketKeeper(int minimumWicketKeeper) {
        System.out.println("Expected count: " + minimumWicketKeeper);
        System.out.println("JSON file count: " + playerCount);
//        Verify whether the count of foreign players in RCB Team matches the expected count
        assertTrue(0<playerCount && playerCount <= minimumWicketKeeper, "EXPECTED foreign players: " +
                minimumWicketKeeper + " but FOUND: " + playerCount);
    }
}
