package contact.list.project.hooks;

import contact.list.project.api.actions.DeleteUserActions;
import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.logger.LoggerHelper;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.screenshots.ScreenshotCaptureException;
import contact.list.project.configurations.screenshots.ScreenshotConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;

public class ExecutionHooks {

    private boolean clearUserDataExecuted = false;

    @BeforeAll
    public static void launchTests() {
        ScenarioContext.getInstance().clearData();
        ScreenshotConfiguration.deleteOldScreenshots();
    }

    @Before("@API")
    public void setUpAPI(Scenario scenario) {
        LoggerHelper.setLogFileName(scenario);
        LogManager.getLogger().info("Starting API test: {}", scenario.getName());
    }

    @Before("@UI")
    public void setUpUI(Scenario scenario) {
        LoggerHelper.setLogFileName(scenario);
        LogManager.getLogger().info("Starting UI test: {}", scenario.getName());
        DriverManager.openAndMaximizeBrowser();
        DriverManager.openBasePage();
    }

    @After("@DeleteAccount")
    public void clearUserData() {
        DeleteUserActions deleteUserActions = new DeleteUserActions();
        deleteUserActions.deleteAccount();
        clearUserDataExecuted = true;
    }

    @After("@API")
    public void clearDataAPI() {
        if (clearUserDataExecuted) {
            ScenarioContext.getInstance().clearData();
        }
    }

    @After("@UI")
    public void clearCash() {
        DriverManager.clearBrowserCash();
    }

    @AfterStep("@UI")
    public void takeScreenshot(Scenario scenario) throws ScreenshotCaptureException {
        ScreenshotConfiguration.captureScreenshot(scenario);
    }

    @AfterAll
    public static void closeTests() {
        DriverManager.tearDown();
        ScenarioContext.getInstance().clearData();
        LogManager.getLogger().info("Test is finished. Browser closed");
    }
}
