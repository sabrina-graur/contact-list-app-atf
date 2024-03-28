package contact.list.project.ui.pages;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.ui.steps.CommonSteps;
import contact.list.project.utils.DataGenerator;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SignUpPage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(SignUpPage.class);
    public static By firstNameInput = By.xpath("//input[@id='firstName']");
    public static By lastNameInput = By.xpath("//input[@id='lastName']");
    public static By cancel = By.id("cancel");

    public static void addUser() {
        CommonSteps.populateField(firstNameInput, DataGenerator.generateRandomAlphabeticValue(4));
        LOG.info("First name field is populated");
        CommonSteps.populateField(lastNameInput, DataGenerator.generateRandomAlphabeticValue(5));
        LOG.info("Last name field is populated");
        CommonSteps.populateField(emailInput, DataGenerator.generateRandomEmail(20));
        LOG.info("Email field is populated");
        CommonSteps.populateField(passwordInput, DataGenerator.generateRandomAlphanumericValue(8));
        LOG.info("Password field is populated");
        clickSubmit();
        LOG.info("User was successfully registered");
    }

    public static void clickCancel() {
        try {
            WaitUtils.isElementDisplayed(cancel, PropertiesManager.checkElementIsDisplayedTimeout());
            WebElement cancelButton = DriverManager.getDriver().findElement(cancel);
            cancelButton.click();
            LOG.info("The Cancel button was clicked");
        } catch (Exception e) {
            LOG.error("Error clicking the Cancel button", e);
            throw new RuntimeException("Error clicking the Cancel button", e);
        }
    }
}
