package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.RetryAnalyzer;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * LoginTest class for testing Orange HRM login functionality
 * Contains multiple test cases for login scenarios
 */
public class LoginTest extends BaseTest {

    /**
     * TC01: Valid Login Test
     * Login with valid credentials
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed with valid credentials");
    }

    /**
     * TC02: Invalid Username Test
     * Verify error message for invalid username
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("InvalidUser", ConfigReader.getPassword());
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(), "Error message not displayed for invalid username");
    }

    /**
     * TC03: Invalid Password Test
     * Verify error message for invalid password
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), "InvalidPassword");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(), "Error message not displayed for invalid password");
    }

    /**
     * TC04: Empty Username Test
     * Verify validation for empty username field
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", ConfigReader.getPassword());
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(), "Error message not displayed for empty username");
    }

    /**
     * TC05: Empty Password Test
     * Verify validation for empty password field
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), "");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg.isEmpty(), "Error message not displayed for empty password");
    }
}
