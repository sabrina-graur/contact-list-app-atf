package contact.list.project.hooks;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.configurations.screenshots.ScreenshotConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ExecutionHooks {
    private static final Logger LOG = LogManager.getLogger(ExecutionHooks.class);

    @Before("@UI")
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        LOG.info("Browser is launched and maximized");
        ScenarioContext.getInstance().saveData(ScenarioKey.WEB_DRIVER, driver);
    }

    @After("@UI")
    public void tearDown() {
        DriverManager.closeDriver();
        ScenarioContext.getInstance().clearData();
        LOG.info("Test is finished. Browser closed");
    }

    @AfterStep("@UI")
    public void takeScreenshot() {
        ScreenshotConfiguration.captureScreenshot();
    }
}

