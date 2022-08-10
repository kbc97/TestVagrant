package com.TestVagrant.com.StepDefs;

import com.TestVagrant.com.Common.Common;
import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class CommonStepDefs extends Common implements En {

    public ArrayList<String> playerString = new ArrayList<>();

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

        @Given("I read the {string} file")
    public void iReadTheRCBTeamJsonFile(String str) {
        Common commonObject = new Common(); // creating object for java class Common
            playerString = commonObject.readJson(str); // calling readJson method to read the data from json file and store
    }
}
