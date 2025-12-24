package com.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TestListener class for listening to test execution events
 * Implements ITestListener from TestNG
 */
public class TestListener implements ITestListener {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Called before test execution
     */
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[" + LocalDateTime.now().format(dtf) + "] " +
                          "Test Started: " + result.getName());
    }

    /**
     * Called when test passes
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[" + LocalDateTime.now().format(dtf) + "] " +
                          "Test Passed: " + result.getName() +
                          " (Duration: " + (result.getEndMillis() - result.getStartMillis()) + "ms)");
    }

    /**
     * Called when test fails
     */
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[" + LocalDateTime.now().format(dtf) + "] " +
                          "Test Failed: " + result.getName());
        Throwable exception = result.getThrowable();
        if (exception != null) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    /**
     * Called when test is skipped
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[" + LocalDateTime.now().format(dtf) + "] " +
                          "Test Skipped: " + result.getName());
    }

    /**
     * Called before test suite execution
     */
    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n========== Test Suite Started: " + context.getName() + " ==========");
    }

    /**
     * Called after test suite execution
     */
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("========== Test Suite Finished: " + context.getName() + " ==========");
        System.out.println("Total Tests: " + context.getAllTestMethods().length);
        System.out.println("Passed: " + context.getPassedTests().size());
        System.out.println("Failed: " + context.getFailedTests().size());
        System.out.println("Skipped: " + context.getSkippedTests().size() + "\n");
    }
}
