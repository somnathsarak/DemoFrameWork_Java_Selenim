package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected ConfigReader configReader;
    private String browserType;

    @BeforeMethod
    public void setUp() {
        try {
            logger.info("========== Test Execution Started ==========");
            configReader = new ConfigReader();
            browserType = configReader.getBrowser();
            
            // Initialize WebDriver
            driver = WebDriverFactory.getDriver(browserType);
            logger.info("Browser launched: " + browserType);
            
            // Navigate to base URL
            String baseURL = configReader.getBaseURL();
            driver.navigate().to(baseURL);
            driver.manage().window().maximize();
            logger.info("Navigated to URL: " + baseURL);
            
        } catch (Exception e) {
            logger.error("Error in setUp method", e);
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
            logger.info("========== Test Execution Completed ==========");
        } catch (Exception e) {
            logger.error("Error in tearDown method", e);
        }
    }

    // Utility method to get current timestamp
    public String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return now.format(formatter);
    }

    // Utility method for waits
    public void waitForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error("Error during wait", e);
            Thread.currentThread().interrupt();
        }
    }
}
