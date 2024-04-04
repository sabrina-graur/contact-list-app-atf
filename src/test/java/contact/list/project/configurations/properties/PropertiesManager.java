package contact.list.project.configurations.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class PropertiesManager {
    private static final Logger LOG = LogManager.getLogger(PropertiesManager.class);
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("properties/config.properties")) {

            if (input != null) {
                PROPERTIES.load(input);
            } else {
                LOG.error("Unable to find properties file");
            }
        } catch (IOException e) {
            LOG.error("Error loading properties file", e);
        }
    }

    private PropertiesManager() {
    }

    public static String getUsername() {
        LOG.info("Getting email from properties");
        return PROPERTIES.getProperty("email");
    }

    public static String getPassword() {
        LOG.info("Getting password type from properties");
        return PROPERTIES.getProperty("password");
    }

    public static String getBaseUrl() {
        LOG.info("Getting Base URL from properties");
        return PROPERTIES.getProperty("baseUrl");
    }

    public static String getPage(String pageName) {
        LOG.info("Getting URL from properties");
        return PROPERTIES.getProperty("baseUrl") + PROPERTIES.getProperty(pageName);
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser");
    }

    public static Duration checkElementIsDisplayedTimeout() {
        return Duration.ofSeconds(Integer.parseInt(PROPERTIES.getProperty("elementIsDisplayed")));
    }

    public static String getDriverPath(String driverName) {
        LOG.info("Getting driver path for browser: {}", driverName);
        return switch (driverName) {
            case "chrome" -> PROPERTIES.getProperty("chromeDriverPath");
            case "firefox" -> PROPERTIES.getProperty("firefoxDriverPath");
            case "edge" -> PROPERTIES.getProperty("edgeDriverPath");
            default -> {
                LOG.error("Unsupported browser type: {}", driverName);
                throw new IllegalArgumentException("Unsupported browser type");
            }
        };
    }
}
