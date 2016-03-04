package de.pardertec.koans;

import de.pardertec.koans.json.ContemplateAboutAssertions;
import de.pardertec.koans.json.ContemplateAboutComplexJsonObjects;
import de.pardertec.koans.json.ContemplateAboutSimpleJsonObjects;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Thiemo on 04.03.2016.
 *
 * This is your path to enlightenment.
 * To follow it, run the class as Java Application and follow the instructions in the console.
 *
 */
public class PathToEnlightenment {

    //////////////////////////////////
    // MAIN METHOD
    //////////////////////////////////

    public static void main(String args[]) throws Exception {
        PathToEnlightenment runner = new PathToEnlightenment();

        Class<?>[] testClassesList = new Class[]{
                ContemplateAboutAssertions.class,
                ContemplateAboutSimpleJsonObjects.class,
                ContemplateAboutComplexJsonObjects.class
        };

        runner.run(testClassesList);
    }


    //////////////////////////////////
    // FIELDS
    //////////////////////////////////

    private TestNG testNG;
    private TestListenerAdapter listener;


    //////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////

    public PathToEnlightenment() {
        this.testNG = new TestNG();
        this.testNG.setVerbose(0);
    }

    //////////////////////////////////
    // METHODS
    //////////////////////////////////

    private void run(Class<?>[] testClassesList) throws ClassNotFoundException, NotFoundException {
        for (int i = 0; i < testClassesList.length && !testNG.hasFailure(); i++) {
            listener = new TestListenerAdapter();
            Class<?> testClass = testClassesList[i];

            testNG.setTestClasses(new Class[] { testClass } );
            testNG.addListener(listener);
            testNG.run();

            printResume(testClassesList.length -1 -i);
            printTestClassMessage(testClass);
            printPassedTestMessages();
            printFailedTestMessage();
        }
        if (!testNG.hasFailure()) printSuccess();
    }


    private void printResume(int lessonsToGo) {
        System.out.println();
        int failedAndSkippedTests = listener.getFailedTests().size() + listener.getSkippedTests().size();

        if (failedAndSkippedTests > 0 && lessonsToGo >= 0) {
            System.out.println("Much to learn you still have, young padawan. But learn you will.");
            System.out.println(failedAndSkippedTests + " koans and " + lessonsToGo + " more lessons apart from enlightenment you are.");
        }
    }

    private void printTestClassMessage(Class<?> testClass) {
        System.out.println();
        System.out.println(testClass.getSimpleName() + " one should.");
    }

    private void printPassedTestMessages() {
        List<ITestResult> passedTests = listener.getPassedTests();

        for (ITestResult result: passedTests) {
            System.out.println("\tThinking " + result.getName() + " has expanded your awareness.");
        }
    }

    private void printFailedTestMessage() throws NotFoundException, ClassNotFoundException {
        List<ITestResult> failedTests = listener.getFailedTests();

        for (ITestResult singleTestResult: failedTests) {
            System.out.println("\tBeing misguided " + singleTestResult.getName() + " has damaged your karma!");
            System.out.println("\tPlease medidate on " + createLink(singleTestResult) + ".");
            System.out.println("\t(" + singleTestResult.getThrowable().getMessage() + ")");
        }
    }

    private void printSuccess() {
        System.out.println();
        System.out.println("Congratulations, my young padawan! Enlightenment you have reached! May the force be with you.");
    }

    /**
     * Returns a string matching the pattern <QualifiedClassName> (<SimpleClassName>.java:<LineNumber>)
     * with is interpreted as a link to the source code by IDEA.
     */
    private String createLink(ITestResult failedTestResult) throws NotFoundException, ClassNotFoundException {
        String testClassFullName =  failedTestResult.getTestClass().getName();
        String testClassSimpleName = Class.forName(testClassFullName).getSimpleName();

        Method m = failedTestResult.getMethod().getConstructorOrMethod().getMethod();
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(m.getDeclaringClass().getCanonicalName());
        CtMethod javassistMethod = cc.getDeclaredMethod(m.getName());
        int lineNumber = javassistMethod.getMethodInfo().getLineNumber(0);

        return testClassFullName + " (" + testClassSimpleName + ".java:" + lineNumber + ")";
    }
}
