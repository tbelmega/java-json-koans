package de.pardertec.koans.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

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

    @Test(dependsOnMethods = { "aboutIteratingOverTheArray" })
    public void aboutElementsOfDifferentTypes(){
        JSONArray bazinga = new JSONArray();
        bazinga.put("A JSONArray can hold elements of different types at the same time, which a Java array can not.");
        bazinga.put(true);
        bazinga.put(42);
        bazinga.put(3.1415);

        int indexOfElementToGet = 2; //Change this to get an other element. Mind the expected class.
        Object elementWithUnknownClass = bazinga.get(indexOfElementToGet);
        Class<?> clazz = elementWithUnknownClass.getClass();

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about which element has the expected type." + END_LINE,
                String.class, clazz);
    }

    @Test(dependsOnMethods = { "aboutElementsOfDifferentTypes" })
    public void aboutGettingAnElementOfTheWrongType(){
        JSONArray bazinga = new JSONArray();
        bazinga.put("Be careful about the type of the element you are trying to get.");

        try {
            int index = 0;
            Object firstElement = bazinga.getBoolean(index); //change bazinga.getBoolean() to a method that matches the type of the first element
        } catch (JSONException e) {
            fail("To reach a higher level of awareness, " +
                    "contemplate about using the correct getter method.");
        }
    }

    @Test(dependsOnMethods = { "aboutGettingAnElementOfTheWrongType" })
    public void aboutCastingTheElementToItsActualClass(){
        JSONArray bazinga = new JSONArray();
        bazinga.put("You can get an element as an instance of Object and cast it to its actual class later.");

        Object firstElement = bazinga.get(0);
        Class<?> clazz = firstElement.getClass();

        try {
            if (clazz.equals(String.class)) {
                boolean value = (boolean) firstElement;
            } else if (clazz.equals(Integer.class)) {
                int value = (int) firstElement;
            }
        } catch (ClassCastException e) {
            fail("To reach a higher level of awareness, " +
                    "contemplate about what class cast is correct.");
        }
    }


}
