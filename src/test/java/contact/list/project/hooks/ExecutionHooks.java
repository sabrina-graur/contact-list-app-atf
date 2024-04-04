package contact.list.project.hooks;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.screenshots.ScreenshotConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class ExecutionHooks {

    @Before("@UI")
    public static void setUp() {
        DriverManager.getDriver();
    }

    @After("@UI")
    public static void tearDown() {
        DriverManager.closeDriver();
    }

    @AfterStep("@UI")
    public void takeScreenshot() {
            ScreenshotConfiguration.captureScreenshot();
    }
}

