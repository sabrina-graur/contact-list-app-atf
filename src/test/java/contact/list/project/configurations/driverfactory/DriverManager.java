package contact.list.project.configurations.driverfactory;

import contact.list.project.configurations.properties.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserProperty.getBrowserProperty();
        }
        return driver;
    }

    public static void openAndMaximizeBrowser() {
        getDriver().manage().window().maximize();
        LogManager.getLogger().info("Browser is launched and maximized");
    }

    public static void openBasePage() {
        getDriver().get(PropertiesManager.getBaseUrl());
    }

    public static void clearBrowserCache() {
        getDriver().manage().deleteAllCookies();
        LogManager.getLogger().info("Cash was cleared");
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
