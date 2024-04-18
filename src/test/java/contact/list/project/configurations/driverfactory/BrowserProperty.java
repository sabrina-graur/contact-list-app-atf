package contact.list.project.configurations.driverfactory;

import contact.list.project.configurations.properties.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserProperty {
    private static final Logger LOG = LogManager.getLogger(BrowserProperty.class);
    private static WebDriver driver;
    private static String browserType = PropertiesManager.getBrowser();

    public static WebDriver getBrowserProperty() {
        switch (browserType) {
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> driver = new ChromeDriver();
        }
        LOG.info("Current browser is: " + browserType);
        return driver;
    }
}
