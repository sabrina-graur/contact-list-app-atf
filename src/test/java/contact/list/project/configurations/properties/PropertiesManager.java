package contact.list.project.configurations.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class PropertiesManager {
    private static final Logger LOG = LogManager.getLogger(PropertiesManager.class); //рефлексия, мол логер ссылает на этот класс внутри класса
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("properties/config.properties")) {//try with resources, to not wrote finally, to close here
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
    } //чтобы невозможно было создать объект класса

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("baseUrl");
    }

    public static String getPage(String pageName) {
        String pageUrl = getBaseUrl() + PROPERTIES.getProperty(pageName);
        LOG.info("The page URL is retrieved from the properties: " + pageUrl);
        return pageUrl;
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser");
    }

    public static Duration checkElementIsDisplayedTimeout() {
        return Duration.ofSeconds(Integer.parseInt(PROPERTIES.getProperty("elementIsDisplayed")));
    }
}
