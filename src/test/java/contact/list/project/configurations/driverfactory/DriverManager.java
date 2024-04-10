package contact.list.project.configurations.driverfactory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
        driver = BrowserProperty.getBrowserProperty();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new DriverManager();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
