package de.pardertec.koans.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

/**
 * Created by Thiemo on 04.03.2016.
 */
public class ContemplateAboutTypeSafety {

    public static final String END_LINE = "\n\t->";

    @Test
    public void aboutJSONArraysWithElementsOfDifferentTypes(){
        JSONArray bazinga = new JSONArray();
        bazinga.put("Java is type safe, JavaScript is not.");
        bazinga.put("That means, the Java compiler normally prevents you from assigning values of the wrong type.");
        bazinga.put("When you get Java objects out of JavaScript objects (JSON), you have to be careful about the types.");
        bazinga.put(true);
        bazinga.put(42);
        bazinga.put(3.1415);

        int indexOfElementToGet = 1; //Change this to get an other element. Mind the expected class.
        Object elementWithUnknownClass = bazinga.get(indexOfElementToGet);
        Class<?> clazz = elementWithUnknownClass.getClass();

        assertEquals("To reach a higher level of awareness, " +
                        "contemplate about which element has the expected type." + END_LINE,
                Integer.class, clazz);
    }

    @Test(dependsOnMethods = { "aboutJSONArraysWithElementsOfDifferentTypes" })
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
    public void aboutJSONObjectsWithElementsOfDifferentTypes() {
        JSONObject bazinga = new JSONObject();
        bazinga.put("Hint","Like for JSONArrays, you have to mind the type you get for JSONObjects too.");
        bazinga.put("some boolean",true);
        bazinga.put("TheAnswer",42);

        try {
            Object value = bazinga.getInt("Hint");
        } catch (JSONException e) {
            fail("To reach a higher level of awareness, " +
                    "contemplate about using the correct getter method.");
        }
    }


    @Test(dependsOnMethods = { "aboutJSONObjectsWithElementsOfDifferentTypes" })
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
