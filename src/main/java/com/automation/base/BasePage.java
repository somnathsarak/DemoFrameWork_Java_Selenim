package com.automation.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    private static final int TIMEOUT = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    // Click on an element
    public void click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            logger.info("Clicked on element: " + locator);
        } catch (Exception e) {
            logger.error("Error clicking element: " + locator, e);
            throw e;
        }
    }

    // Send keys to an element
    public void sendKeys(By locator, String text) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
            logger.info("Sent text: " + text + " to element: " + locator);
        } catch (Exception e) {
            logger.error("Error sending keys to element: " + locator, e);
            throw e;
        }
    }

    // Get text from an element
    public String getText(By locator) {
        try {
            String text = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
            logger.info("Retrieved text: " + text + " from element: " + locator);
            return text;
        } catch (Exception e) {
            logger.error("Error getting text from element: " + locator, e);
            throw e;
        }
    }

    // Check if element is present
    public boolean isElementPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(locator);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            logger.info("Element present: " + locator);
            return true;
        } catch (NoSuchElementException e) {
            logger.warn("Element not present: " + locator);
            return false;
        }
    }

    // Wait for element to be visible
    public WebElement waitForElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element is visible: " + locator);
            return element;
        } catch (Exception e) {
            logger.error("Error waiting for element: " + locator, e);
            throw e;
        }
    }

    // Select dropdown by visible text
    public void selectDropdown(By locator, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            Select select = new Select(element);
            select.selectByVisibleText(value);
            logger.info("Selected: " + value + " from dropdown: " + locator);
        } catch (Exception e) {
            logger.error("Error selecting dropdown: " + locator, e);
            throw e;
        }
    }

    // Get current URL
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: " + url);
        return url;
    }

    // Wait for URL to contain
    public boolean waitForUrlContains(String urlPortion) {
        try {
            boolean result = wait.until(ExpectedConditions.urlContains(urlPortion));
            logger.info("URL contains: " + urlPortion);
            return result;
        } catch (Exception e) {
            logger.error("Error waiting for URL: " + urlPortion, e);
            return false;
        }
    }
}
