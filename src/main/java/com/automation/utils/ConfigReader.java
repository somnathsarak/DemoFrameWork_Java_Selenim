package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader utility class for reading properties from config file
 */
public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/main/resources/config.properties"
            );
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Error loading config.properties: " + e.getMessage());
        }
    }

    /**
     * Get property value by key
     * @param key - Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get Base URL from properties
     * @return Base URL
     */
    public static String getBaseURL() {
        return getProperty("base.url");
    }

    /**
     * Get Browser from properties
     * @return Browser name
     */
    public static String getBrowser() {
        return getProperty("browser");
    }

    /**
     * Get Username from properties
     * @return Username
     */
    public static String getUsername() {
        return getProperty("username");
    }

    /**
     * Get Password from properties
     * @return Password
     */
    public static String getPassword() {
        return getProperty("password");
    }

    /**
     * Get Explicit Wait Timeout from properties
     * @return Timeout in seconds
     */
    public static long getExplicitWait() {
        String timeout = getProperty("explicit.wait");
        return timeout != null ? Long.parseLong(timeout) : 10;
    }

    /**
     * Get Implicit Wait Timeout from properties
     * @return Timeout in seconds
     */
    public static long getImplicitWait() {
        String timeout = getProperty("implicit.wait");
        return timeout != null ? Long.parseLong(timeout) : 10;
    }

    /**
     * Get Report Path from properties
     * @return Report path
     */
    public static String getReportPath() {
        return getProperty("report.path");
    }
}
