package contact.list.project.configurations.driverfactory;

import contact.list.project.configurations.properties.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final Logger LOG = LogManager.getLogger(DriverManager.class);
    private static WebDriver driver;

    public static WebDriver getDriver() {

        String browserName = PropertiesManager.getBrowser();
        try {
            if (driver == null) {
                String browserType = System.getProperty("browser", browserName).toLowerCase();;
                switch (browserType) {
                    case "chrome" -> {
                        System.setProperty("webdriver.chrome.driver", PropertiesManager.getDriverPath(browserType));
                        driver = new ChromeDriver();
                    }
                    case "firefox" -> {
                        System.setProperty("webdriver.gecko.driver", PropertiesManager.getDriverPath(browserType));
                        driver = new FirefoxDriver();
                    }
                    case "edge" -> {
                        System.setProperty("webdriver.edge.driver", PropertiesManager.getDriverPath(browserType));
                        driver = new EdgeDriver();
                    }
                    default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
                }
                driver.manage().window().maximize();
                LOG.info("Initialized WebDriver: {}", browserType);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error initializing WebDriver: " + e.getMessage());
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOG.info("Browser is closed");
        } else {
            LOG.warn("Driver is already closed or not initialized");
        }
    }
}
