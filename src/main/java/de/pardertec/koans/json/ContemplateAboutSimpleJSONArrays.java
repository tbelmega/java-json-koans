package de.pardertec.koans.json;

import org.json.JSONArray;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Thiemo on 04.03.2016.
 */
public class ContemplateAboutSimpleJSONArrays {

    public static final String END_LINE = "\n\t->";

    @Test
    public void aboutTheLength() throws Exception {
        JSONArray bazinga = new JSONArray();
        bazinga.put(42);

        int expectedValue = bazinga.length();
        int actualValue = 42;

        assertEquals("To reach a higher level of awareness, " +
                        "cause 'actualValue' to be the number of elements 'bazinga' contains." + END_LINE,
                expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutTheLength" })
    public void aboutTheToStringMethod(){
        JSONArray bazinga = new JSONArray();
        bazinga.put(1);
        bazinga.put(17);
        bazinga.put(42);

        String expectedValue = bazinga.toString();
        String actualValue = "To reach a higher level of awareness, " +
                "contemplate about what the value of this String should be.";

        assertEquals(expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutTheToStringMethod" })
    public void aboutPuttingElementsIn(){
        JSONArray bazinga = new JSONArray();
        bazinga.put(42);
        bazinga.put("TheAnswer");

        int expectedValue = 3;
        int actualValue = bazinga.length();

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about what you should put into 'bazinga' object." + END_LINE,
                expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutPuttingElementsIn" })
    public void aboutTheStringRepresentationAfterPuttingElementsIn(){
        JSONArray bazinga = new JSONArray();
        bazinga.put(42);
        bazinga.put("a comma-separated list of elements");
        bazinga.put(true);

        String expectedValue = "[42,\"TheAnswer\",true]";
        String actualValue = bazinga.toString();

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about what you should put into 'bazinga' object." + END_LINE,
                expectedValue, actualValue);
    }

    @Test(dependsOnMethods = { "aboutTheStringRepresentationAfterPuttingElementsIn" })
    public void aboutGettingAnElement(){
        JSONArray fibonacci = new JSONArray();
        fibonacci.put(1);
        fibonacci.put(1);
        fibonacci.put(2);
        fibonacci.put(3);
        fibonacci.put(5);
        fibonacci.put(8);
        fibonacci.put(13);

        int sixthElement = fibonacci.getInt(6);
        int expectedValue = 8;

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about how you get the sixth element of the array." + END_LINE,
                expectedValue, sixthElement);
    }

    @Test(dependsOnMethods = { "aboutGettingAnElement" })
    public void aboutIteratingOverTheArray(){
        JSONArray fibonacci = new JSONArray();
        fibonacci.put(1);
        fibonacci.put(1);
        fibonacci.put(2);
        fibonacci.put(3);
        fibonacci.put(5);
        fibonacci.put(8);
        fibonacci.put(13);

        int sum = 0;

        for (int i = 0; i < fibonacci.length(); i++) {
            fibonacci.getInt(i);
            sum += 1;
        }

        int expectedSum = 33;

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about how you sum up the elements of the array." + END_LINE,
                expectedSum, sum);
    }
}
