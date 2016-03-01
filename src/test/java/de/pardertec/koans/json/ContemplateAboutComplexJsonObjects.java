package de.pardertec.koans.json;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Thiemo on 01.03.2016.
 */
public class ContemplateAboutComplexJsonObjects {


    @Test(dependsOnMethods = { "de.pardertec.koans.json.ContemplateAboutTheEmptyJsonObject.aboutGettingAStringWithIncorrectType" })
    public void aboutAJSONObjectWithMultipleProperties() {
        JSONObject bazinga = new JSONObject();
        bazinga.put("TheAnswer", 42);
        bazinga.put("Thiemo likes that book", false);
        bazinga.put("BookTitle", "The Hitchhiker's Guide to the Galaxy, by Douglas Adams");
        bazinga.put("Description", "The Answer to the Ultimate Question of Life, the Universe, and Everything");

        boolean theAnswerIsCorrect = bazinga.getInt("TheAnswer") == 42;
        boolean theRatingIsCorrect = true == bazinga.getBoolean("Thiemo likes that book");
        boolean titleIsCorrect = bazinga.getString("BookTitle").equals("The Hitchhiker's Guide to the Galaxy, by Douglas Adams");
        boolean descriptionIsCorrect = bazinga.getString("Description").equals("If you solve this, " +
                "you have made a significant step towards enlightenment.");

        assertTrue("JSONObjects bundle multiple properties. To reach a higher level of awareness, " +
                        "contemplate about which value of the 'bazinga' object does not match the expectation.",
                theAnswerIsCorrect && theRatingIsCorrect && titleIsCorrect && descriptionIsCorrect);
    }

    @Test(dependsOnMethods = { "aboutAJSONObjectWithMultipleProperties" })
    public void aboutAJSONObjectWithinAJSONObject() {
        JSONObject book1 = new JSONObject();
        book1.put("Title", "The Hitchhiker's Guide to the Galaxy");

        JSONObject book2 = new JSONObject();
        book2.put("Title", "The Restaurant at the End of the Universe");

        JSONObject bazinga = new JSONObject();
        bazinga.put("Book 1", book1);
        bazinga.put("Book 2", book2);

        String expectedValue = "The Restaurant at the End of the Universe";
        String actualValue = bazinga.getJSONObject("Book 1").getString("Title");

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about how to get the expected title out of the 'bazinga' object.",
                expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutAJSONObjectWithinAJSONObject" })
    public void aboutTheStringRepresentationOfAJSONObjectWithinAJSONObject() {
        JSONObject book1 = new JSONObject();
        book1.put("Title", "The Hitchhiker's Guide to the Galaxy");

        JSONObject bazinga = new JSONObject();
        bazinga.put("Book 1", book1);

        String expectedValue = "{\"Book 1\":{\"Pages\":357,\"Title\":\"The Hitchhiker's Guide to the Galaxy\"}}";
        String actualValue = bazinga.toString();

        assertEquals("To reach a higher level of awareness, contemplate about what you should put into the 'bazinga' object, " +
                        "so that it's string representation matches the expectation.",
                expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutTheStringRepresentationOfAJSONObjectWithinAJSONObject" })
    public void aboutConstructingAJSONObjectFromAString(){
        String stringRepresentation = "{\"Book 1\":{\"Pages\":357,\"Title\":\"The Hitchhiker's Guide to the Galaxy\"}}";
        JSONObject bazinga = new JSONObject(stringRepresentation);

        boolean containsBook1 = bazinga.has("Book 1");

        assertFalse("You can use the constructor to construct a JSONObject with all it's properties from a string representation." +
                " To reach a higher level of awareness, contemplate about how you need to modify the string.",
                containsBook1);
    }
}
