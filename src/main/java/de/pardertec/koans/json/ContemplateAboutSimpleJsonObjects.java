package de.pardertec.koans.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Thiemo on 29.02.2016.
 */
public class ContemplateAboutSimpleJSONObjects {

    public static final String END_LINE = "\n\t->";

    @Test
    public void aboutTheLength(){
        JSONObject bazinga = new JSONObject();

        int expectedValue = bazinga.length();
        int actualValue = 42;

        assertEquals("To reach a higher level of awareness, " +
                        "cause 'actualValue' to be the number of elements 'bazinga' contains." + END_LINE,
                expectedValue, actualValue);
    }


    @Test(dependsOnMethods = { "aboutTheLength" })
    public void aboutTheToStringMethod(){
        JSONObject bazinga = new JSONObject();

        String expectedValue = bazinga.toString();
        String actualValue = "To reach a higher level of awareness, " +
                "contemplate about what the value of this String should be.";

        assertEquals(expectedValue, actualValue);
    }


    @Test(dependsOnMethods = { "aboutTheToStringMethod" })
    public void aboutPuttingAnIntegerIn(){
        JSONObject bazinga = new JSONObject();
        bazinga.put("TheAnswer", 1337);

        int expectedValue = 42;
        int actualValue = bazinga.getInt("TheAnswer");

        assertEquals("To reach a higher level of awareness, " +
                "contemplate about what value for the 'TheAnswer' property you should put into 'bazinga' object." + END_LINE,
                expectedValue, actualValue);
    }


    @Test(dependsOnMethods = { "aboutPuttingAnIntegerIn" })
    public void aboutTheStringRepresentationAfterPuttingAnElementIn(){
        JSONObject bazinga = new JSONObject();
        bazinga.put("Pi", 3.14);

        String expectedValue = "{\"Pi\":3.1415}";
        String actualValue = bazinga.toString();

        assertEquals("To reach a higher level of awareness, contemplate about what you should put into the 'bazinga' object, " +
                "so that it's string representation matches the expectation." + END_LINE,
                expectedValue, actualValue);
    }


    @Test(dependsOnMethods = { "aboutTheStringRepresentationAfterPuttingAnElementIn" })
    public void aboutPuttingAStringIn(){
        JSONObject bazinga = new JSONObject();
        bazinga.put("Description", "The Hitchhiker's Guide to the Galaxy");

        String expectedValue = "The Answer to the Ultimate Question of Life, the Universe, and Everything";
        String actualValue = bazinga.getString("Description");

        assertEquals("To reach a higher level of awareness, " +
                "contemplate about what value the 'Description' property should have" + END_LINE, expectedValue, actualValue);
    }


    @Test(dependsOnMethods = { "aboutPuttingAStringIn" })
    public void aboutGettingAPropertyThatDoesNotExist(){
        JSONObject bazinga = new JSONObject();
        bazinga.put("Title","");

        boolean propertyDoesExist = bazinga.has("Description");

        assertTrue("The 'has()' method checks whether a JSONObject contains a property with the specified name. " +
                "To reach a higher level of awareness, " +
                "contemplate about what property you need to put into the 'bazinga' object." + END_LINE, propertyDoesExist);
    }


    @Test(dependsOnMethods = { "aboutGettingAPropertyThatDoesNotExist" })
    public void aboutGettingAStringWithIncorrectType(){
        JSONObject bazinga = new JSONObject();
        bazinga.put("TheAnswer", "The answer to life, the universe and everything");

        try {
            int theAnswer = bazinga.getInt("TheAnswer");
        } catch (JSONException e) {
            throw new JSONException("Java is type save, JSON is not. Even if the 'bazinga' object contains a property with the specified name, " +
                    "it might have the wrong type. " +
                    "To reach a higher level of awareness, " +
                    "contemplate about what type of value you should set for the 'TheAnswer' property." + END_LINE);
        }
    }



}
