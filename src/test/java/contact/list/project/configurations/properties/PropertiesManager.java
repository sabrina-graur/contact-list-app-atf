package contact.list.project.configurations.properties;

import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class PropertiesManager {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("properties/config.properties")) {
            if (input != null) {
                PROPERTIES.load(input);
            } else {
                LogManager.getLogger().error("Unable to find properties file");
            }
        } catch (IOException e) {
            LogManager.getLogger().error("Error loading properties file", e);
        }
    }

    private PropertiesManager() {
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("BROWSER");
    }

    public static String getProperty(String propertyName, String logMessage) {
        String propertyValue = PROPERTIES.getProperty(propertyName);
        if (propertyValue != null) {
            LogManager.getLogger().info("Extract {}: {}", logMessage, propertyValue);
            return propertyValue;
        } else {
            LogManager.getLogger().warn("{} is null or not found in the properties file", logMessage);
            throw new NullPointerException(logMessage + " is null or not found in the properties file");
        }
    }

    public static String getBaseUrl() {
        return getProperty("BASE_URL", "Base URL");
    }

    public static String getEmailRegex() {
        return getProperty("EMAIL_PATTERN.regexp", "Email regex");
    }

    public static String getUserNameRegex() {
        return getProperty("NAME_PATTERN.regexp", "Name regex");
    }

    public static String getPasswordRegex() {
        return getProperty("PASSWORD_PATTERN.regexp", "Password regex");
    }

    public static String getMediaType() {
        return getProperty("MEDIA_TYPE", "Media type");
    }

    public static String getTimePattern() {
        return getProperty("TIME_PATTERN", "Time Pattern");
    }

    public static String getTimePatternForMap() {
        return getProperty("TIME_PATTERN_FOR_FOLDER", "Time pattern for a map generation");
    }

    public static Duration checkElementIsDisplayedTimeout() {
        String propertyValue = PROPERTIES.getProperty("DISPLAYED_ELEMENT_TIMEOUT");
        try {
            return Duration.ofSeconds(Integer.parseInt(propertyValue));
        } catch (NumberFormatException | NullPointerException e) {
            LogManager.getLogger().warn("Invalid or missing displayedElementTimeout value in properties. Using default value - 5 seconds.");
            return Duration.ofSeconds(5);
        }
    }
}
