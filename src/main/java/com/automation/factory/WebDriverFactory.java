package com.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

/**
 * WebDriverFactory class for creating WebDriver instances
 * Supports Chrome, Firefox, and Edge browsers
 */
public class WebDriverFactory {

    /**
     * Create WebDriver instance based on browser type
     * @param browserName - Browser type (chrome, firefox, edge)
     * @return WebDriver instance
     */
    public static WebDriver createDriver(String browserName) {
        WebDriver driver = null;

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFirefoxDriver();
                break;
            case "edge":
                driver = createEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser " + browserName + " is not supported");
        }

        // Set implicit wait
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    /**
     * Create Chrome WebDriver instance
     * @return WebDriver instance for Chrome
     */
    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "--start-maximized",
            "--disable-blink-features=AutomationControlled",
            "--no-sandbox",
            "--disable-dev-shm-usage"
        );

        return new ChromeDriver(options);
    }

    /**
     * Create Firefox WebDriver instance
     * @return WebDriver instance for Firefox
     */
    private static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(
            "--start-maximized",
            "-private"
        );

        return new FirefoxDriver(options);
    }

    /**
     * Create Edge WebDriver instance
     * @return WebDriver instance for Edge
     */
    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    /**
     * Close WebDriver instance
     * @param driver - WebDriver instance to close
     */
    public static void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
