package de.pardertec.koans.json;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.*;

/**
 * Created by Thiemo on 29.02.2016.
 */
public class ContemplateAboutAssertions {

    public static final String END_LINE = "\n\t->";
    
    @Test
    public void aboutAssertTrue() throws Exception {
        boolean myBoolean = false;

        assertTrue("To reach a higher level of awareness, cause myBoolean to be true.",myBoolean);
    }


    @Test(dependsOnMethods = { "aboutAssertTrue" })
    public void aboutAssertFalse() throws Exception {
        boolean myBoolean = true;

        assertFalse("To reach a higher level of awareness, cause myBoolean to be false.", myBoolean);
    }


    @Test(dependsOnMethods = { "aboutAssertFalse" })
    public void aboutAssertionMessages() throws Exception {
        boolean myBoolean = true;

        /*
         * Assertion messages are optional.
         * This time you will get no hint how to reach a higher level of awareness,
         * because the programmer did not pass a meaningful assertion message.
         *
         * Contemplate about how to reach a higher level of awareness in this case.
         */
        assertFalse(myBoolean);
    }


    @Test(dependsOnMethods = { "aboutAssertionMessages" })
    public void aboutAssertEquals() throws Exception {
        String expectedString = "Hello World.";
        String actualString = "";

        assertEquals("\nThe last argument of assertEquals() is the actual value.\n" +
                "The second last is the expected value.\n" +
                "The third last may be an error message, in case the assertion fails.\n" +
                "To reach a higher level of awareness, modify the actual value of every failing assertion." + END_LINE,
                expectedString, actualString);

        assertEquals(expectedString, "");

        int expectedInt = 42;
        int actualInt = 0;
        assertEquals(expectedInt, actualInt);

        boolean expectedBoolean = true;
        assertEquals(expectedBoolean, false);
    }

    @Test(dependsOnMethods = { "aboutAssertEquals" })
    public void aboutAssertNotNull() throws Exception {
        Object o = null;
        assertNotNull("To reach a higher level of awareness, cause o to be anything else than Null" + END_LINE, o);
    }

    @Test(dependsOnMethods = { "aboutAssertNotNull" })
    public void aboutAssertNull() throws Exception {
        Object o = new Object();
        assertNull("To reach a higher level of awareness, cause o to be Null" + END_LINE, o);
    }




}
