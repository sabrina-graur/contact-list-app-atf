package contact.list.project.ui.pages;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private static final Logger LOG = LogManager.getLogger(CommonPage.class);

    public static By submitButton = By.id("submit");
    public static By emailInput = By.xpath("//input[@id='email']");
    public static By passwordInput = By.xpath("//input[@id='password']");

    public static void clickButton(By button) {
        try {
            WaitUtils.isClickable(button, PropertiesManager.checkElementIsDisplayedTimeout());
            WebElement element = DriverManager.getDriver().findElement(button);
            element.click();
            LOG.info("The {} button was clicked", button);
        } catch (Exception e) {
            LOG.error("Error clicking the {} button", button, e);
            throw new RuntimeException("Error clicking the " + button + " button", e);
        }
    }

    public static void clickSubmit() {
        clickButton(submitButton);
    }

    public static void populateField(By inputField, String value) {
        DriverManager.getDriver().findElement(inputField).sendKeys(value);
    }
}
