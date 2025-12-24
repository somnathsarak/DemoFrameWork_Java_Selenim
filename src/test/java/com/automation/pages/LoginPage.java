package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.base.BasePage;

/**
 * LoginPage class for Orange HRM Login functionality
 * Follows Page Object Model design pattern
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardElement;

    @FindBy(xpath = "//span[contains(text(),'Invalid credentials')]")
    private WebElement errorMessage;

    /**
     * Constructor
     * @param driver - WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Enter username
     * @param username - Username to enter
     */
    public void enterUsername(String username) {
        log("Entering username: " + username);
        click(usernameField);
        sendKeys(usernameField, username);
    }

    /**
     * Enter password
     * @param password - Password to enter
     */
    public void enterPassword(String password) {
        log("Entering password");
        click(passwordField);
        sendKeys(passwordField, password);
    }

    /**
     * Click login button
     */
    public void clickLoginButton() {
        log("Clicking login button");
        click(loginButton);
    }

    /**
     * Perform login
     * @param username - Username
     * @param password - Password
     */
    public void login(String username, String password) {
        log("Performing login with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Check if login is successful
     * @return true if dashboard is displayed, false otherwise
     */
    public boolean isLoginSuccessful() {
        try {
            waitForVisibility(dashboardElement);
            log("Login successful - Dashboard is displayed");
            return true;
        } catch (Exception e) {
            log("Login failed - Dashboard not visible");
            return false;
        }
    }

    /**
     * Get error message
     * @return error message text
     */
    public String getErrorMessage() {
        try {
            waitForVisibility(errorMessage);
            String message = errorMessage.getText();
            log("Error message displayed: " + message);
            return message;
        } catch (Exception e) {
            log("No error message found");
            return "";
        }
    }
}
