package com.automation.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryAnalyzer class for retrying failed tests
 * Implements IRetryAnalyzer from TestNG
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;

    /**
     * Retry failed test up to MAX_RETRY_COUNT times
     * @param result - ITestResult object
     * @return true if test should be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            System.out.println("Retrying test '" + result.getName() + 
                             "' for the " + (retryCount + 1) + 
                             " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    /**
     * Get current retry count
     * @return retry count
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * Reset retry count
     */
    public void resetRetryCount() {
        retryCount = 0;
    }
}
