package contact.list.project.utils;

import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForElementToBeDisplayed(WebElement elementLocator, Duration timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER), timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(elementLocator));
        } catch (Exception e) {
            throw new RuntimeException("Failed to wait for element to be displayed.", e);
        }
    }

    public static void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER), timeoutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred: " + e.getMessage(), e);
        }
    }
}
