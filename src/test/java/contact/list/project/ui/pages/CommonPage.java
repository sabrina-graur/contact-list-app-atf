package contact.list.project.ui.pages;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CommonPage {

    private static final Logger LOG = LogManager.getLogger(CommonPage.class);

    private By pageTitle = By.xpath("//body//h1[1]");
    public static By submit = By.id("submit");
    public static By emailInput = By.xpath("//input[@id='email']");
    public static By passwordInput = By.xpath("//input[@id='password']");

    public static void clickSubmit() {
        try {
            WaitUtils.isElementDisplayed(submit, PropertiesManager.checkElementIsDisplayedTimeout());
            WebElement submitButton = DriverManager.getDriver().findElement(submit);
            submitButton.click();
            LOG.info("The Submit button was clicked");
        } catch (Exception e) {
            LOG.error("Error clicking the Submit button", e);
            throw new RuntimeException("Error clicking the Submit button", e);
        }
    }
}
