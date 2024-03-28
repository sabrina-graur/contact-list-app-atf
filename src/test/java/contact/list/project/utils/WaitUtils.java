package contact.list.project.utils;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import contact.list.project.configurations.driverfactory.DriverManager;

import java.time.Duration;

public class WaitUtils {

    public static boolean isElementDisplayed(By elementLocator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            return element.isDisplayed();
        } catch (Exception e) {
            assert element != null;
            return !element.isDisplayed();
        }
    }
}

