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
    public int countOfForeignPlayers;

    @Given("I read the {string} file")
    public void iReadTheRCBTeamJsonFile(String str) {
        Common commonObject = new Common(); // creating object for java class Common
        playerString = commonObject.readJson(str); // calling readJson method to read the data from json file and store
    }

    @When("I count the number of foreign players")
    public void iCountTheNumberOfForeignPlayers() {
        Common commonObject = new Common();
        countOfForeignPlayers = commonObject.countForeignPlayers(playerString); // calling method to count the number of foreign players in the team
    }

    @Then("Total number of foreign players should match with number {int}")
    public void totalNumberOfForeignPlayersShouldMatchWithNumber(int foreignPlayerCount) {
//        Verify whether the count of foreign players in RCB Team matches the expected count
        assertTrue(foreignPlayerCount==countOfForeignPlayers, "EXPECTED foreign players: " +
                foreignPlayerCount + " but FOUND: " + countOfForeignPlayers);
    }
}
